package com.testGenerate.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.testGenerate.operations.UserOperations;
import com.testGenerate.utilities.Common.Constant;

@WebServlet(description = "Servlet for User Login functionality", urlPatterns = { "/userLogin.do" })
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Login() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String inputUserID = request.getParameter("userid");
		String inputUserPass = request.getParameter("password");
		
		
		UserOperations objUserOperations = new UserOperations();
		
		HashMap<String,String>loginStatus = objUserOperations.credentialsStatus(inputUserID, inputUserPass); 
		
		try {
			 String isCredentailsValid = loginStatus.get(Constant._ISLOGINVALID);
			 if (isCredentailsValid.equals("true")) {
				 
				 //setSession
				 
				 HttpSession session = request.getSession();
				 session.setAttribute("islogin", true);
				 session.setAttribute("user", inputUserID);
				 
				 session.setMaxInactiveInterval(30*60);
				 Cookie userName = new Cookie("userID", inputUserID);
				 userName.setMaxAge(30*60);
				 response.addCookie(userName);
				 String isTemporaryPassword = loginStatus.get(Constant._ISTEMPPASS);
				 String lastLoginTime = loginStatus.get(Constant._LASTLOGIN);
				 request.setAttribute("lastLoginTime", lastLoginTime);

				 RequestDispatcher objRequestDispatcher = null;
				 if(isTemporaryPassword.equals("true")){
					 //redirect to update password page
					 objRequestDispatcher = request.getRequestDispatcher("updatePassword.jsp");
				 }
				 else {
					//redirect to home page
					 objRequestDispatcher = request.getRequestDispatcher("home.jsp");
				}
				 objRequestDispatcher.forward(request, response);
			 }
			 else {
				System.out.println("InvalidCredentials");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
