package myjava.homework.part2;
import java.io.*;
public class SecretFiles {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		System.out.printf("Create a unique bad gut's detail now.\n");
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.printf("Name:");
		String change_name = buf.readLine(); 
		System.out.printf("Gender(male/female):");
		String change_gender = buf.readLine(); 
		Boolean gender;
		
		if( ( change_gender.compareTo("male")  ) == 0  ){
			gender = true;
		}
		else
			gender = false;
		
		System.out.printf("Age:");
		String change_age = buf.readLine(); 
		Integer age = Integer.valueOf(change_age);
		System.out.printf("ID:");
		String change_id = buf.readLine(); 
		
		UniqueCriminal bad = UniqueCriminal.getInstance(change_name,gender,age,change_id);
		
		
		
		bad.printData();
		
		
	}

}
