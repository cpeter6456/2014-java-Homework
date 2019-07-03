package myjava.homework;
import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		/**
		 * Iterator 跑到底後 想從頭的話 直接宣一個新的即可
		 * 沒跑到底一樣可以宣一個新的  一樣是從頭開始
		 **/
		
		
		
		Book b1 = new Book("Things Fall Apart", "Chinua Achebe", "1958/1/1");
		Book b2 = new Book("Fairy tales", "Hans Christian Andersen", "1835/1/1");
		Book b3 = new Book("33333", "Chinua Achebe", "1958/1/1");
		Book b4 = new Book("4444", "Chinua Achebe", "1958/1/2");
		Book b5 = new Book("55555", "Chinua Achebe", "1958/1/3");
		Book b6 = new Book("66666", "Chinua Achebe", "1958/4/4");
		
		System.out.println (b6.getPublishDate());
		
		
		Bookshelf rawBs = new Bookshelf();
		rawBs.addBooks(b1);
		rawBs.addBooks(b2);
		Bookshelf rawBs2 = new Bookshelf();
		rawBs2.addBooks(b3);
		rawBs2.addBooks(b4);
		Bookshelf rawBs3 = new Bookshelf();
		rawBs3.addBooks(b5);
		rawBs3.addBooks(b6);
		System.out.println (rawBs);
		System.out.println (rawBs2);
		System.out.println (rawBs3);
		LibraryManage LibraryManageSystem = new LibraryManage();
		LibraryManageSystem.addBookshelf(rawBs);
		LibraryManageSystem.addBookshelf(rawBs2);
		LibraryManageSystem.addBookshelf(rawBs3);
		
		
		Student Allen = new Student("Allen");
		Allen.decideLookupWays (new LookupByTitle());
		
		Allen.goToBookshelf(rawBs);
		Allen.lookup (b1);
		Allen.lookup (b2);
		Allen.goToBookshelf(rawBs2);
		Allen.lookup (b3);
		Allen.goToBookshelf(rawBs3);
		Allen.lookup (b5);
		System.out.println (Allen + "\n");

		Student Bob = new Student("Bob");
		Bob.goToBookshelf(rawBs);
		Bob.decideLookupWays (new LookupByTitle());
		Bob.lookup (b2);
		Bob.goToBookshelf(rawBs2);
		Bob.lookup (b3);
		Bob.goToBookshelf(rawBs3);
		Bob.lookup (b6);
		
		System.out.println (Bob.toString() + "\n");
		
		LibrarianPartTime Jenny = new LibrarianPartTime ("Jenny");
		Jenny.setLibraryManageSystem(LibraryManageSystem);
		Jenny.borrowBook(Allen);
		Jenny.borrowBook(Bob);
		
		System.out.println ();
		
		Bob.lookup (b2);
		System.out.println ("Allen wants to return the book now");
		Allen.addReturnBooks(b3);
		Allen.addReturnBooks(b2);
		Allen.addReturnBooks(b1);
		Jenny.returnBook (Allen);
		
		Jenny.borrowBook(Bob);
		Bob.goToBookshelf(rawBs);
		Bob.lookup (b2);
		Jenny.borrowBook(Bob);
	}

}
