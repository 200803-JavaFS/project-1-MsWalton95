package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.User;
import com.revaure.services.UserService;

public class LoginController {
	
	private static UserService us = new UserService();
	private static ObjectMapper om = new ObjectMapper();
	
	public void login(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		if (req.getMethod().equals("POST")) {
			BufferedReader reader = req.getReader();
	
			StringBuilder sb = new StringBuilder();
	
			String line = reader.readLine();
	
			while (line != null) {
				sb.append(line);
				line = reader.readLine();
			}
	
			String body = new String(sb);
			User u = om.readValue(body, User.class);
			
			
	//		String username = req.getParameter("user");
	//		String password = req.getParameter("pwd");

	//		u.setUsername(username);
	//		u.setPassword(password);
			
	//		RequestDispatcher rd = null;
		
			if(us.userLogin(u)) {
				us.userLogin(u);
				HttpSession ses = req.getSession();
				ses.setAttribute("user", u);
				ses.setAttribute("name", u.getFirstName());
				ses.setAttribute("loggedin", true);
	
				res.setStatus(200);
				System.out.println("Login Successful");
	//			rd = req.getRequestDispatcher("profile.html");
	//			rd.forward(req, res);
			}else {
				HttpSession ses = req.getSession(false);
				if (ses != null) {
					ses.invalidate();
				}
				res.setStatus(401);
				System.out.println("Login failed");
				
	//			rd = req.getRequestDispatcher("");
	//			rd.include(req, res);
			}
		}
	}
	
	public void logout(HttpServletRequest req, HttpServletResponse res) throws IOException {
		HttpSession ses = req.getSession(false);

		if (ses != null) {
			User u = (User) ses.getAttribute("user");
			ses.invalidate();
			res.setStatus(200);
			res.getWriter().println(u.getFirstName() + " has logged out successfully");
		} else {
			res.setStatus(400);
			res.getWriter().println("You must be logged in to logout!");
		}
	}
	
}
