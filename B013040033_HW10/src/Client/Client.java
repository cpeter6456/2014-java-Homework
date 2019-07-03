package Client;
import java.io.*;
import java.net.Socket;
public class Client {
	public static void main(String[] args)throws IOException, InterruptedException {
	
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		System.out.printf("Host:");
		String server_address = buf.readLine();
		System.out.printf("Port:");
		int portnumber = Integer.valueOf( buf.readLine() );
		Socket  server=new Socket (server_address,portnumber);
		
		System.out.printf("\nConnected\n");
		
		
		BufferedReader in=new BufferedReader(new InputStreamReader(server.getInputStream()));

		PrintWriter out=new PrintWriter(server.getOutputStream());
		 
	    System.out.printf("\n__START__\n");
	    while(true)
	    {
	    	String str="";
	    	
	    	if(in.ready())
			{
	    		 
				str=in.readLine();
				System.out.println("[server]"+str);
				
				out.flush();
			}
	    	else if(buf.ready()){
		    	
	    		str = buf.readLine();
		    	out.println(str);
		    	out.flush();
	    	}
	    	if(str.endsWith("_QUIT"))
	    		break;
	    	
	    	Thread.sleep(500);
	    	//System.out.println("[Server]"+in.readLine());
	    }
	    System.out.printf("\nDisconnection\n");
	    server.close();
	}
	
	
	
}
