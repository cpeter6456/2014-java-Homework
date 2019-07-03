package myjava.homework.maze;
import java.io.*;
import java.util.*;

public class MazaMain {
	
	public static void main(String[] args)  throws IOException{
		// TODO Auto-generated method stub
		FileReader fin=new FileReader("info");
	    Scanner file_scanner=new Scanner(fin);
	    Scanner key_board = new Scanner(System.in);
	    int max_node = file_scanner.nextInt();
	    //System.out.printf("%d \n",max_node );
	    
	    /** 當初忘了 java裡用array的話 也要用new  結果用Arraylist做後來才改回來 **/
	    MyLinkList mylist_array []=new MyLinkList[max_node];
	    for(int i=0;i<max_node;i++)
	    {
	    	MyLinkList temp=new MyLinkList();
	    	mylist_array[i] =temp;
	    }
	    while(file_scanner.hasNextInt() )
	    {
	    	
	    	int a = file_scanner.nextInt();
	    	int b = file_scanner.nextInt();
	    	//System.out.printf("%d %d\n",a,b );
	    	
	    	mylist_array[a].add_node_at_end(b);
	    	mylist_array[b].add_node_at_end(a);
	    	    	
	    }//End of while
	    //test
	    /**
	    for(int i=0;i<max_node;i++)
		{
			System.out.printf("AT Node %3d :",i);
			for(Node temp=mylist_array[i].firstnode;temp!=null;temp=temp.next)
				System.out.printf("%d ",temp.value );
			System.out.printf("\n");
		}**/
	    int star,finish,type;
		System.out.printf("Please input star node:");
		star = key_board.nextInt();
		System.out.printf("Please input finish node:");
		finish =  key_board.nextInt();
		System.out.printf("Please input a command (1.auto search(using DFS) 2.manual search path: )");
		type =  key_board.nextInt();
		if(type ==1)//using dfs 
		{
			Stack<Integer> st = new Stack<Integer>();
			st.push(star);
			int temp=star;
		
			boolean had[]= new boolean[max_node];//初始都false
			had[temp]=true;
			while(temp!=finish && !st.empty())
			{
				//System.out.printf("temp=%d\n",temp);
				Node t;
				for( t = mylist_array[temp].firstnode ;t!=null;t=t.next)
				{
					if(!had[t.value])
					{
						had[t.value]=true;
						break;
					}
				}
				if(t!=null)
				{
					temp=t.value;
					st.push(t.value);
				}
				else
				{
					st.pop();
					if(!st.empty())
					temp=st.peek();
				}
			}//end of while
			
			if(temp == finish)//find
			{
				Stack<Integer> st2 = new Stack<Integer>();
				while(!st.empty())
				{
					
					st2.push(st.peek());
					st.pop();				
				}
				boolean flag=false;
				while(!st2.empty())
				{
					if(flag)
						System.out.printf("->%d",st2.peek());
					else
						System.out.printf("%d",st2.peek());
					flag=true;
					st2.pop();				
				}
			}
			else
				System.out.printf("Path not found\n");
			
			
		}//end of dfs
		else if(type ==2)
		{
			int tt = star;
			while(tt!=finish)
			{
				System.out.printf("You are in node %d. You can go",tt);
				for(Node temp=mylist_array[tt].firstnode;temp!=null;temp=temp.next)
					System.out.printf(" '%d'",temp.value );
				System.out.printf(" .\n");
				System.out.printf("Please input enter next node:");
				tt =  key_board.nextInt();
			}
			if(tt==finish)
				System.out.printf("Arrival!!\n");
		}
		else
			System.out.printf("out of range(1,2 \n");
		
		key_board.close();file_scanner.close();
	}

}
