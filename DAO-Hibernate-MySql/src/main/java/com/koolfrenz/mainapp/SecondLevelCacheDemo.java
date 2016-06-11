package com.koolfrenz.mainapp;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.koolfrenz.entity.Product;

public class SecondLevelCacheDemo {

	public static void main(String[] args) {
		
		Configuration  config = new  Configuration();
		config.configure("/resources/hibernate.cfg.xml");
		SessionFactory sf = config.buildSessionFactory();
		
		Session session1 = sf.openSession();

		Product  product = (Product) session1.get(Product.class, new Integer(102));
		session1.close();
		System.out.println("Product loaded from the memory "+product.getName());
		System.out.println("------------------------------waiting------------");
		try{
			Thread.sleep(10000);
		}catch(Exception e){
			System.out.println(e);
		}
		Session session2 = sf.openSession();
		Product  product2 = (Product) session2.get(Product.class, new Integer(102));
		System.out.println("Product loaded from the database "+product2.getName());
		
		session2.close();
		
		Session session3 = sf.openSession();
		Product  product3 = (Product) session3.get(Product.class, new Integer(102));
		System.out.println("Product loaded from the second level cache "+product3.getName());
		
		session3.close();
		
		
	}
	
	
}
