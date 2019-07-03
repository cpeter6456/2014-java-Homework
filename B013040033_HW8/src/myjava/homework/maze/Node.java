package myjava.homework.maze;

public class Node {

	Node next;
	int value;
	public Node(int v,Node t2)
	{
		this.value=v;
		next=t2;
	}
	public int get_value()
	{
		
		return this.value;
	}
	public Node get_next()
	{
		
		return this.next;
	}
	
	
}
