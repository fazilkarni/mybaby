package com.koolfrenz;

public class HelloWorld {
	
	int instanceVariable;
	{
		instanceVariable++;
	}
	
	public String message;

	public String getMessage() {
		
		System.out.println(message);
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
//	public void destruct(){
//		System.out.println("Desctruct");
//	}
//	
//	public void init(){
//		System.out.println("Init :"+ instanceVariable);
//	}

}
