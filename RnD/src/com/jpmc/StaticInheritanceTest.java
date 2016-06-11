package com.jpmc;

public class StaticInheritanceTest extends X{
	static int i;
	
	public final int z;
	public StaticInheritanceTest(){
		this.z=10;
	}
	public static void main(String[] args) {
		StaticInheritanceTest.hello();
		
		StaticInheritanceTest.i = 10;
		System.out.println(StaticInheritanceTest.i);
		StaticInheritanceTest.i = 20;
		System.out.println(StaticInheritanceTest.i);
	}
	
	public static void hello(){
		System.out.println("Hello static in sub class");
	}

}

class X{
	public static void hello(){
		System.out.println("Hello static in X");
	}
}

class YYY{
	public static final int i = 10;
	public  void amethod(){};
}
