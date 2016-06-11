package com.chapters.chapter03;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

public class IndexDemo extends DBConnection{
	
	public static void main(String[] args){
		IndexDemo indexDemo = new IndexDemo();
		//indexDemo.insertRecords();
		indexDemo.createIndex();
	}
	
	public void insertRecords(){
		System.out.println("Started insertion");
		DBCollection collection = db.getCollection("customers");

		DBObject obj = null;
		int i=0;
		long t1 = System.currentTimeMillis();
		for(i=0;i<1000000;i++){
			obj = new BasicDBObject("userId",i).append("code", i);
			collection.insert(obj);
		}
		long t2 = System.currentTimeMillis();
		System.out.println("Total rows inserted:"+i +" in "+(t2-t1)+" milliseconds");

	}
	
	public void createIndex(){
		DBCollection collection = db.getCollection("customers");
		collection.createIndex(new BasicDBObject("userId",1));
		System.out.println("Indexing done");
	}

}
