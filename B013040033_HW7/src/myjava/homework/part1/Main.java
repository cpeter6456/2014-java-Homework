package myjava.homework.part1;
import java.io.*;

public class Main {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		
		while(true)
		{
			System.out.printf("1) Serialize object to file\n");
			System.out.printf("2) Deserialize from file to object\n");
			System.out.printf("3) Exit\nChoose:\n");
			BufferedReader buf = new BufferedReader(new InputStreamReader(System.in)); 
			String a =buf.readLine();
			int num =Integer.valueOf(a) ;
		
			if(num==3)break;
			else if(num==2)
			{
				System.out.printf("please input file name:\n");
				String b =buf.readLine();
				File file = new File(b);
				
				System.out.printf("Reading file - %s\n",b);
				
				FileInputStream fis = new FileInputStream(file);
			    ObjectInputStream ois = new ObjectInputStream(fis);
			    try {
					DictionaryRecord t =(DictionaryRecord)ois.readObject();
					System.out.printf("%s\n%s\n",t.word,t.description);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if(num==1)
			{
				System.out.printf("please input file name:\n");
				String b =buf.readLine();
				File file = new File(b);
				/** 產生的txt檔會在 B013040033_HW7**/
				
				 
				System.out.printf("Input the word:\n");
				String c =buf.readLine();
				System.out.printf("Input the description:\n");
				String d =buf.readLine();
				DictionaryRecord temp=new DictionaryRecord(c, d);
				
				FileOutputStream fos = new FileOutputStream(file);
			    ObjectOutputStream oos = new ObjectOutputStream(fos);
			    
			    oos.writeObject(temp);
			    oos.close();
			}
			else
			{
				System.out.printf("please input 1~3\n");
				continue;
			}
				
			
		}
		
		
		
	}

}
