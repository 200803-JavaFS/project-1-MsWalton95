package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Users;
import com.revature.services.UserService;

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
			
			
			Users u = om.readValue(body, Users.class);
			
//			String username = req.getParameter("user");
//			String password = req.getParameter("pwd");
			
			if(us.userLogin(u.getUsername(), u.getPassword())) {
				HttpSession ses = req.getSession();
				ses.setAttribute("user", u);
				ses.setAttribute("name", u.getFirstName());
				ses.setAttribute("loggedin", true);
	
				res.setStatus(200);
			}else {
				HttpSession ses = req.getSession(false);
				if (ses != null) {
					ses.invalidate();
				}
				res.setStatus(401);
			}
		}
	}
	
	public void logout(HttpServletRequest req, HttpServletResponse res) throws IOException {
		HttpSession ses = req.getSession(false);

		if (ses != null) {
			Users u = (Users) ses.getAttribute("user");
			ses.invalidate();
			res.setStatus(200);
			res.getWriter().println(u.getFirstName() + " has logged out successfully");
		} else {
			res.setStatus(400);
			res.getWriter().println("You must be logged in to logout!");
		}
	}
	
}
