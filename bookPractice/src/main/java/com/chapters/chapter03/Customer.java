package com.chapters.chapter03;

import java.net.UnknownHostException;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;

public class Customer {
	static MongoClient mongoClient;
	static DB db;

	String name;
	int age;
	String email;
	String phone;
	public Customer(String name,int age,String email,String phone){
		
		super();
		this.name = name;
		this.age = age;
		this.email = email;
		this.phone = phone;
		mongoClient = new MongoClient("localhost",27017);
		db = mongoClient.getDB("testdb");
	    
	}
	
	@Override
	public String toString(){
		return name+" "+age+" "+email+" "+phone;
	}


	public static void main(String args[]){
		
		System.out.println("Hello");
		Customer c = new Customer("fazil",36,"karni.fazil@gmail.com","9886143656");
		Gson gson = new Gson();
		String json = gson.toJson(c);
		DBObject dbObject = (DBObject)JSON.parse(json);
		DBCollection customerCollection = db.getCollection("customers");
		customerCollection.insert(dbObject);
		
		DBObject dbobject = new BasicDBObject().append("name","fazil");
		
		DBCursor cursor = customerCollection.find(dbobject);
		while(cursor.hasNext()){
			Customer customer = gson.fromJson(cursor.next().toString(),Customer.class);
			System.out.println(customer.name+" "+customer.age+" "+customer.email+" "+customer.phone);
		}
		
		
		
		
		
	}

}
