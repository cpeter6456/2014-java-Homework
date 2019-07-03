package myjava.homework;

import java.io.*;
import java.net.*;
import java.util.*;


public class Server {

	
	public static void main(String[] args)  throws IOException, InterruptedException  {
		// TODO Auto-generated method stub
		System.out.printf("Port:");
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int portnumber = Integer.valueOf( buf.readLine() );
		
		/**IP address is Local Host**/
		
		
		
		ServerThread st = new ServerThread(portnumber);
		st.start();
	}

}