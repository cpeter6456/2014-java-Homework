package myjava.homework;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Book {
	/* Three attributes in class Book */
	private String title;
	private String author;
	private Date publishDate;
	private SimpleDateFormat formatter;
	public Book (String title, String author, String date) {
		setTitle (title);
		setAuthor (author);
		
		setPublishDate (date);
	}
	
	public Book (String title) {
		setTitle (title);
		setAuthor (null);
		
		setPublishDate (null);
	}
	
	public Book () {
		
	}
	
	@Override
	public String toString() {
		DateFormat sdf = new SimpleDateFormat ("yyyy/MM/dd");
		return "Book: "+ title + "\n " + 
				     " Author: " + author + "\n  " + 
				     "publishDate: " + sdf.format (publishDate);
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		
		result = prime * result + ((title == null) ? 0 : title.hashCode()) + 
				((author == null) ? 0 : author.hashCode())+ 
				((publishDate == null) ? 0 : publishDate.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (this == obj)
			return true;
		if (getClass() != obj.getClass())
			return false;
		
		Book other = (Book) obj;
		
		/**author is same ?**/
		if (author == null) {
			if (other.author != null)
				return false;
		} 
		else if (!author.equals(other.author))
			return false;
		
		/**publishDate is same ?**/
		if (publishDate == null) {
			if (other.publishDate != null)
				return false;
		} 
		else if (!publishDate.equals(other.publishDate))
			return false;
		
		/**title is same ?**/
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		
		return true;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	/*原本是回傳Date 但格式要求為 "yyyy/MM/dd" 改為String*/
	public String getPublishDate() {
		//System.out.println(publishDate);
		return formatter.format(publishDate);
	}

	public void setPublishDate(String publishDate) {
		/* PublishDate format is "yyyy/MM/dd" */
	/*	this.publishDate = new Date ();
		
		if (publishDate != null) {
			//* Remember to catch ParseException when parse publishDate 
		}*/
		
		if (publishDate != null) {
			formatter = new SimpleDateFormat("yyyy/MM/dd");
			try{
				this.publishDate = formatter.parse(publishDate);
			   // System.out.println( formatter.format(this.publishDate) );
			  }catch(ParseException e){
				  System.out.println("unparseable using" + formatter);
			  }
		}
	
	}
}
