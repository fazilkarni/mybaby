package com.koolfrenz;
/**
 * hello
 * @author fazil
 *
 */
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
	
	public void destruct(){
		System.out.println("Desctruct dddd");
	}
	
	public void init(){
		System.out.println("Init iiii:"+ instanceVariable);
	}

}
