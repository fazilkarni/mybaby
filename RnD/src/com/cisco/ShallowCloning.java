package com.cisco;

public class ShallowCloning implements Cloneable{
	String a;
	int i;
	ShallowCloning parent;
	
	public ShallowCloning(String a,int i, ShallowCloning obj){
		this.a = a;
		this.i = i;
		this.parent = obj;
	}
	public static void main(String[] args) {
		ShallowCloning obj = new ShallowCloning("Class A",36,new ShallowCloning("Class B", 37, null));
		
		System.out.println(obj.parent.a+" "+obj.parent.i+obj.parent);
		ShallowCloning obj2 = (ShallowCloning)obj.clone();
		System.out.println(obj2.parent.a+" "+obj2.parent.i+" "+obj2.parent);
		
		String s = new String ("Hello");
		String ss = "Hello";
		System.out.println(ss.hashCode()==s.hashCode());
		

	}
	
	public Object clone() {
		Object obj=null;
		try {
			obj = super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}

}
