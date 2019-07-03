package myjava.homework.lotto;
import java.util.Random;
interface  Selector {
	public boolean end();
	public Object current();
	public void next();
}
interface display{
	public void show(Selector sel);
}

interface LuckyNumlist{
	public void generate();
}

public class Lotto implements LuckyNumlist ,display{

	private Object[] items;
	private int numOfWinNum;
	private int maxOfNum;
	private int arraylen;
	Lotto(int num, int max){
		numOfWinNum = num;
		maxOfNum = max;
		items = new Object[numOfWinNum];
		arraylen=0;
		generate();
	}
	
	private class SequenceSelector implements Selector{
		private int i;

		
		@Override
		public boolean end() {
			// TODO Auto-generated method stub
			return i == items.length;
		}

		@Override
		public Object current() {
			// TODO Auto-generated method stub
			return items[i];
		}

		@Override
		public void next() {
			// TODO Auto-generated method stub
			 if (i < items.length) i++;
		} 
		
	}
	public Selector selector(){
		return new SequenceSelector();
	}
	@Override
	public void show(Selector sel) {
		// TODO Auto-generated method stub
		while (!sel.end()){
            System.out.printf(sel.current() + " ");
            sel.next();
        }
		System.out.printf("\n");
	}

	@Override
	public void generate() {
		// TODO Auto-generated method stub
		for(int i=0;i<numOfWinNum;i++){
			generateWinNums();
		}
		
	}
	
	private void generateWinNums(){/**random one number (no same number)**/
		Random temp = new Random();
		boolean flag ;
		int num ;
		while(true){
			flag =true;
			num = temp.nextInt(maxOfNum)+1;//1 ~ maxOfNum
			for(int t=0;t<arraylen;t++){
				if(items[t].equals(num)){
					flag = false;
					break;
				}
			}
			
			
			if(flag==true){
				items[arraylen++] = num;/**also can use (Object) num*/
				break;
			}
		}
	}

}/**End of Class Lotto**/

class Draw extends Lotto{

	Draw(int num, int max) {
		super(num, max);
		// TODO Auto-generated constructor stub
	}
}

class BigLotto extends Lotto{

	BigLotto(int num, int max) {
		super(num, max);
		// TODO Auto-generated constructor stub
	}
}

class SuperLotto extends Lotto{

	SuperLotto(int num, int max) {
		super(num, max);
		// TODO Auto-generated constructor stub
	}
}
