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
		//�{�b���]reader �ɪ��� �i��b���P�Ѭ[��
		//�D�ز{�b���Ҧ�,books �ثe���e�O �Q�ɪ���,���B���B�z �Y���ɱo���
		
		ListIterator<Bookshelf> it_Bookshelf = this.bookshelfs.listIterator();
		
		
		ArrayList<Book> new_books = new ArrayList<Book>();
		while(it_Bookshelf.hasNext())
		{
			Bookshelf t_Bookshelf = it_Bookshelf.next();
			ListIterator<Book> rit_book =r.books.listIterator();
			while(rit_book.hasNext())
			{
				Book t_book =rit_book.next();
				//�P�_�ӮѬ[ �O�_���n����,�����ܶ�J�s��ArrayList<Book> 
				//getBooKBorrowedStatus �٦b�Ѭ[�W�צ^��false �ҥH�[�W !
				if( t_Bookshelf.getShelfSet().contains(t_book) && ! t_Bookshelf.getBooKBorrowedStatus(t_book) )
				{
					rit_book.remove();//�קK��L�Ѭ[�]���ۦP���Ѧӭ��ƭ�
					
					new_books.add(t_book);
					t_Bookshelf.changeBookStatus(t_book);//�T�w�n�ɨ����窱�A
				}
			
			}
				
			
		}//�]�Ҧ����Ѭ[
		
	    /* Add reader to borrowlist */
		r.books = new_books;
		//���s���᪺Reader.books��JBorrowList
		borrowlist.addList(r);
		//�D�ز{�b���Ҧ�,Reader�ɧ���,books ���e�O �ɨ쪺��
		/* Change borrowed variable to true in bookshelf */
		
		System.out.println ("It's success "+r.ID+" borrow "+r.books.size()+" books");
		
	}
	
	public void returnBooks (Reader r) {
		/* Change borrowed variable to false in bookshelf */
		ListIterator<Bookshelf> it_Bookshelf = this.bookshelfs.listIterator();
		//ArrayList<Book> new_return_book = new ArrayList<Book>();
		
		ArrayList<Book> ab = new ArrayList<Book>(r.bookReturns);//�קK�]�U����while ������remove �ӧR��쥻��
		
		while(it_Bookshelf.hasNext())
		{
			Bookshelf t_Bookshelf = it_Bookshelf.next();
			
			
			
			ListIterator<Book> rit_return_book =ab.listIterator();
			
			while(rit_return_book.hasNext())
			{
				Book t_book =rit_return_book.next();
				
				if( t_Bookshelf.getShelfSet().contains(t_book) && t_Bookshelf.getBooKBorrowedStatus(t_book) )
				{
					rit_return_book.remove(); 				//�קK��L�Ѭ[�]���ۦP���Ѧӭ��ƳQ�W��
					t_Bookshelf.changeBookStatus(t_book);	//����change  borrowed variable to false in bookshelf 
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
