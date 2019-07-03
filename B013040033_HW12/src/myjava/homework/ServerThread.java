package myjava.homework;
import java.net.*;
import java.io.*;
import java.util.*;
public class ServerThread extends Thread{//use thread to accept client 

	public BroadCastThread broad = new BroadCastThread();
	public int portnumber;
	public ServerSocket myServer;
	public ServerThread(int num){
		portnumber=num;
		try {
			myServer = new	ServerSocket(portnumber);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.printf("Open port %d successfully\n",portnumber);
		broad.start();

	}
	
	public void run(){
		System.out.printf("Open ServerThread successfully\n");
		Socket clientSkt = null; // 客戶端Socket
		ListenFromClient client = null; // 客戶端連線
		
		while(true)
		{
			System.out.println("Wait for client");
            try {
				clientSkt = myServer.accept();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            client= new ListenFromClient(clientSkt, broad);
            client.start();
            System.out.println("One client come");
		}
		
	}
	
	
}
