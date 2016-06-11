package com.koolfrenz.mainapp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.koolfrenz.entity.Check;
import com.koolfrenz.entity.CreditCard;
import com.koolfrenz.entity.Payment;

public class SingleTableForClassHeirarchyDemo {
	
public static void main(String[] args) {
		
		Configuration  config = new  Configuration();
		config.configure("/resources/hibernate.cfg.xml");
		SessionFactory sf = config.buildSessionFactory();
		
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		CreditCard  creditCardPayment = new CreditCard();
		creditCardPayment.setId(9);
		creditCardPayment.setAmount(10000000);
		creditCardPayment.setCreditCardType("Visa international");
		
		Check checkPayment = new Check();
		checkPayment.setId(10);
		checkPayment.setAmount(20000000);
		checkPayment.setCheckType("ICIC bank account payee");
		
		Payment payment = new Payment();
		payment.setId(6);
		payment.setAmount(100000000);
		
		session.save(payment);
		session.save(creditCardPayment);
		session.save(checkPayment);
		
		tx.commit();
		session.close();

		
		
	}

}
