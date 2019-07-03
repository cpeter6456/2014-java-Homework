package myjava.homework.part2;
import java.io.*;

public class Main {

	public enum Type {SYM,KYMCO,TAHAHA}

	public enum Cylinder {CC_100,CC_125,CC_150}

	public enum Producer {V2,GT,CYGNUS}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int n1,n2,n3;
		System.out.printf("Which Producer you want(1:SYM 2:KYMCO 3:TAHAHA):");
		String Producer = buf.readLine(); 
		n1 = Integer.valueOf(Producer);
		
		System.out.printf("Which Cylinder you want(1:100 2:125 3:150):");
		String Cylinder = buf.readLine(); 
		n2 = Integer.valueOf(Cylinder);
		
		System.out.printf("Which Type you want(1:V2 2:GT 3:CYGNUS):");
		String Type = buf.readLine(); 
		n3 = Integer.valueOf(Type);
		
		System.out.printf("your scooter is");
	
		switch(n1)
		{
			case 1:System.out.printf(" SYM");break;
			case 2:System.out.printf(" KYMCO");break;
			case 3:System.out.printf(" TAHAHA");break;
		
		}
		switch(n3)
		{
			case 1:System.out.printf(" V2");break;
			case 2:System.out.printf(" GT");break;
			case 3:System.out.printf(" CYGNUS");break;
		}
		switch(n2)
		{
			case 1:System.out.printf(" CC_100");break;
			case 2:System.out.printf(" CC_125");break;
			case 3:System.out.printf(" CC_150");break;
		}
		
	}

}
