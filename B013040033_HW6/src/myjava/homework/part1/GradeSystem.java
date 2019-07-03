package myjava.homework.part1;
import java.io.*;
import java.util.ArrayList;
public class GradeSystem {

	public static void main(String[] args)   {
		// TODO Auto-generated method stub
		while(true)
		{
			ArrayList<StudentGrade> studentGrades = new ArrayList<StudentGrade>();;
			
			try {
				System.out.printf("Please input file name:\n");
				BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
				String st;
				
				st = buf.readLine();
				
				FileReader fr = new FileReader("src/myjava/homework/part1/"+st );/**一照輸入讀檔**/
				BufferedReader f_buf= new BufferedReader(fr);
				System.out.printf("Reading file - %s\n",st);
				
				boolean flag = false;
				while( (st= f_buf.readLine()) != null)
				{
					
					String[] starray = st.split(" ");
					try {
						StudentGrade a=new StudentGrade(starray);
						studentGrades.add(a);
						/**if it have "throw" 例外的話 會自動跑到catch 做對應的處理**/
					} catch (IllegalCharacterException e) {
						// TODO Auto-generated catch block
						System.out.println("ERROR說明"+e.getMessage());
						flag =true;
						break;
					} catch (IllegalLengthException e) {
						// TODO Auto-generated catch block
						System.out.println("ERROR說明"+e.getMessage());
						flag =true;
						break;
					} catch (OutOfRangeException e) {
						// TODO Auto-generated catch block
						System.out.println("ERROR說明"+e.getMessage());
						flag =true;
						break;
					}
					
					
				}/**End of inner while**/
				
				if(!flag)
				{	
					System.out.printf("%-15s %-15s %-15s \n","ID","name","Grade Point");
					int len =studentGrades.size();
					for(int i=0;i<len;i++)
					{
						StudentGrade temp;
						temp = studentGrades.get(i);
						System.out.printf("%-15s %-15s %-15s\n",temp.id,temp.name,temp.gradePoint );
					}
					System.out.printf("Total numbers of students %d\n",len);
				}
				fr.close();
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("ERROR說明"+e.getMessage());
				
			}
		}/**End of while(true)**/
	}


}
