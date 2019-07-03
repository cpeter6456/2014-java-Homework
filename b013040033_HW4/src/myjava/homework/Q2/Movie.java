package myjava.homework.Q2;

public class Movie {
	public static final int NEW_RELEASE = 0;
	public static final int REGULAR = 1;
	public static final int CHILDRENS = 2;
	private String title;
	private int type;
	Price its_price;
	
	public void get_name(){
		System.out.printf("\t%s\t",title);
	}
	public Movie(String name,int type){
		this.type = type;
		this.title = name;
		setPricecode();
	}
	public void setPricecode(){
		
		switch(type) {
		case 0:its_price = new NewReleasePrice();
			break;
		case 1:its_price = new RegularPrice();
			break;
		case 2:
			its_price = new ChildrenPrice();
			break;
		default:
			throw new IllegalArgumentException("Incorrect Price Code");
			
		}
		
	}
	public double getCharge(int days){
		
		return its_price.getCharge(days);
	}
	public int getFrequentRenterPoint(int days){
		return its_price.getFrequentRenterPoint(days);
	}
}
