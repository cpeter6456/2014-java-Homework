package myjava.homework;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.*;
import java.net.*;
public class Client extends JFrame implements WindowListener{

	public  receive_thread rec;
//	public  send_thread send;
	static boolean flag=false;
	String server_address  ,name;
	int portnumber;
	Socket server_socket;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private TextArea temp_message;
    private PrintStream  writer=null;  
    private BufferedReader reader;  
    boolean isConnected=false;
    boolean isInGroup=false;
    static Client frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Client();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public Client() {
		 this.addWindowListener(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
	
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("PORT");
		lblNewLabel.setFont(new Font("PMingLiU", Font.PLAIN, 12));
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("IP_address");
		panel.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		panel.add(textField_1);
		textField_1.setColumns(30);
		
		JLabel lblNewLabel_2 = new JLabel("nickname");
		lblNewLabel_2.setFont(new Font("新細明體", Font.PLAIN, 16));
		
		panel.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("connect");
		
		/**try to connect **/
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(isConnected){JOptionPane.showMessageDialog(frame, "don't connect repeat!",  
                        "ERROR ", JOptionPane.ERROR_MESSAGE);
				}
                try {  
                    try {  
                    	portnumber = Integer.parseInt(textField.getText().trim());  
                    } catch (NumberFormatException e2) {  
                        throw new Exception("port need int!");  
                    }  
                    String hostIp = textField_1.getText().trim();  
                    String name = textField_2.getText().trim();  
                    if (name.equals("") || hostIp.equals("")) {  
                        throw new Exception("name , IP address should not null!");  
                    }  
                    boolean flag = connectServer(portnumber, hostIp, name);  
                    if (flag == false) {  
                    	
                        throw new Exception("connect error!");  
                    }  
                    frame.setTitle(name);  
                    JOptionPane.showMessageDialog(frame, "connected!");  
                } catch (Exception exc) {  
                    JOptionPane.showMessageDialog(frame, exc.getMessage(),  
                            "ERROR", JOptionPane.ERROR_MESSAGE);  
                }  
            }  
    });  
		
		btnNewButton_2.setFont(new Font("新細明體", Font.PLAIN, 18));
		panel.add(btnNewButton_2);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		temp_message = new TextArea();
		temp_message.setPreferredSize(new Dimension(600,400));
		temp_message.setEditable(false);
		
		temp_message.setText("THIS is  message\r\n\r\nYou should check your port,server ip,nickname and put connect\r\n\r\nif you connect successful we were send Group List to you\r\n\r\nand you must select one or create one in lower textField\r\n\r\nand put GO!!!!\r\n");
		panel_1.add(temp_message);
		
		Panel panel_2 = new Panel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		textField_3 = new JTextField();
		panel_2.add(textField_3);
		textField_3.setColumns(33);
		
		JButton btnNewButton = new JButton("GO!!!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendMessage(textField_3.getText()); 
				textField_3.setText("");
			}
		});
		panel_2.add(btnNewButton);
		
		
		//contentPane.remove(panel_1);
		//contentPane.remove(panel_2);
	}
	public boolean connectServer(int port, String hostIp, String name) {  
        // 连接服务器  
        try {  
        	server_socket = new Socket(hostIp, port);// 根据端口号和服务器ip建立连接  
            writer = new PrintStream (server_socket.getOutputStream(), false,
            	    "UTF-8");  
            reader = new BufferedReader(new InputStreamReader(server_socket  
                    .getInputStream(),"UTF-8"));  
            // 发送客户端用户基本信息(用户名)  
            sendMessage(name);  
            // 开启接收消息的线程  
            rec = new receive_thread(server_socket);  
            rec.start();  
            isConnected = true;// 已经连接上了  
            return true;  
        } catch (Exception e) {  
            temp_message.append("port：" + port + "    IP：" + hostIp  
                    + "  connect error!" + "\r\n");  
            isConnected = false;// 未连接上  
            return false;  
        }  
    }  
	public void sendMessage(String message) {  
		if(writer!=null){
	        writer.println(message);  
	        writer.flush();  
		}
    } 
	
public class receive_thread extends Thread{
		
		public Socket server_socket;
		
		public receive_thread(Socket sev_socket){
			server_socket=sev_socket;
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				BufferedReader buf = new BufferedReader(new InputStreamReader(server_socket.getInputStream(),"UTF-8"));
			
				while(true)
				{
					if(flag)break;
					String from_sev = buf.readLine() ;
					if(flag)break;
					//System.out.println("read from server successful");
					if(from_sev!=null){
						if(from_sev.equals("幹"))
							temp_message.append(from_sev+"WTF"+"\r\n");
						temp_message.append(from_sev+"\r\n");
						 //System.out.println(from_sev);
						 
					}
					
				}
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("end rec");
			}
			System.out.println("the end rec");
			
		}
		
	}
	/**
	public  class send_thread extends Thread{
		public Socket server_socket;
		
		PrintStream SendToServer=null;
		public send_thread(Socket sev_socket) throws IOException{
			server_socket=sev_socket;
		
			SendToServer = new PrintStream(server_socket.getOutputStream());
		}
		public void send(String masssage){  
			if(SendToServer!=null){
		        SendToServer.println(masssage);
				SendToServer.flush();  
			}
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
				if(t.equals("EXIT")){
					try {
						sleep(3);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}
			}
			System.out.println("end send");
			flag=true;
		}
		
	}**/

	@Override
	public void windowActivated(WindowEvent e) {}
	@Override
	public void windowClosed(WindowEvent e) {}
	@Override
	public void windowClosing(WindowEvent e) {
		sendMessage("EXIT");
		//JOptionPane.showMessageDialog(this,"是否关闭当前窗口?");
		JOptionPane.showMessageDialog(this,"is closing now");
	}
	@Override
	public void windowDeactivated(WindowEvent e) {}
	@Override
	public void windowDeiconified(WindowEvent e) {}
	@Override
	public void windowIconified(WindowEvent e) {}
	@Override
	public void windowOpened(WindowEvent e) {}
}
