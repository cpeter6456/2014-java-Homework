package myjava.homework.maze;

public class MyLinkList {
	public Node firstnode;
    public Node lastnode;
    public MyLinkList()
    {
    	firstnode=lastnode=null;
    }
    public void add_node_at_end(int value)
    {
    	
    	if(firstnode==lastnode && lastnode ==null)
    	{
    		
    		firstnode=lastnode=new Node(value,null);
    	}
    	else
    	{
    		
    		lastnode.next=new Node(value,null);
    		lastnode=lastnode.next;
    	}
    }
    public int my_size()
    {
    	Node temp =firstnode;
    	int t=0;
    	while(temp!=null)
    	{
    		t++;
    		temp=temp.next;
    	}
    	return t;
    }
    public void delete_end(){//not good delete
    	int size=my_size();
    	if(size>1)
    	{
    		Node temp=this.firstnode;
    		for(temp=this.firstnode;temp!=null&&temp.next!=null&&temp.next.next!=null;temp=temp.next);
    		this.lastnode=temp;
    	}
    	
    }
   
}
