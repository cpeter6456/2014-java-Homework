package myjava.homework;
import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class Bookshelf {
	private HashSet<Book> shelfSet;
	private HashMap<String, Boolean> shelf;
	
    public Bookshelf () {
    	this.shelfSet = new HashSet<Book> ();
    	this.shelf = new HashMap<String, Boolean> ();
    }
    
	public void addBooks (Book book) {
		/* Add book to shelfSet, and put false to shelf for the book title as value */
		shelfSet.add(book);
		shelf.put(book.getTitle(),false);
		
    }

	public HashSet<Book> getShelfSet () {
		return shelfSet;
	}
	
	public HashMap<String, Boolean> getShelf () {
		return shelf;
	}
	
	public void search (Reader r, Book b) {
		//System.out.println("!!!!!have"+this.shelfSet.contains(b)+this.shelf.get(b.getTitle()));
	
		if(r.search.lookup(shelfSet, shelf, b))
		{
			System.out.println("!!find \t"+b.getTitle());
			
			r.addBooks(b);
			//加入後  更改狀態  要在確實借到時才改
		}
		else
			System.out.println("!!Don't find "+b.getTitle());
		
		
		
	/* Using method in Reader's search instance 
	/* to look up if the book is in shelfSet, 
	/* and add into Reader's books. 
	*/
	}
	
	public boolean getBooKBorrowedStatus (Book b) {
		return shelf.get (b.getTitle());
	}
	
	public void changeBookStatus (Book b) {
		shelf.put (b.getTitle(), !getBooKBorrowedStatus (b));
	}
	
	public String toString () {
		String str = "Bookshelf contains:\n";
		Iterator<Book> bIterator =  shelfSet.iterator();
		while (bIterator.hasNext()) {
			str = str + "==>" + bIterator.next().getTitle() + "\n";
		}
		return str;
	}
}
