package com.jpmc;

/**
 * http://javarevisited.blogspot.in/2014/05/double-checked-locking-on-singleton-in-java.html
 * @author fazil
 *
 */
public class DoubleCheckSingleton {
	private static DoubleCheckSingleton obj;
	
	private DoubleCheckSingleton(){
		
	}
	public static DoubleCheckSingleton getInstance(){
		if(obj!=null){
			synchronized (DoubleCheckSingleton.class) {
				if(obj!=null){
					obj = new DoubleCheckSingleton();
				}
				
			}
		}
		return obj;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	

}
