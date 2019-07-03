package myjava.homework.part1;

public class StudentGrade {
	 public enum GradePoint{A_PLUS, A, A_MINUS, B_PLUS, B, B_MINUS, C_PLUS, C, C_MINUS, D, E, F, X}

	    public String id;
	    public String name;
	    public int score;
	    public GradePoint gradePoint;
	    
	    // You can change the arguments of constructor to anything you want.
	    public StudentGrade(String[] data) throws IllegalCharacterException, IllegalLengthException, OutOfRangeException{
	        // Check if data input is valid here.
	    	
	    	boolean flag=false;
	    	if(data.length !=3)
	    		throw new IllegalCharacterException("Format error.");
	    	char c_array[] = data[2].toCharArray();
	    	
	    	for(int i=0;i<data[2].length() ;i++)
	    	{
	    		if(c_array[i]<'0' || c_array[i]>'9')
	    			flag=true;
	    	}
	    	if(flag)
	    	{
	    		throw new IllegalCharacterException("Score contains invalid characters.");
	    	}
	    	
	    	int the_score= Integer.valueOf(data[2]);
	    	if(the_score<0 || the_score>100)
	    	{
	    		throw new OutOfRangeException("Score must be between 0 and 100.");
	    	}
	    	else if(data[0].length()!=10)
	    	{
	    		throw new IllegalLengthException("Length of student id must be 10.");
	    	}
	    	else if(data[1].length()<2 ||data[1].length()>15 )
	    	{
	    		throw new IllegalLengthException("Length of student name must be between 2 and 15.");
	    	}
	    	else 
	    	{
	    		this.id=data[0];
	    		this.name=data[1];
	    		
	    		if(the_score==0)
	    			gradePoint=GradePoint.X;
	    		else if(the_score<=39)
	    			gradePoint=GradePoint.F;
	    		else if(the_score<=49)
	    			gradePoint=GradePoint.E;
	    		else if(the_score<=59)
	    			gradePoint=GradePoint.D;
	    		else if(the_score<=62)
	    			gradePoint=GradePoint.C_MINUS;
	    		else if(the_score<=66)
	    			gradePoint=GradePoint.C;
	    		else if(the_score<=69)
	    			gradePoint=GradePoint.C_PLUS;
	    		else if(the_score<=72)
	    			gradePoint=GradePoint.B_MINUS;
	    		else if(the_score<=76)
	    			gradePoint=GradePoint.B;
	    		else if(the_score<=79)
	    			gradePoint=GradePoint.B_PLUS;
	    		else if(the_score<=84)
	    			gradePoint=GradePoint.A_MINUS;
	    		else if(the_score<=89)
	    			gradePoint=GradePoint.A;
	    		else 
	    			gradePoint=GradePoint.A_PLUS;
	    		
	    		
	    		
	    		
	    		
	    	}
	    	
	    }  
}
