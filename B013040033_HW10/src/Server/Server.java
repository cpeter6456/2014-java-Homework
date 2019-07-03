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
		//server嘗試接收其他Socket的連接請求，server的accept方法是阻塞式的  
	    Socket mysocket = myserver.accept();  
	    System.out.printf("Client accept\n");
	    //跟客戶端建立好連接之後，我們就可以獲取socket的InputStream，並從中讀取客戶端發過來的信息了。
	
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
