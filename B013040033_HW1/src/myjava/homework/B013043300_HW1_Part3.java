package myjava.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B013043300_HW1_Part3 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		System.out.printf("Please niput the length of edge\n");
		
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String edgeNumber = buf.readLine(); 
		Integer intEdgeNum = Integer.valueOf(edgeNumber);
		
		while(intEdgeNum % 2 ==0 )
		{
			System.out.printf("Odd value number only.\n");
			System.out.printf("Please niput the length of edge\n");
			edgeNumber = buf.readLine(); 
			intEdgeNum = Integer.valueOf(edgeNumber);
		}
		
		
		System.out.printf("What image do you want?\n	1) Circle\n	2) Donut\n	3) Two triangle\n	4) Exit \n");
		String number = buf.readLine(); 
		Integer selectNum = Integer.valueOf(number);
		
		
		if(selectNum == 1)
		{
			System.out.printf("x ");
			for(int i=1;i <= intEdgeNum;i++)
			{
				System.out.printf("%d",i%10);
				
			}
			System.out.printf("\n");
			
			int mid = (intEdgeNum-1)/2;
			int midx=mid+1,midy=mid+1;
			for(int y=0 ; y < intEdgeNum;y++)/**y¶b**/
			{	System.out.printf("%d ",(y+1)%10);
				for(int x=0 ; x < intEdgeNum ; x++)/**x¶b**/
				{
					if( ( (midx-x-1)*(midx-x-1)+ (midy-y-1)*(midy-y-1) ) > mid*mid )
						System.out.printf(" ");
					else
						System.out.printf("*");
						
				}
				System.out.printf("\n");
			}
			
		}
		if(selectNum == 2)
		{
			System.out.printf("x ");
			for(int i=1;i <= intEdgeNum;i++)
			{
				System.out.printf("%d",i%10);
				
			}
			System.out.printf("\n");
			
			int mid = (intEdgeNum-1)/2;
			int inside_mid = mid/2;
			int midx=mid+1,midy=mid+1;
			for(int y=0 ; y < intEdgeNum;y++)/**y¶b**/
			{	System.out.printf("%d ",(y+1)%10);
				for(int x=0 ; x < intEdgeNum ; x++)/**x¶b**/
				{
					if(( (midx-x-1)*(midx-x-1)+ (midy-y-1)*(midy-y-1) ) <= inside_mid*inside_mid )
						System.out.printf("*");
					else if( ( (midx-x-1)*(midx-x-1)+ (midy-y-1)*(midy-y-1) ) > mid*mid )
						System.out.printf("*");
					else
						System.out.printf(" ");
						
				}
				System.out.printf("\n");
			}
			
			
			
			
		}
		if(selectNum == 3)
		{
			System.out.printf("x ");
			for(int i=1;i <= intEdgeNum;i++)
			{
				System.out.printf("%d",i%10);
				
			}
			System.out.printf("\n");
			
			int mid = (intEdgeNum-1)/2;
			int midx=mid+1,midy=mid+1;
			for(int y=0 ; y < intEdgeNum;y++)
			{
				System.out.printf("%d ",(y+1)%10);
				for(int x=0 ; x < intEdgeNum ; x++)
				{
					if(x<midx && y<midy )
					{
						if(y>=x)
							System.out.printf("*");
						else
							System.out.printf(" ");
					}
					if(x>=midx && y<midy )
					{
						if(y+x-mid+1 > mid)
							System.out.printf("*");
						else
							System.out.printf(" ");
					}
					
					if(x<midx && y>=midy )
					{
						if(y+x-mid-1 < mid)
							System.out.printf("*");
						else
							System.out.printf(" ");
						
					}
					if(x>=midx && y>=midy )
					{
						if(y<=x)
							System.out.printf("*");
						else
							System.out.printf(" ");
						
					}
				}
				System.out.printf("\n");
			}
		}
		
		
		
		
		
	}

}
