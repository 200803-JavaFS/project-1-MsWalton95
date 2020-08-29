package com.revature.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.IUserDAO;
import com.revature.dao.UserDAO;
import com.revature.model.User;

public class LoginServlet extends HttpServlet{
	
	RequestDispatcher rd = null;

	IUserDAO dao = new UserDAO();
	User u = new User();
		
	public LoginServlet() {}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		u.setErsUsername(req.getParameter("user"));
		u.setErsPassword(req.getParameter("pwd"));
		
		String username = u.getErsUsername();
		String password = u.getErsPassword();
 
		
		PrintWriter out = resp.getWriter();
		
		if(u.getErsUsername().equals("e1") && u.getErsPassword().equals("e1")) {
			
			dao.login(u);
			String name =u.getUserFirstName();
			out.print(name);
			rd = req.getRequestDispatcher("homepage.html");
			rd.forward(req, resp);
		} else {
			out.print("<span style='color:red; text-align:center'>Invalid Username/Password</span>");
			rd = req.getRequestDispatcher("");
			rd.include(req, resp);
			
		}
		
	}
	
}
