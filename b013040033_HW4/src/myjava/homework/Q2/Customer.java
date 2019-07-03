package myjava.homework.Q2;

import java.util.ArrayList;


class Customer {

	private String name;
	public ArrayList<Rental> mylist =  new ArrayList<Rental>();
	
	public Customer(String tname){
		this.name = tname; 
	}
	public void addRental(Rental in){
		
		mylist.add(in);
		
	}
	public String statement(){
		
		System.out.printf("Rental Record for %s\n",name);
		getTotalCharge();
		getTotalFrequentrentalPoints();
		return "";
	}
	
	public void getTotalCharge(){
		Rental temp;
		double sum=0,t;
		for(int i=0;i<mylist.size();i++){
			temp = mylist.get(i);
			temp.the_movie.get_name();
			t = temp.getCharge();
			sum+=t;
			System.out.printf("%.2f\n",t);
			
		}
		System.out.printf("Amount owed is %.2f\n",sum);
	}
	public void getTotalFrequentrentalPoints(){
		int sum_point=0;
		Rental temp;
		for(int i=0;i<mylist.size();i++){
			temp = mylist.get(i);
			sum_point+=temp.getFrequentRenterPoints();
			
		}
		System.out.printf("You earned %d frequent renter points\n",sum_point);
	}
	
}
