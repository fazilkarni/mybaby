package dao.DAO_Mongo;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class Mongo_Java_Communication_1 {
	MongoClient mongoClient;
	DB db;
	public Mongo_Java_Communication_1() throws UnknownHostException{
		mongoClient = new MongoClient("localhost",27017);
	    db = mongoClient.getDB("node-mong-db");
	}
	public static void main(String[] args) {

		
			try {
				Mongo_Java_Communication_1 mongoDBExplorer = new Mongo_Java_Communication_1();
				//mongoDBExplorer.insertRecords();
				//mongoDBExplorer.delete();
				
				//DBObject object = new BasicDBObject("age",new BasicDBObject("$gt",98)).append("name", "fazil/");
				//DBObject object = new BasicDBObject("{"name": "/.*fa.*/"}");
				
				
				
				System.out.println("With query: ");
			//	mongoDBExplorer.queryCriteriaBased(object);
//				System.out.println("Result without qury");
//				mongoDBExplorer.queryCriteriaBased(null);
				
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
	
	public void queryCriteriaBased(DBObject queryObject) throws UnknownHostException{
			
		DBCollection collection = db.getCollection("students");
		DBCursor cursor = null;
		if(queryObject!=null){
			 cursor = collection.find(queryObject);
		}else{
			 cursor = collection.find(queryObject);
		}
		display(cursor);
		
	}
	@Override
	protected void finalize() throws Throwable {
		mongoClient.close();
	}
	
	public void display(DBCursor cursor) throws UnknownHostException{
				while(cursor.hasNext()){
				DBObject obj1 = cursor.next();
				System.out.print(obj1.get("name"));
				System.out.println(" "+obj1.get("age"));
			}
			
					
	}
	
	public void insertRecords() throws UnknownHostException{
		
		System.out.println("Connected successfully and collections = "+db.getCollectionNames());
		
		DBCollection collection = db.getCollection("students");
		
		DBObject obj;
		for(int i=0;i<=1000;i++){
			obj = new BasicDBObject("name","Fazil-"+i).append("age",(int) (Math.random()*100));
			collection.insert(obj);
		}
	}
	public void delete(){
		DBCollection collection = db.getCollection("students");
		collection.drop();
	}
}
