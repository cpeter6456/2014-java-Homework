package myjava.homework;

import java.io.*;
import java.net.*;
import java.util.*;
public class Client {
	public static receive_thread rec;
	public static send_thread send;
	static boolean flag=false;
	public static void main(String[] args) throws IOException, InterruptedException ,UnknownHostException  {
		// TODO Auto-generated method stub
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.printf("Host:");
		String server_address = buf.readLine();
		//String server_address = "140.117.180.70";
		System.out.printf("In Client \nPort:");
		int portnumber = Integer.valueOf( buf.readLine() );
		
		Socket server_socket=new Socket(server_address,portnumber);
		
		
		
		send_thread send =new send_thread(server_socket);
		send.start();
		
		receive_thread receive =new receive_thread(server_socket);
		receive.start();
	}
	
	
	public static class receive_thread extends Thread{
		
		public Socket server_socket;
		
		public receive_thread(Socket sev_socket){
			server_socket=sev_socket;
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				BufferedReader buf = new BufferedReader(new InputStreamReader(server_socket.getInputStream()));
				while(true)
				{
					if(flag)break;
					String from_sev = buf.readLine() ;
					if(flag)break;
					//System.out.println("read from server successful");
					if(from_sev!=null){
						 System.out.println(from_sev);
					}
					
				}
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("end rec");
			}
			System.out.println("the end rec");
			
		}
		
	}
	
	public static class send_thread extends Thread{
		public Socket server_socket;
		
		PrintStream SendToServer;
		public send_thread(Socket sev_socket) throws IOException{
			server_socket=sev_socket;
		
			SendToServer = new PrintStream(server_socket.getOutputStream());
		}
		public void send(String masssage){  
	        SendToServer.println(masssage);
			SendToServer.flush();  
	    }  
		@Override
		public void run() {
			// TODO Auto-generated method stub
			BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
			String t="";
			while( true )
			{
				try {
					t=buf.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				send(t);
				if(t.equals("EXIT"))
					break;
			}
			System.out.println("end send");
			flag=true;
		}
		
	}


}
