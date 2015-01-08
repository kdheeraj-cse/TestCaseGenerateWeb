package com.testGenerate.servlets;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.testGenerate.operations.UserOperations;
import com.testGenerate.utilities.User.User;

@WebServlet(description = "Servlet for user Registration", urlPatterns = { "/register.do" })
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		User objUser = new User();
		objUser.setUserId(request.getParameter("userId"));
		objUser.setName(request.getParameter("name"));
		objUser.setAge(Integer.parseInt(request.getParameter("age")));
		objUser.setEmail(request.getParameter("email"));
		objUser.setAddress(request.getParameter("address"));
		
		HashMap<Object, Object> userData = objUser.getUserData(objUser);
		/*for (Object key : userData.keySet()) {
			System.out.println("key is "+key.toString() + " Data is "+userData.get(key));
			
		}*/
		
		UserOperations objOperations = new UserOperations();
		objOperations.userRegister(userData);
		
	}

}
