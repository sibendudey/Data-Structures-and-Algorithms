package designQs;

import java.util.Date;
import java.util.HashMap;

public class CareerCupDropBox {
	
	static Integer ID = 0;
	static HashMap< Date , Integer> hitMap = new HashMap<Date , Integer >();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}
	
	public static void recordHit()	{
		//ID++;
		hitMap.put(new Date(), ++ID);
	}
	
	public static int getCount(){
		Date date = new Date();
		return ID - hitMap.get(new Date( date.getTime() - 300000)) ;
	}

}
