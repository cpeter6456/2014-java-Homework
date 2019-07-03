package myjava.homework.part2;
import java.io.*;
public class UniqueCriminal {

	
	private String name;
	private boolean gender;
	private int age;
	private String id;
	
	private static UniqueCriminal bigBadGuy;
	
	private UniqueCriminal(String new_name,boolean new_gender,int new_age,String new_id)
	{
		this.name = new_name;
		this.gender = new_gender;
		this.age = new_age;
		this.id = new_id;
	}
	
	
	public static UniqueCriminal getInstance(String new_name,boolean new_gender,int new_age,String new_id){
		bigBadGuy = new UniqueCriminal(new_name,new_gender, new_age, new_id);
		
		return bigBadGuy;
	}
	public void printData(){
		System.out.printf("Check the Dtail:\n");
		System.out.printf("The bad guy is:%s\n",name);
		System.out.printf("He/She's age is:%d\n",age);
		System.out.printf("Social ID:%s\n",id);
		if( gender == true) 
			System.out.printf("Gender:Male\n");
		else
			System.out.printf("Gender:female\n");
		
	}
}
