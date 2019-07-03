package myjava.homework.part2;

import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

import myjava.homework.part1.*;
import myjava.homework.part1.DictionaryRecord;
public class Main {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ArrayList<DictionaryRecord> dictionaryRecords = new ArrayList<DictionaryRecord>(); 
		File file = new File("dict.txt");
		FileReader fr = new FileReader(file );
		BufferedReader buf = new BufferedReader(fr); 
		
		
		boolean flag=true;
		
		
	   while(true)
	   {
		   if(!buf.ready())break;
		   String t="",word="",de="";flag=true;
		   while(true)
		   {
			   t= buf.readLine();
			   if(flag)
			   {
				   word =t;
				   flag=false;
			   }
			   else
			   {
				   de+=t;
			   }
			  
			   if(t.length()==0 || !buf.ready())
				   break;
		   }/**End of inner while**/
		   DictionaryRecord temp =new DictionaryRecord(word,de);
		   dictionaryRecords.add(temp);
		   //System.out.printf("!!!!!word=%s de=%s\n",word,de);
		   
	   }/**End of out while**/
	   String want,tt,tt2="";
	   while(true)
	   {
		   System.out.printf("What word do you want :");
		   BufferedReader key_buf = new BufferedReader(new InputStreamReader(System.in)); 
		   
		   want=key_buf.readLine();
		   boolean flag2=false;
		   for(int i=0;i<dictionaryRecords.size();i++)
		   {
			   tt=dictionaryRecords.get(i).word;
			   if(want.equals(tt) )
			   {
				   flag2=true;
				   tt2=dictionaryRecords.get(i).description;
				   break;
			   }
		   }
		   if(flag2)
		   {
			   System.out.printf("%s :%s\n",want,tt2);
		   }
		   else
		   {
			   System.out.printf("%s :Not Found!\n",want);
		   }
		   
	   }
		
    }
}