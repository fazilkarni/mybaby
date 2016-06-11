package com.koolfrenz.mainapp;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.koolfrenz.entity.Product;

public class HibernateMainApp {

	public static void main(String[] args) {
		
		Configuration  config = new  Configuration();
		config.configure("/resources/hibernate.cfg.xml");
		SessionFactory sf = config.buildSessionFactory();
		
		Session session = sf.openSession();
		
		
		/* update code*/
		Transaction tx = session.beginTransaction();
		Product  product = (Product) session.get(Product.class, new Integer(102));
		//product.setName("New name 2");
		System.out.println(product.getName()+" "+product.getId());
		product.setName("Fazil's bike");
		//Save code
		/*Product product = new Product();
		product.setName("Lappy");
		product.setId(106);
		product.setPrice(25000);
		Transaction tx = session.beginTransaction();
		session.save(product);*/
		//here perform the database transactions. such as save, update, get etc.
		
		tx.commit();
		session.close();
		
		session = sf.openSession();
		tx = session.beginTransaction();
		
		 Product product2 = (Product) session.get(Product.class, new Integer(102));
		session.merge(product);
		
		tx.commit();
		session.close();
		/*Delete code*/
		/*session = sf.openSession();
		tx = session.beginTransaction();
		product.setId(101); //= (Product) session.get(Product.class, new Integer(100));
		
	//	session.delete(product);
		tx.commit();
		session.close();*/
		
		
	}
	
	
}
