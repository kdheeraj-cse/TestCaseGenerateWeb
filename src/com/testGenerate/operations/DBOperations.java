package com.testGenerate.operations;

import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Set;

import org.apache.wink.json4j.JSONException;
import org.apache.wink.json4j.OrderedJSONObject;

import sun.management.counter.Variability;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;
import com.testGenerate.utilities.Common.Constant;
import com.testGenerate.utilities.User.User;

public class DBOperations {
	
	private static MongoClient objMongoClient = null;
	private static DB objDb = null;
	
	public DBOperations(String url,Integer port, String database) throws UnknownHostException {
		if (objMongoClient==null) {
			objMongoClient = new MongoClient(url,port);
		}
		if (objDb==null) {
			objDb = objMongoClient.getDB(database);
		}
	}
	
	
	
	DBCollection createCollection(String collectionName)
	{
		DBCollection objCollection = null;
		objCollection=objDb.createCollection(collectionName, null);
		return objCollection;
	}
	
	
	void insertData(String collectionName, HashMap<Object,Object> data)
	{
		BasicDBObject obj = new BasicDBObject(data);
		objDb.getCollection(collectionName).insert(obj);
	}
	
	/*
	 * function : getDataObject
	 * param : String - collection name from which data is required (equivalent to table in RDM)
	 * 		   BasicDBObject - query object
	 * return : DBObject - Data name value pair
	 * */
	
	
	DBObject getDataObject(String collectionName,BasicDBObject obj)
	{
		//System.out.println(objDb.getCollection(collectionName).findOne(obj));
		DBObject objDbObject = objDb.getCollection(collectionName).findOne(obj);
		System.out.println(objDbObject);
		return objDbObject;
	}

	/*
	 * function : getQueryObject
	 * param : String - 'key' equivalent to data name, 'value' equivalent to data value  
	 * return : BasicDBObject
	 * 
	 * this function is used to get a BasicDBObject which is required to query the database
	 * 
	 * */
	
	BasicDBObject getQueryObject(HashMap<String, String> queryMap)
	{
		BasicDBObject objDbObject = new BasicDBObject();
		for (String key : queryMap.keySet()) {
			objDbObject.append(key, queryMap.get(key));
		}
		return objDbObject;
	}

	public WriteResult updateObject(String collectionName, DBObject query, DBObject newObj) {
		WriteResult objResult = objDb.getCollection(collectionName).update(query,newObj);
		return objResult;
	}
	
	void closeConnection()
	{
		objMongoClient.close();
	}
	
	/*
	public static void main(String[] args) {
		
		DBOperations objDbOperations = null;
		try {
			objDbOperations = new DBOperations("localhost", 27017,"TestCaseGenerate");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		User objUser = new User();
		objUser.setName("Rakesh");
		objUser.setAge(23);
		objUser.setEmail("krakesh.cse@gmail.com");
		objUser.setPass("kfiofdw");
		objUser.setAddress("Delhi");
		
		HashMap<Object, Object> userMap = objUser.getUserData(objUser);
		objDbOperations.insertData("USER", userMap);
		
		DBObject obj = objDbOperations.getDataObject("USER", objDbOperations.getQueryObject("name", "Rakesh"));
		System.out.println(obj.keySet());
		
			
	}
	
	*/
}
