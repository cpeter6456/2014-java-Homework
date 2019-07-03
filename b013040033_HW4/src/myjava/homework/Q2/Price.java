package myjava.homework.Q2;

public abstract class Price {

	
	public abstract double getCharge(int days);
	public  int getFrequentRenterPoint(int days){
		return 1;
	}
}
class ChildrenPrice extends Price{
	public  double getCharge(int days){
		double result=1.5;
		if(days >3)
			result+=(days-3)*1.5;
		
		return result;
	}
}
class RegularPrice extends Price{
	public  double getCharge(int days){
		
		double result=2;
		if(days>2)
			result+=(days-2)*1.5;
		return result;
	}
}

class NewReleasePrice extends Price{
	public  double getCharge(int days){
		
		
		return 3*days;
	}
	public  int getFrequentRenterPoint(int days){
		return (days>1)?2:1;
	}
}
