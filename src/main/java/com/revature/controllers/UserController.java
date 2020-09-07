package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Users;
import com.revature.services.UserService;

public class UserController {
	private static UserService us = new UserService();
	private static ObjectMapper om = new ObjectMapper();
	
	private static final Logger log = LogManager.getLogger(UserController.class);
	
	public void getUser(HttpServletResponse res, int id) throws IOException {
		Users u = us.selectbyId(id);
		
		if(u == null) {
			res.setStatus(204);
			log.warn("Unable to find user");
		} else {
			res.setStatus(200);
			log.info("User was found");
			
			String json = om.writeValueAsString(u);
			res.getWriter().println(json);
		}
	}
	
	public void getAllUsers(HttpServletResponse res) throws IOException {
		List<Users> all = us.selectAll();
		
		if(all.isEmpty()) {
			res.setStatus(204);
			log.warn("Unable to find any users");
		} else {
			res.setStatus(200);
			log.info("Found all users");
			
			String json = om.writeValueAsString(all);
			res.getWriter().println(json);
		}
	}

	public void addUser(HttpServletRequest req, HttpServletResponse res) throws IOException {
		BufferedReader reader = req.getReader();
		
		StringBuilder s = new StringBuilder();
		
		String line = reader.readLine();
		
		while(line != null) {
			s.append(line);
			line = reader.readLine();
		}
		
		String body = new String(s);
		
		Users u = om.readValue(body, Users.class);
		
		if (us.insert(u)) {
			res.setStatus(201);
			log.info("New User added");
		} else {
			res.setStatus(403);
			log.warn("Unable to add user");
		}
	}
}
