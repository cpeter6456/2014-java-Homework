package myjava.homework;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class BorrowList {
    private HashMap<String, ArrayList<Book>> borrowLists;
    
    public BorrowList () {
    	borrowLists = new HashMap<String, ArrayList<Book>> ();
    }
    
    public void addList (Reader r) {
    	
    	//�T�ɳQ�ɨ����H�b�W�h�B�z��
    	/**�몫�� �i�o�� ���󵲺c �� �O�ǫ���  �ҥH �쪫�� ��諸�� ���󵲺c �̹���������]�|���
    	 * **/
    	//System.out.println("in addlist "+r.ID+r.books);
    	
    	ArrayList<Book> b=new ArrayList<Book>(r.books);
    	borrowLists.put(r.ID,b);
    	
    	//borrowLists.put(r.ID,r.books);
    	
		/* Insert reader's ID and books as key and value */
		/* to  borrowLists. */
    }
    
    public void returnBooks (Reader r) {
    	
    	ArrayList<Book> b_arraylist= borrowLists.get(r.ID);
    	
    	//System.out.println (r.ID+" booksreturn size ="+r.bookReturns.size()+r.books.size());
    	
    	Iterator<Book> it = r.bookReturns.listIterator();
    	
    	//System.out.println (r.ID+" booksreturn size ="+r.bookReturns.size());
    	
    	
    
    	//System.out.println (r.ID+" Before remove"+b_arraylist.size()+b_arraylist);
    	
    	while(it.hasNext())
    	{
    		Book b_temp=it.next();
    		Iterator<Book> it2 =b_arraylist.listIterator();
    		while(it2.hasNext())
    		{
    			if(it2.next().equals(b_temp))/**���M�baddList �Onew �@��arraylist ���̭��s������ �@�ˬOBook������**/
    				it2.remove();
    				
    		}
    		
    	}
    	
    	
    	if(b_arraylist.size()==0)
    		borrowLists.remove(r.ID);
    
    	if(borrowLists.containsKey(r.ID))
    		System.out.println (r.ID+"�٦�"+b_arraylist.size()+"���ѨS��");
    	
    //	System.out.println (r.ID+" After remove"+b_arraylist.size());
    		
    	
		/* Remove books in borrowLists by Reader's ID, 
		   and books in Reader's returnBooks
		*/
    }
}
