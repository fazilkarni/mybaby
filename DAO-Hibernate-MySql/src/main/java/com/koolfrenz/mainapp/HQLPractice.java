package com.koolfrenz.mainapp;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.koolfrenz.entity.Product;
/**
 * Standard syntax is as follows
 * 
 * 
 * Query qry = session.createQuery("--- HQL command ---");
	List l = qry.list();
	Iterator it = l.iterator();
	while(it.hasNext())
	{
	  Object o = it.next();
	  Product p = (Product)o;
	  ----- ------- ---------
	}

 * @author mkarni
 *
 */
public class HQLPractice {
public static void main(String[] args) {
		
		Configuration  config = new  Configuration();
		config.configure("/resources/hibernate.cfg.xml");
		SessionFactory sf = config.buildSessionFactory();
		
		Session session = sf.openSession();

		Query  query = session.createQuery("select p.name,p.id from Product p where p.id>?");
		query.setParameter(0, 100);
		List products = query.list();
		Iterator itr = products.iterator();		
		while(itr.hasNext()){
			System.out.println("Product name = "+((Object[])itr.next()));
		}
		
		
		Criteria criteria = session.createCriteria(Product.class);
		Criterion crn = Restrictions.gt("id", new Integer(100));
		criteria.add(crn);
		criteria.list();
		
		 products = criteria.list();
		 itr = products.iterator();		
		while(itr.hasNext()){
			System.out.println("Product name = "+((Product)itr.next()).getName());
		}
		int pageNum = 3;
		int rowsPerPage = 3;
			
		Criteria criteria2 = session.createCriteria(Product.class);
		criteria2.setFirstResult((pageNum-1)*rowsPerPage);
		criteria2.setMaxResults(rowsPerPage);
		products = criteria2.list();
		
		itr = products.iterator();		
		while(itr.hasNext()){
			System.out.println("Product name = "+((Product)itr.next()).getName());
		}
		session.close();
		
		
		
	}
}
