package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Users;
import com.revature.services.UserService;

public class LoginController {
	
	private static UserService us = new UserService();
	private static ObjectMapper om = new ObjectMapper();
	
	private static final Logger log = LogManager.getLogger(LoginController.class);
	
	public void login(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
			BufferedReader reader = req.getReader();
	
			StringBuilder sb = new StringBuilder();
	
			String line = reader.readLine();
	
			while (line != null) {
				sb.append(line);
				line = reader.readLine();
			}
	
			String body = new String(sb);
			
			Users u = om.readValue(body, Users.class);
			
			if(us.userLogin(u.getUsername(), u.getPassword())) {
				res.setStatus(200);
				getUserByLogin(req, res, u.getUsername());
				
			}else {
				HttpSession ses = req.getSession(false);
				if (ses != null) {
					ses.invalidate();
				}
				res.setStatus(401);
			}
	}
	
	public void getUserByLogin(HttpServletRequest req, HttpServletResponse res, String username) throws IOException {
		List<Users> users = us.selectByUsername(username);
		Users u = us.selectbyId(users.get(0).getUserID()); 

		res.setStatus(200);
		HttpSession ses = req.getSession();
		ses.setAttribute("user", u);
		ses.setAttribute("loggedin", true);
		
		String json = om.writeValueAsString(u);
		res.getWriter().println(json);
		log.info("Logged in");
	}
	
	public void logout(HttpServletRequest req, HttpServletResponse res) throws IOException {
		HttpSession ses = req.getSession(false);

		if (ses != null) {
			Users u = (Users) ses.getAttribute("user");
			ses.invalidate();
			res.setStatus(200);
			res.getWriter().println("Logged out successfully");
			log.info("Logged out");
		} else {
			res.setStatus(400);
			res.getWriter().println("You must be logged in to logout!");
		}
	}
	
}
