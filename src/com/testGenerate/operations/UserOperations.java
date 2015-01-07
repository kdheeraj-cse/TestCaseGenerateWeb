package com.testGenerate.operations;

import java.io.File;
import java.net.UnknownHostException;
import java.util.HashMap;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.testGenerate.utilities.Common.Constant;

public class UserOperations {
	
	public HashMap<String,String> credentialsStatus(String inputID, String inputPass) throws UnknownHostException
	{
		HashMap<String,String> userStatus = new HashMap<>();
		HashMap<String, String> queryData = new HashMap<String, String>();
		queryData.put("name", inputID);
		queryData.put("pass", inputPass);
		
		DBOperations objDbOperations = new DBOperations(Constant._SERVER, Constant._PORT,"TestCaseGenerate");
		BasicDBObject queryObject = objDbOperations.getQueryObject(queryData);
		DBObject dataObject = objDbOperations.getDataObject(Constant._USERCOL, queryObject);
		
		if (dataObject != null) {   //valid credentails
			userStatus.put(Constant._ISLOGINVALID, "true");
			userStatus.put(Constant._ISTEMPPASS, dataObject.get("tempPass").toString());
			userStatus.put(Constant._LASTLOGIN, dataObject.get("lastLogin").toString());
		}
		else {
			userStatus.put(Constant._ISLOGINVALID, "false");
		}
		objDbOperations.closeConnection();
		return userStatus;
	}
	
	private String generateRandomPass() {
		return "random";
	}
	
	
	public void userRegister(HashMap<Object, Object> detailsMap) throws UnknownHostException
	{
		detailsMap.replace("pass", "", generateRandomPass()); //Set the random pass and send mail to user 
		detailsMap.replace("tempPass", "true");
		//TODO: Mail send code
		
		DBOperations objDbOperations = new DBOperations(Constant._SERVER, Constant._PORT,"TestCaseGenerate");
		objDbOperations.insertData(Constant._USERCOL, detailsMap);
		System.out.println("Temp pass is "+detailsMap.get("tempPass"));
		Boolean userFolderPath = new File(Constant._PARENTPATH.concat(detailsMap.get("userName").toString())).mkdir();
		System.out.println("folder create status "+userFolderPath);
		
	}
}
