package com.testGenerate.operations;

import java.util.HashMap;

import com.testGenerate.utilities.Constant;

public class UserOperations {
	
	public HashMap<String,String> credentialsStatus(String inputID, String inputPass)
	{
		HashMap<String,String> userStatus = new HashMap<>();
		userStatus.put(Constant.ISLOGINVALID, "false");
		userStatus.put(Constant.ISTEMPPASS, "false");
		userStatus.put("lastLogin", "");
		if(inputID.equals("admin")&&inputPass.equals("password"))
		{
			userStatus.put("isLoginValid", "true");
			userStatus.put("isTempPassword", "false");
		}
		return userStatus;
	}
}
