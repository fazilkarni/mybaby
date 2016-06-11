package com.koolfrenz.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.koolfrenz.HelloWorld;
import com.koolfrenz.JavaCollection;
import com.koolfrenz.TextEditor;
import com.koolfrenz.model.Address;
import com.koolfrenz.model.Customer;

public class AOP {
	//static Logger log = Logger.getLogger(HelloWorldMainApp.class.getName());

	public static void main(String[] args) {
		//log.debug("Debug info");
		ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("Beans.xml");
		
		//AnnotationConfigApplicationContext  classPathXmlApplicationContext = new AnnotationConfigApplicationContext("Beans.xml");
		CustomerService cs = (CustomerService)classPathXmlApplicationContext.getBean("customerServiceProxy");
		cs.printName();
		cs.printThrowException();
		

	}
	
	

}
