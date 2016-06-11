package com.koolfrenz.mainapp;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.koolfrenz.entity.Product;

public class VersionDemo {

	public static void main(String[] args) {
		VersionDemo versionDemo = new VersionDemo();
		Configuration  config = new  Configuration();
		config.configure("/resources/hibernate.cfg.xml");
		SessionFactory sf = config.buildSessionFactory();
		Session session = sf.openSession();
		versionDemo.createProduct(session);
		//versionDemo.update(session);
		
		
		
	}
	public void update(Session session){
		Transaction tx = session.beginTransaction();
		Product product = (Product) session.load(Product.class, new Integer(108));
		try{
			System.out.println("Waiting....");
			Thread.sleep(15000);
		}catch(Exception e){
			
		}
		product.setName("updated to check version latest");
		tx.commit();
		session.close();
	}
	public void createProduct(Session session){

		Product product = new Product();
		product.setName("Computer CPU 22");
		product.setId(110);
		//product.setPrice(25000);
		Transaction tx = session.beginTransaction();
		session.save(product);
		tx.commit();
		session.close();
	}
	
	
}
