package com.koolfrenz.mainapp;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.koolfrenz.entity.Product;

public class NamedQueries {

	public static void main(String[] args) {
		
		Configuration  config = new  Configuration();
		config.configure("/resources/hibernate.cfg.xml");
		SessionFactory sf = config.buildSessionFactory();
		
		Session session = sf.openSession();
		
		Product product = null;
		Query query = session.getNamedQuery("select_query");
		query.setParameter("productId", 108);
		List products = query.list();
		Iterator itr = products.iterator();
		while(itr.hasNext()){
			product = (Product)itr.next();
			System.out.println(product.getName());
		}
		
		
		 query = session.getNamedQuery("sql_select_query");
		
//		products = query.list();
//		itr = products.iterator();
//		while(itr.hasNext()){
//			product = ()itr.next();
//			System.out.println(product.getName());
//		}
		
		
		
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
