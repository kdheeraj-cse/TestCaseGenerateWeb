package com.testGenerate.utilities.User;

import java.util.HashMap;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class User {
	private String userId;
	private String name;
	private Integer age;
	private String pass;
	private String email;
	private String address;
	private String userStatus;
	private String tempPass;
	private String lastLogin;
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setUserActive(String status) {
		this.userStatus = status;
	}
	
	public void setTempPass(String status) {
		this.tempPass = status;
	}
	
	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}
	
	public HashMap<Object, Object> getUserData(User obj)
	{
		HashMap<Object, Object> objMap = new HashMap<>();
		Gson objGson = new Gson();
		String userJson = objGson.toJson(obj);
		objMap = new Gson().fromJson(userJson, new TypeToken<HashMap<String, String>>(){}.getType());
		return objMap;
	}

		
	/*
public static void main(String[] args) {
	
	User objUser = new User();
	objUser.setName("Dheeraj");
	objUser.setAge(12);
	objUser.setEmail("kdheeraj@gmail.com");
	objUser.setPass("totaam");
	objUser.setAddress("Modinager");
	
	HashMap<String, String> map = objUser.getUserData(objUser); 

	for (String string : map.keySet()) {
		System.out.println("key is "+string+" and value is "+map.get(string));
	}
	
}	
*/

}

