package myjava.homework.lotto;
import java.io.*;
public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BigLotto big = new BigLotto(6,49);
		Selector sel1 =  big.selector();
		System.out.printf("BigLotto : ");
		big.show(sel1);
		
		
		SuperLotto sup = new SuperLotto(6,38);
		Selector sel2 = sup.selector();
		System.out.printf("SuperLotto : ");
		big.show(sel2);
		
		
		SuperLotto sup2 = new SuperLotto(1,8);
		Selector sel3 = sup2.selector();
		System.out.printf("");
		big.show(sel3);
		
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in)); 
		System.out.println("Step 1 : Please input the range (from 1 ~ ?) : ");
		String range = buf.readLine(); 
		
		Integer a = Integer.valueOf(range);
		System.out.println("Step 2 : Please input the number of winning numbers : ");
		String number = buf.readLine(); 
		Integer b = Integer.valueOf(number);
		
		if(b>a)
			System.out.println("You are so greedy!!");
		else{
			Draw draw = new Draw(b,a);
			Selector sel4 =  draw.selector();
			System.out.printf("Draw : ");
			draw.show(sel4);
		}
		
	}

}
