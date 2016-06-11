package com.koolfrenz.mainapp.mappings;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.koolfrenz.entity.Customer;
import com.koolfrenz.entity.Product;
import com.koolfrenz.entity.Transaction;

public class OneToOne {

	public static void main(String[] args) {
		
		Configuration  config = new  Configuration();
		config.configure("/resources/hibernate.cfg.xml");
		SessionFactory sf = config.buildSessionFactory();
		
		Session session = sf.openSession();
		Customer customer = new Customer();
		com.koolfrenz.entity.hibernate.Transaction transaction = session.beginTransaction();
		Transaction trx = new Transaction();
		trx.setName("Laptop baught");
		trx.setTotal(2000);
		//session.save(trx);
		customer.setTransaction(trx);
		customer.setAddress("Bangalore");
		customer.setEmail("karni.fazil@gmail.com");
		customer.setName("Fzil");
		
	
		session.save(customer);
		
		transaction.commit();
		session.close();
	}
	
	
}
