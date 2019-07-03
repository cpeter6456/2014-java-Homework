package myjava.homework;
import java.net.*;
import java.io.*;
import java.util.*;
public class ListenFromClient extends Thread{
	private Socket ClientSocket;
	private BroadCastThread ServerBroad;
	private PrintStream  SendToClient;
	public String ItGroup;
	public String nickName;
	private static int TotalclientNum = 0;
	
	public ListenFromClient(Socket a, BroadCastThread b){
		setDaemon(true);
		ClientSocket=a;ServerBroad=b;
		try {
			SendToClient = new PrintStream (ClientSocket.getOutputStream(),false,"UTF-8");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		TotalclientNum++;
		
	}
	 
	public void sendMessage(String message) {
		 SendToClient.println(message);
		 SendToClient.flush(); 
	    }
	public void run() {
		System.out.printf("Open ListenFromClient successfully\n");
		BufferedReader buf = null;
		nickName = null;
		ItGroup=null;
		 try {
			buf = new BufferedReader(new
			         InputStreamReader(ClientSocket.getInputStream(),"UTF-8"));
			//sendMessage("connected...please input your name");
			nickName = buf.readLine();
			if(nickName == null)
                nickName = "TempGuest"+String.valueOf(TotalclientNum);
			//sendMessage("Yourname is "+nickName);
			if(ServerBroad.group_member.isEmpty())
				sendMessage("Here are no group,please input you want to create group");
			else{
				sendMessage("Here are some groups");
				String s="";
				for(String t:ServerBroad.group_member.keySet())
					s+=t+"\r\n";
				sendMessage(s);
			}
			int type=1;
			
			ItGroup=buf.readLine();
			for(String sss:ServerBroad.group_member.keySet())
				if(ItGroup.equals(sss)){
					type=2;
					break;
			}
			
			//should add to ServerBroad's GroupMenber
			ServerBroad.addClientThread(this, type);
			
		
			ServerBroad.addMessage(nickName+" Join "+ItGroup+" successed", ItGroup);
			String ss1="Group member\n";
			for(int i=0;i<ServerBroad.group_member.get(ItGroup).size();i++){
				ss1+="\n"+ServerBroad.group_member.get(ItGroup).elementAt(i).nickName;
				
			}
			ServerBroad.addMessage(ss1, ItGroup);
			sendMessage("can use  'group member' to know group member");
			String userMessage; 
			while(true)
			{
				userMessage = buf.readLine();
				
				//send message to the same group
				ServerBroad.addMessage(nickName+" : "+userMessage, ItGroup);
				System.out.println(nickName+" : "+userMessage);
				if(userMessage.equals("·F")){System.out.println(nickName+" : WTF");}
				if(userMessage.equals("EXIT")){
					
					ServerBroad.removeClientThread(this);
					String ss=nickName +" EXIT\nand now this group have\n";
					if(ServerBroad.group_member.containsKey(ItGroup)){
						
						for(int i=0;i<ServerBroad.group_member.get(ItGroup).size();i++){
							ss+="\n"+ServerBroad.group_member.get(ItGroup).elementAt(i).nickName;
							
						}
						ServerBroad.addMessage(ss, ItGroup);
					}
					break;
				}
				if(userMessage.equals("group member"))
				{
					String ss="Group member\n";
					for(int i=0;i<ServerBroad.group_member.get(ItGroup).size();i++){
						ss+="\n"+ServerBroad.group_member.get(ItGroup).elementAt(i).nickName;
						
					}
					sendMessage(ss);
				}
				
			}
			
			TotalclientNum--;
			
			//should remove
			//ServerBroad.removeClientThread(this);
			
			ClientSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
