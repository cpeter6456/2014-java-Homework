package myjava.homework.part1;

public class Criminal {
	
	private String name;
	private boolean gender;
	private int age;
	private String id;
	
	public Criminal(){
		this.name   =null;
		this.gender =false;
		this.age    =0;
		this.id     =null;
	}
	public Criminal(String new_name){
		this.name   =new_name;
	}
	public Criminal(String new_name,boolean new_gender,int new_age,String new_id){
		this.name   =new_name;
		this.gender =new_gender;
		this.age    =new_age;
		this.id     =new_id;
	}
	
	
	public void setName(String new_name){
		this.name = new_name;
	}
	public void setData(String new_name,boolean new_gender,int new_age,String new_id){
		this.name   =new_name;
		this.gender =new_gender;
		this.age    =new_age;
		this.id     =new_id;
		
	}
	public String getName(){
		return name;
	}
	public boolean getGender(){
		return gender;
	}
	public int getAge(){
		return age;
	}
	public String getID(){
		return id;
	}
}
