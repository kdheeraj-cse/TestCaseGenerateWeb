package com.testGenerate.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.omg.CORBA.PRIVATE_MEMBER;

import com.testGenerate.operations.UserOperations;


@WebServlet("/update.do")
public class UpdatePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public UpdatePassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		String oldPass = request.getParameter("old");
		String newPass = request.getParameter("new1");
		
		HttpSession session = request.getSession();
		session.setAttribute("oldPass", oldPass);
		session.setAttribute("newPass", newPass);
		
		UserOperations objOperations = new UserOperations();
		objOperations.updatePassword(request);
	}

}
