package myjava.homework;

public abstract class Librarian extends Reader {
	//    Librarian will know which system he operates.
	private LibraryManage libraryManageSystem;
	
    public Librarian (String ID) {
    	super (ID);
    }
    
	public void borrowBook (Reader r) {
		libraryManageSystem.borrowBooks(r);
		/* Use method in LibraryManage to borrow books */
	}
	
	public void returnBook (Reader r) {
		libraryManageSystem.returnBooks(r);
		/* Use method in LibraryManage to return books */
	}
	
	public void setLibraryManageSystem (LibraryManage lms) {
		libraryManageSystem = lms;
	}
}
