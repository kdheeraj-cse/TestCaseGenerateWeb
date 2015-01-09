package com.testGenerate.operations;

import java.io.File;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.sun.media.jfxmedia.events.NewFrameEvent;
import com.testGenerate.utilities.Common.Constant;

public class UserOperations {
	
	public HashMap<String,String> credentialsStatus(String inputID, String inputPass) throws UnknownHostException
	{
		HashMap<String,String> userStatus = new HashMap<>();
		HashMap<String, String> queryData = new HashMap<String, String>();
		queryData.put("userId", inputID);
		queryData.put("pass", inputPass);
		
		DBOperations objDbOperations = new DBOperations(Constant._SERVER, Constant._PORT,"TestCaseGenerate");
		BasicDBObject queryObject = objDbOperations.getQueryObject(queryData);
		DBObject dataObject = objDbOperations.getDataObject(Constant._USERCOL, queryObject);
		
		if (dataObject != null) {   //valid credentails
			userStatus.put(Constant._ISLOGINVALID, "true");
			userStatus.put(Constant._ISTEMPPASS, dataObject.get("tempPass").toString());
			try {
				userStatus.put(Constant._LASTLOGIN, dataObject.get("lastLogin").toString());
			} catch (Exception e) {
				userStatus.put(Constant._LASTLOGIN, new Date().toString());
			}
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
		detailsMap.put("pass", generateRandomPass()); //Set the random pass and send mail to user 
		detailsMap.put("tempPass", "true");
		detailsMap.put("lastLogin", new Date());
		//TODO: Mail send code
		
		DBOperations objDbOperations = new DBOperations(Constant._SERVER, Constant._PORT,"TestCaseGenerate");
		objDbOperations.insertData(Constant._USERCOL, detailsMap);
		System.out.println("Temp pass is "+detailsMap.get("tempPass"));
		
		String userFolder = Constant._PARENTPATH.concat("/").concat(detailsMap.get("userId").toString());
		if(new File(userFolder).mkdir()){
			new File(userFolder.concat("/").concat("excel")).mkdir();
			new File(userFolder.concat("/").concat("json")).mkdir();
			new File(userFolder.concat("/").concat("csv")).mkdir();
		}
		else {
			System.out.println("folder create status "+userFolder);			
		}
		objDbOperations.closeConnection();
	}
	
	public void updatePassword(HttpServletRequest request) throws UnknownHostException {
		
		HttpSession session = request.getSession();
		HashMap<String, String> passDetails = new HashMap<String, String>();
		passDetails.put("pass", session.getAttribute("oldPass").toString());
		passDetails.put("userId", session.getAttribute("user").toString());
		DBOperations objDbOperations = new DBOperations(Constant._SERVER, Constant._PORT,"TestCaseGenerate");
		BasicDBObject queryObj = objDbOperations.getQueryObject(passDetails);
		DBObject dataObject = objDbOperations.getDataObject(Constant._USERCOL, queryObj);
		
		if(dataObject!=null){
			passDetails.clear();
			passDetails.put("pass", session.getAttribute("newPass").toString());
			passDetails.put("tempPass", "false");
			BasicDBObject upateObj = objDbOperations.getQueryObject(passDetails);
			objDbOperations.updateObject(Constant._USERCOL, queryObj, upateObj);
		}
		else {
			System.out.println("password entered wrong");
		}
		objDbOperations.closeConnection();
	}
}
