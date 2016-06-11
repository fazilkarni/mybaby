package com.koolfrenz;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.apache.*;

import com.koolfrenz.model.Address;
import com.koolfrenz.model.Customer;
import com.koolfrenz.service.CustomerManager;
import com.koolfrenz.service.CustomerManagerImpl;
public class HelloWorldMainApp {
	//static Logger log = Logger.getLogger(HelloWorldMainApp.class.getName());

	public static void main(String[] args) {
		//log.debug("Debug info");
		ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("Beans.xml");
		//AnnotationConfigApplicationContext  classPathXmlApplicationContext = new AnnotationConfigApplicationContext("Beans.xml");
		HelloWorld helloWorld = (HelloWorld)classPathXmlApplicationContext.getBean("helloWorld");
		helloWorld.getMessage();
		System.out.println("helloWorld bean"+helloWorld);
		
		
		helloWorld = (HelloWorld)classPathXmlApplicationContext.getBean("helloWorld");
		
		System.out.println("helloWorld second bean"+helloWorld);
		helloWorld.getMessage();
		
		TextEditor editor = (TextEditor)classPathXmlApplicationContext.getBean("textEditor");
		
		editor.spellCheck();
		
		JavaCollection javaCollection = (JavaCollection)classPathXmlApplicationContext.getBean("collectionMapper");
		javaCollection.getAnimalSet();
		javaCollection.getNames();
		javaCollection.getNameAddressMap();
		javaCollection.getProps();
		
		/* jdbc template example*/
//		JdbcTemplate jdbcTemplateObject = (JdbcTemplate)classPathXmlApplicationContext.getBean("jdbcTemplate");
//		String SQL = "select * from new_table";
//		List<Student> student = jdbcTemplateObject.query(SQL, 
//		                   new HelloWorldMainApp().new StudentMapper());
		
		
//		CustomerManager customerManager = classPathXmlApplicationContext.getBean("customerManager",CustomerManagerImpl.class);
// 
//        Customer cust = createDummyCustomer();
//        customerManager.createCustomer(cust);


	}
	
	private static Customer createDummyCustomer() {
        Customer customer = new Customer();
        customer.setId(2);
        customer.setName("Pankaj");
        Address address = new Address();
        address.setId(2);
        // setting value more than 20 chars, so that SQLException occurs
        address.setAddress("Albany Dr, San Jose, CA 95129");
        customer.setAddress(address);
        return customer;
    }
//	class StudentMapper implements RowMapper<Student> {
//
//		@Override
//		public Student mapRow(ResultSet rs, int arg1) throws SQLException {
//			// TODO Auto-generated method stub
//			 Student student = new Student();
//		     
//		      student.setName(rs.getString("name"));
//		      student.setAge(rs.getInt("age"));
//		      return student;
//		}
//	}
	class Student{
		public String name;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public int age;
		
	}

}
