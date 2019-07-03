package Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
public class Server {
	public static void main(String[] args)throws IOException, InterruptedException {
		
		
		System.out.printf("Port:");
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		
		int portnumber = Integer.valueOf( buf.readLine() );
		
		
		ServerSocket myserver = new	ServerSocket(portnumber);
		System.out.printf("Open port %d successfully\n",portnumber);
		//server���ձ�����LSocket���s���ШD�Aserver��accept��k�O���릡��  
	    Socket mysocket = myserver.accept();  
	    System.out.printf("Client accept\n");
	    //��Ȥ�ݫإߦn�s������A�ڭ̴N�i�H���socket��InputStream�A�ñq��Ū���Ȥ�ݵo�L�Ӫ��H���F�C
	
	    BufferedReader in
	    =new BufferedReader(new InputStreamReader (mysocket.getInputStream()));
	     
	    PrintWriter out=new PrintWriter(mysocket.getOutputStream());
		      
	    System.out.printf("\n__START__\n");
		while(true)
		{	
			String str="";
			if(in.ready())
			{
				 
				str=in.readLine();
				System.out.println("[client]"+str);
				out.flush();
			}
			else if(buf.ready()){
				 
				str=buf.readLine();
				out.println(str);
		    	out.flush();
			}
			if(str.equals("_QUIT"))
				break;
			Thread.sleep(500);
		}
		 System.out.printf("\nDisconnection\n");
		
		mysocket.close();
	}
	
	
}
