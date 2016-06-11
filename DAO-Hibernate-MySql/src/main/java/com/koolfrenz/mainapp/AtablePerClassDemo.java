package com.koolfrenz.mainapp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.koolfrenz.entity.Check;
import com.koolfrenz.entity.CreditCard;
import com.koolfrenz.entity.Payment;

public class AtablePerClassDemo {
	
public static void main(String[] args) {
		
		Configuration  config = new  Configuration();
		config.configure("/resources/hibernate.cfg.xml");
		SessionFactory sf = config.buildSessionFactory();
		
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		CreditCard  creditCardPayment = new CreditCard();
		creditCardPayment.setId(11);
		creditCardPayment.setAmount(10000000);
		creditCardPayment.setCreditCardType("Visa international");
		
//		18:01:03.209 [main] ERROR o.h.e.jdbc.spi.SqlExceptionHelper - Field 'DCOLUMN' doesn't have a default value
		
		Payment payment = new Payment();
		payment.setId(13);
		payment.setAmount(100000000);
		
		session.save(payment);
		session.save(creditCardPayment);
		//session.save(checkPayment);
		
		tx.commit();
		session.close();

		
		
	}

}
