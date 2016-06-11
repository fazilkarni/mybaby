package com.VmWare;

public class NonRepeatingMaxSubString {

	public static void main(String[] args) {
		String s = "asdfghjklamcdf";
		StringBuffer currentString = new StringBuffer();
		StringBuffer previousString = new StringBuffer();
		int chars[] = new int[256];
		for(int i=0;i<s.length();i++){
			if(chars[s.charAt(i)]==0){
				chars[s.charAt(i)]= 1;
				currentString.append(s.charAt(i));	
				System.out.println((int)s.charAt(i));
			}else{
				for(int j=0;j<i;j++){
					chars[s.charAt(j)]=0;
				}
				if(previousString.length()<currentString.length()){
					previousString.append(currentString.toString());
					currentString.delete(0, currentString.length());
					currentString.append(s.charAt(i));
				}
			}
		}
		System.out.println(currentString.length()>previousString.length()?currentString:previousString);

	}

}
