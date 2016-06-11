package application;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicatesChars {

	public static void main(String[] args) {
		int[] chars = new int[256];
		String str = "abaaaaaaaccdbbbb";
		addDuplicates();
		System.out.println((int)'{');
		for(int i=0;i<str.length();i++){
			if(chars[(int)str.charAt(i)]==0){
				chars[(int)str.charAt(i)]=1;
			}else{
				
			}
		}	

	}
	
	public static void addDuplicates(){
		String a = "fazil";
		String b="fazil";
		List<String> list = new ArrayList<String>();
		Set s = new HashSet();
		s.add(a);
		s.add(b);
		list.add(a);
		list.add(b);
		System.out.println("Size: "+list.size());
		
		System.out.println("Size of set: "+s.size());
		
		
		
		
	}

}
