package com.headout;

import java.util.HashSet;
import java.util.Set;

public class PythogorianTriplets {

	public static void main(String[] args) {
		int[] a = {2,3,4,1,5,6,7,8,10};
		Set set = new HashSet();
		for(int i=0;i<a.length;i++){
			set.add(a[i]*a[i]);
		}
		
		for(int i=0;i<a.length;i++){
			for(int j=i+1;j<a.length;j++){
				if(set.contains(a[i]*a[i]+a[j]*a[j])){
					System.out.println(a[i]+", "+a[j]+", "+Math.sqrt(a[i]*a[i]+a[j]*a[j]));
				}
			}
		}
		

	}

}
