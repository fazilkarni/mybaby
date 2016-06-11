package com.jpmc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class ConcurrentThreadExceptionInSingleThreadedModel {
	
	public static void main(String[] args){
		List a = new ArrayList();
		a.add(1);
		a.add(2);
		a.add(3);
		Iterator itr = a.iterator();
		//itr.hasNext();
		System.out.println(itr.next());
		a.add(4);
		a.remove(2);
		System.out.println(itr.next());
		
	}

}
