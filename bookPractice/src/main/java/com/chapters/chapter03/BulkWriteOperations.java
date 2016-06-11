package com.chapters.chapter03;

import com.mongodb.BasicDBObject;
import com.mongodb.BulkWriteOperation;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

public class BulkWriteOperations extends DBConnection{

	public static void main(String[] args) {
		BulkWriteOperations bop = new BulkWriteOperations();
		bop.nonBulkOperations();
		bop.bulkWriteOperations();

	}
	
	public void bulkWriteOperations(){

		System.out.println("Started Bulk  insertion");
		DBCollection collection = db.getCollection("customers");
		BulkWriteOperation builder = collection.initializeOrderedBulkOperation();
		DBObject obj = null;
		int i=0;
		
		for(i=0;i<1000000;i++){
			obj = new BasicDBObject("userId",i).append("code", i);
			builder.insert(obj);
		}
		long t1 = System.currentTimeMillis();
		builder.execute();
		long t2 = System.currentTimeMillis();
		System.out.println("Total Bulk rows inserted:"+i +" in "+(t2-t1)+" milliseconds");

	
	}
	
	public void nonBulkOperations(){

		System.out.println("Started non bulk insertion");
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

}
