package com.chapters.chapter03;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.MongoClient;

public class DBConnection {
	 MongoClient mongoClient;
	 DB db;
	public DBConnection(){
		mongoClient = new MongoClient("localhost",27017);
		db = mongoClient.getDB("testdb");
	}

}
