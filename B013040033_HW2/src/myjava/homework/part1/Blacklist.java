package myjava.homework.part1;
import java.io.*;
public class Blacklist {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		
				Criminal cri1 = null;
					cri1	= new Criminal();
				Criminal cri2 = new Criminal("Ballchinian");
				Criminal cri3 = new Criminal("Scofield" ,true,25,"C010240033");
				
				while(true){
				
						System.out.printf("Type 1 means looking for some one.\n");
						System.out.printf("Type 2 means change someone's detail.\n");
						System.out.printf("Input:");
						
						BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
						String typeNumber = buf.readLine(); 
						Integer intTypeNum = Integer.valueOf(typeNumber);
						
						if(intTypeNum == 1)
						{
										System.out.printf("Which one you want to check?(1,2,3) \n");
										System.out.printf("Input:");
										String check = buf.readLine(); 
										Integer int_check = Integer.valueOf(check);
										
										if(int_check == 1)
										{
												System.out.printf("First suspect is:%s \n",cri1.getName());
												System.out.printf("He/She's age is:%d\n",cri1.getAge());
												System.out.printf("Social ID:%s\n",cri1.getID());
												System.out.printf("Gebder:");
												if(cri1.getGender() == false)
													System.out.printf("female\n");
												else
													System.out.printf("Male\n");
										}
										if(int_check == 2)
										{
												System.out.printf("Second suspect is:%s \n",cri2.getName());
												System.out.printf("He/She's age is:%d\n",cri2.getAge());
												System.out.printf("Social ID:%s\n",cri2.getID());
												System.out.printf("Gebder:");
												if(cri2.getGender() == false)
													System.out.printf("female\n");
												else
													System.out.printf("Male\n");
										}
										if(int_check == 3)
										{
												System.out.printf("Third suspect is:%s \n",cri3.getName());
												System.out.printf("He/She's age is:%d\n",cri3.getAge());
												System.out.printf("Social ID:%s\n",cri3.getID());
												System.out.printf("Gebder:");
												if(cri3.getGender() == false)
													System.out.printf("female\n");
												else
													System.out.printf("Male\n");
										}
													
						}
						if(intTypeNum == 2)
						{
							
							
							System.out.printf("Which one you want to change?(1,2,3) \n");
							System.out.printf("Input:");
							String change = buf.readLine(); 
							Integer int_change_num = Integer.valueOf(change);
							
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
								
								if(int_change_num ==1)
								{
									cri1.setData(change_name, gender, age,change_id );
								}
								if(int_change_num ==2)
								{
									cri1.setData(change_name, gender, age,change_id );
								}
								if(int_change_num ==3)
								{
									cri1.setData(change_name, gender, age,change_id );
				
								}
						}
				}/**end of while(1)**/
	}

}
