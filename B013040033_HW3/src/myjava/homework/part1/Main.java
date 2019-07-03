package myjava.homework.part1;
import java.io.*;

public class Main {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub

		FileReader fr = new FileReader("src/myjava/homework/part1/sample1" );
		BufferedReader inputFile = new BufferedReader(fr);
		
		String temp1 = inputFile.readLine();
		/**star of matrix1**/
		String[] starray = temp1.split("x");
		Integer row = Integer.valueOf(starray[0]);
		Integer column = Integer.valueOf(starray[1]);
		
		int [][]matrix1 = new int[row][column];
		System.out.printf("Matrix1\nrow: %d\ncolumn: %d\n",row,column);
		for(int i=0;i<row;i++)
		{
			temp1 = inputFile.readLine();
			String[] starray1 = temp1.split(" ");
			for (int j = 0; j < starray1.length;j++)
			{
				matrix1[i][j] = Integer.valueOf(starray1[j]);
				System.out.printf("%4d",matrix1[i][j]);
			}
			System.out.printf("\n");
		}
		System.out.printf("-----------------------\n");
		/**end of matrix1**/
		
		
		/**star of matrix2**/
		temp1 = inputFile.readLine();
		starray = temp1.split("x");
		Integer row2 = Integer.valueOf(starray[0]);
		Integer column2 = Integer.valueOf(starray[1]);
		
		int [][]matrix2 = new int[row2][column2];
		System.out.printf("Matrix2\nrow: %d\ncolumn: %d\n",row2,column2);
		for(int i=0;i<row2;i++)
		{
			temp1 = inputFile.readLine();
			String[] starray1 = temp1.split(" ");
			for (int j = 0; j < starray1.length;j++)
			{
				matrix2[i][j] = Integer.valueOf(starray1[j]);
				System.out.printf("%4d",matrix2[i][j]);
			}
			System.out.printf("\n");
		}
		System.out.printf("-----------------------\n");
		/**end of matrix2**/
		
		/**star of matrix product**/
		int [][]product = new int[row][column2];
		
		System.out.printf("Result\nrow: %d\ncolumn: %d\n",row,column2);
		for(int i=0;i<row;i++)
		{
			for(int a=0;a<column2;a++)
			{
				int sum=0;
				for(int j=0;j<column;j++)
				{
					sum = sum+matrix1[i][j]*matrix2[j][a];
				}
				
				product[i][a]=sum;
				System.out.printf(" %5d",product[i][a]);
			}
			System.out.printf("\n");
		}
		/**end of matrix product**/
		
		
		
		inputFile.close();
	}

}
