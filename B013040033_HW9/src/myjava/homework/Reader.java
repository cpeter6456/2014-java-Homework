package myjava.homework;

import java.util.ArrayList;
import java.util.ListIterator;

public abstract class Reader {
	protected ArrayList<Book> books;
	//  Reader can look up the book on the bookshelf.
	protected ArrayList<Book> bookReturns;
	//  The book Reader wants to return back
	protected Bookshelf bookshelf;
	//    Derived method for search ways.
	protected Search search; 
	//    Each reader has his unique id, 
	//    not implement yet, use String to Replace by now.
	protected String ID;
	
    
	public void lookup (Book b) {
		bookshelf.search (this, b);
	}
	
	public Reader (String name) {
		books = new ArrayList<Book> ();
		bookReturns = new ArrayList<Book>();
		setID (name);
	}
	
	public void goToBookshelf (Bookshelf bs)
	{
		bookshelf = bs;
	}
	
	public void addBooks (Book b) {
		/* Add book to books */
		books.add(b);
	}
	
	public void removeBooks (Book b) {
		books.remove (b);
	}
	
	public ArrayList<Book> getBorrowBooks () {
		return books;
	}
	
	public void addReturnBooks (Book b) {
		/**此處b跟books的book都是只到同一個book物件  
		 * 也就是說add只是塞入指標 非new
		 * **/
		bookReturns.add(b);
		
		/* Add book to bookReturns */
		
		//System.out.println ("books size="+books.size()+" bookreturns size="+bookReturns.size());
		ListIterator<Book> it=books.listIterator();
		//更改books
		while(it.hasNext())
		{
			
			Book bb =it.next();
			//System.out.println (bb);
			if(bb.equals(b))
			{
				it.remove();
			
			}
			
		}
		//System.out.println ("books size="+books.size()+" bookreturns size="+bookReturns.size());
		
	}
	
	public ArrayList<Book> getReturnBooks () {
		return bookReturns;
	}
	
	private void setID (String name) {
		ID = name;
	}
	
	public String getID () {
		return ID;
	}
	
	public void decideLookupWays (Search s) {
		search = s;
	}
	
	public Search getSearch () {
		return search;
	}
}
