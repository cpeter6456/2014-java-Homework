package myjava.homework;

import java.io.*;
public class B013043300_HW1_Part2 {
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		
		System.out.println("Please input customer¡¦s name:"); 
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in)); 
		FileReader fr = new FileReader("src/myjava/homework/bill.dat" );
 		BufferedReader inputFile = new BufferedReader(fr);
 		
 		
 		
        String name = buf.readLine(); 
        //System.out.println("name: "+name); 
		System.out.println("Please input member id: "); 
		String id = buf.readLine(); 
		//System.out.println("id: "+id); 
		
		System.out.println("[shopping bill]"); 
		System.out.println("customer: "+name+"("+id+")"); 

		System.out.printf("%-30s %-15s %-15s %-15s\n","Product","Quantity","Price","Total" );
		String temp1 ; 
		double all=0;
		while((temp1 = inputFile.readLine()) !=null)
		{
			String[] starray = temp1.split(";");
			for (int i = 0; i < starray.length;)
			{
				Integer quantity = Integer.valueOf(starray[i+1]);
				Double price = Double.valueOf(starray[i+2]);
				double total = quantity * price;
				all+=total;
				System.out.printf("%-30s %-15s %-15.2f %-15.2f\n",starray[i],quantity ,price,total);
				 //System.out.println(AfterSplit[i]+"\t\t\t"+ AfterSplit[i+1]+"\t"+ AfterSplit[i+2]+"\t"+total);
				 i=i+3;
				 
				 
			}
			
		}
		
		System.out.printf("%-60s   %s\n","Subtotal",all);

		System.out.printf("%-60s   %s\n","12.5% sales tax",all*0.125);

		System.out.printf("%-60s   %s\n","Total",all*1.125);
		inputFile.close();
		
	}
	
}