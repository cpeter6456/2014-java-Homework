package myjava.homework.worldindex;
import java.io.*;
import java.util.*;



public class WordIndexMain {

	public static void main(String[] args) throws IOException {
		String filename ="record";
		TextFile textfile=new TextFile(filename,"\\W+");
		
		Map<String,ArrayList<Integer>> my_map=new TreeMap<String,ArrayList<Integer>>();
	
		String st_string=textfile.read(filename);
		//System.out.printf("%s",st_string);
		//System.out.printf("\n");
		String string_array[]=st_string.split(" |\n") ;//spilt 多分隔用 | 來連接= =....
		
		//for(int i=0;i<string_array.length;i++)
		//	System.out.printf("%s ",string_array[i]);
		//System.out.println();
		int len=string_array.length;
		
		
		
		int had_len=0;
		String had[] =new String[len];
		for(int temp1=0;temp1<len;temp1++)
		{
			//System.out.printf("\n!!%2d !!",temp1);
			
			boolean had_flag=false;
			if(had_len==0)
				had[had_len]=new String ( string_array[temp1]);
			else
			{
				for(int i=0;i<had_len;i++)
					if(had[i].equals(string_array[temp1]))
					{
						had_flag=true;
						break;
					}
				if(had_flag)
					continue;
				else
					had[had_len]= string_array[temp1];
			}
			ArrayList<Integer> num=new ArrayList<Integer>();
			for(int i=temp1;i<len;i++)
			{
				if(string_array[temp1].equals(string_array[i]))
					num.add(i+1);
				
			}
			
			
			
			
			my_map.put(string_array[temp1], num);
			had_len++;
		}
		
		//keySet 是所有的key 的集合,此for 會把每個set的元素都給跑一次
		System.out.println("Numbers of word:");
		for(String key: my_map.keySet())
			   System.out.println("'"+key+"'" + "\t\t:" + my_map.get(key).size());
		 System.out.println();
		
		 System.out.printf("Map of word locations:");
		 System.out.printf("{");
		 
		 for(int i=0;i<had_len;i++)
		 {
			 System.out.print(had[i]+"="+ my_map.get(had[i]));
			 if(i!=had_len-1) System.out.printf(", ");
		 }
		 System.out.printf("}\n\n");
		 
		 System.out.printf("Ordered location, words: {");
		 for(int i=0;i<len;i++)
		 {
			 System.out.printf("%d=%s",i+1,string_array[i]);
			 if(i!=len-1) System.out.printf(", ");
		 }
		 System.out.printf("}\n");
		//my_map.put(key, value)
		
	}

}
