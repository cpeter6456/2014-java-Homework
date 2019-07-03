package myjava.homework.Q2;

public class Rental {

	private int days;
	Movie the_movie;
	public Rental(Movie m,int days){
		this.days=days;
		this.the_movie = m;
	}
	public double getCharge(){
		
		return the_movie.getCharge(this.days);
		
	}

	public int getFrequentRenterPoints(){
		
		return the_movie.getFrequentRenterPoint(this.days);
	}
}
