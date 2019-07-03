package myjava.homework;
import java.net.*;
import java.io.*;
import java.util.*;
public class ListenFromClient extends Thread{
	private Socket ClientSocket;
	private BroadCastThread ServerBroad;
	private PrintStream SendToClient;
	public String ItGroup;
	public String nickName;
	private static int TotalclientNum = 0;
	
	public ListenFromClient(Socket a, BroadCastThread b){
		setDaemon(true);
		ClientSocket=a;ServerBroad=b;
		try {
			SendToClient = new PrintStream(ClientSocket.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		TotalclientNum++;
		
	}
	 
	public void sendMessage(String message) {
		 SendToClient.println(message);
	    }
	public void run() {
		System.out.printf("Open ListenFromClient successfully\n");
		BufferedReader buf = null;
		nickName = null;
		ItGroup=null;
		 try {
			buf = new BufferedReader(new
			         InputStreamReader(ClientSocket.getInputStream()));
			sendMessage("connected...please input your name");
			nickName = buf.readLine();
			if(nickName == null)
                nickName = "TempGuest"+String.valueOf(TotalclientNum);
			sendMessage("Yourname is "+nickName);
			sendMessage("Here are some group");
			String s="";
			for(String t:ServerBroad.group_member.keySet())
				s+=t+"  ";
			sendMessage(s+"  ");
			int type;
			while(true){
					sendMessage("1.Add a new group 2.join a specific group");
					type = Integer.valueOf(buf.readLine());
					
					if(type ==1){
						//need to check grop
						sendMessage("Input Group name");
						ItGroup=buf.readLine();
						for(String sss:ServerBroad.group_member.keySet())
						if(ItGroup.equals(sss))continue;
					}
					else if(type ==2){
						sendMessage("Input Group name");
						ItGroup=buf.readLine();
					}
					else sendMessage("error number please try again");
					
					if(type==1 || type ==2 )break;
			}
			//should add to ServerBroad's GroupMenber
			ServerBroad.addClientThread(this, type);
			
			sendMessage(nickName+" Join "+ItGroup+" successed");
			sendMessage("can use  'group member' to know group member");
			String userMessage; 
			while(true)
			{
				userMessage = buf.readLine();
				
				//send message to the same group
				ServerBroad.addMessage(nickName+" : "+userMessage, ItGroup);
				
				if(userMessage.equals("EXIT"))
					break;
				if(userMessage.equals("group member"))
				{
					String ss="";
					for(int i=0;i<ServerBroad.group_member.get(ItGroup).size();i++){
						ss+=" "+ServerBroad.group_member.get(ItGroup).elementAt(i).nickName;
						
					}
					sendMessage(ss);
				}
			}
			
			TotalclientNum--;
			
			//should remove
			ServerBroad.removeClientThread(this);
			
			ClientSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
