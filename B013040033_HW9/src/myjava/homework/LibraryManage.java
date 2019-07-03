package myjava.homework;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class LibraryManage {
	private ArrayList<Bookshelf> bookshelfs;
	private BorrowList borrowlist;
	
	public LibraryManage (){
		 setBookshelfs ();
		 setBorrowlist ();
	}
	
	public void addBookshelf (Bookshelf bs) {
		bookshelfs.add(bs);
	}
	
	public void borrowBooks (Reader r) {
		//現在假設reader 借的書 可能在不同書架裡
		//題目現在的模式,books 目前內容是 想借的書,此處先處理 縮為借得到書
		
		ListIterator<Bookshelf> it_Bookshelf = this.bookshelfs.listIterator();
		
		
		ArrayList<Book> new_books = new ArrayList<Book>();
		while(it_Bookshelf.hasNext())
		{
			Bookshelf t_Bookshelf = it_Bookshelf.next();
			ListIterator<Book> rit_book =r.books.listIterator();
			while(rit_book.hasNext())
			{
				Book t_book =rit_book.next();
				//判斷該書架 是否有要的書,有的話塞入新的ArrayList<Book> 
				//getBooKBorrowedStatus 還在書架上匯回傳false 所以加上 !
				if( t_Bookshelf.getShelfSet().contains(t_book) && ! t_Bookshelf.getBooKBorrowedStatus(t_book) )
				{
					rit_book.remove();//避免其他書架也有相同的書而重複借
					
					new_books.add(t_book);
					t_Bookshelf.changeBookStatus(t_book);//確定要借走後更改狀態
				}
			
			}
				
			
		}//跑所有的書架
		
	    /* Add reader to borrowlist */
		r.books = new_books;
		//把更新完後的Reader.books丟入BorrowList
		borrowlist.addList(r);
		//題目現在的模式,Reader借完後,books 內容是 借到的書
		/* Change borrowed variable to true in bookshelf */
		
		System.out.println ("It's success "+r.ID+" borrow "+r.books.size()+" books");
		
	}
	
	public void returnBooks (Reader r) {
		/* Change borrowed variable to false in bookshelf */
		ListIterator<Bookshelf> it_Bookshelf = this.bookshelfs.listIterator();
		//ArrayList<Book> new_return_book = new ArrayList<Book>();
		
		ArrayList<Book> ab = new ArrayList<Book>(r.bookReturns);//避免因下面的while 內部做remove 而刪到原本的
		
		while(it_Bookshelf.hasNext())
		{
			Bookshelf t_Bookshelf = it_Bookshelf.next();
			
			
			
			ListIterator<Book> rit_return_book =ab.listIterator();
			
			while(rit_return_book.hasNext())
			{
				Book t_book =rit_return_book.next();
				
				if( t_Bookshelf.getShelfSet().contains(t_book) && t_Bookshelf.getBooKBorrowedStatus(t_book) )
				{
					rit_return_book.remove(); 				//避免其他書架也有相同的書而重複被規環
					t_Bookshelf.changeBookStatus(t_book);	//環後change  borrowed variable to false in bookshelf 
				}
			}
		}
		
		
		/* Use method in BorrowList to return books */
		borrowlist.returnBooks(r);
		
	}
	
	private void setBookshelfs () {
		bookshelfs = new ArrayList<Bookshelf> ();
	}
	
	private void setBorrowlist () {
		borrowlist = new BorrowList ();
	}
	
}
