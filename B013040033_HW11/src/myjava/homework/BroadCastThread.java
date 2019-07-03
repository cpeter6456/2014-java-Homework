package myjava.homework;
import java.net.*;
import java.io.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class BroadCastThread extends Thread{
	
	// i use ConcurrentHashMap because HashMap will throw  java.util.ConcurrentModificationException 
	
	public ConcurrentHashMap<String, Vector<ListenFromClient>> group_member = new ConcurrentHashMap<String, Vector<ListenFromClient>>();
	public ConcurrentHashMap<String, Vector<String>> group_massage = new ConcurrentHashMap<String, Vector<String>>();

	//public HashMap<String, Vector<ListenFromClient>> group_member = new HashMap<String, Vector<ListenFromClient>>();
	//public HashMap<String, Vector<String>> group_massage = new HashMap<String, Vector<String>>();
	
	//public HashMap<String, String> client_to_group = new HashMap<String, String>();
	
	public BroadCastThread(){
		setDaemon(true);
	}
	public void addClientThread(ListenFromClient client,int type) {
        // 將客戶端add至處理佇列
		if(type==1){
			Vector<ListenFromClient> temp= new Vector<ListenFromClient>();
			temp.add(client);
			group_member.put(client.ItGroup, temp);
			
			Vector<String> s= new Vector<String>();
			s.addElement(client.nickName+" creat the group "+client.ItGroup);
			group_massage.put(client.ItGroup, s);
			
		}
		else if(type==2){
			Vector<ListenFromClient> temp = group_member.get(client.ItGroup);
			temp.add(client);
		}
		else{}
		
    }
	public void removeClientThread(ListenFromClient client) {
        // 移除客戶端
		Vector<ListenFromClient> temp = group_member.get(client.ItGroup);
		Iterator<ListenFromClient> it= temp.iterator();
		while(it.hasNext()){
			ListenFromClient c_temp=it.next();
			if(c_temp.equals(client))
			{
				it.remove();
			}
		}
		if(temp.size()==0)
		{
			group_member.remove(client.ItGroup);
			//group_massage.remove(client.ItGroup);
		}
		
    }
	public void addMessage(String message,String Group){
		Vector<String> t= group_massage.get(Group);
		t.addElement(message);
	}
	
	
	public void run() {
		System.out.printf("Open BroadCastThread successfully\n");
		ListenFromClient client = null;
        String message = null;
		
        while(true)
        {
        	//if i use loop,not use iterator
        	//it maybe  java.util.ConcurrentModificationException
        	//it means 当使用 fail-fast iterator 对 Collection 
        	//或 Map 进行迭代操作过程中尝试直接修改 Collection / Map 的内容时
        	//即使是在单线程下运行，   java.util.ConcurrentModificationException 异常也将被抛出。

        	//so need iterator,because
        	//　Iterator 是工作在一个独立的线程中，并且拥有一个 mutex 锁。
        	//or use the ConcurrentHashMap 它支持在运行时修改集合对象。
        	for(String t_group:group_massage.keySet()){
        		if( ! group_massage.get(t_group).isEmpty())
        		{
        			Iterator<String> it_s = group_massage.get(t_group).listIterator();
        			while(it_s.hasNext())
        			{
        				message = it_s.next();
        				for(int i=0; group_member.containsKey(t_group) && i<group_member.get(t_group).size();i++)
        				{
        					client = group_member.get(t_group).elementAt(i);
        					client.sendMessage(message);
        					
        				}
        				it_s.remove();
        			}
        			
        		}
        	
        	}
        }
		
	}
	
	
}
