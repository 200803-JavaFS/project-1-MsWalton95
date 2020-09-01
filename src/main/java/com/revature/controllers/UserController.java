package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.User;
import com.revaure.services.UserService;

public class UserController {
	private static UserService us = new UserService();
	private static ObjectMapper om = new ObjectMapper();
	
	public void getUser(HttpServletResponse res, int id) throws IOException {
		User u = us.selectbyId(id);
		if(u == null) {
			res.setStatus(204);
		} else {
			res.setStatus(200);
			String json = om.writeValueAsString(u);
			res.getWriter().println(json);
		}
		
	}
	
	public void getAllUsers(HttpServletResponse res) throws IOException {
		res.setStatus(200);
		List<User> users = us.selectAll();
		String json = om.writeValueAsString(users);
		res.getWriter().println(json);
		
		
	}

	public void addUser(HttpServletRequest req, HttpServletResponse res, int id) throws IOException {
		BufferedReader reader = req.getReader();
		
		StringBuilder s = new StringBuilder();
		
		String line = reader.readLine();
		
		while(line != null) {
			s.append(line);
			line = reader.readLine();
		}
		
		String body = new String(s);
		
		System.out.println(body);
		
		User u = om.readValue(body, User.class);
		
		System.out.println(u);
		
		if (us.insert(u, id)) {
			res.setStatus(201);
			res.getWriter().println("Avenger was created");
		} else {
			res.setStatus(403);
		}
		
	}

//	public boolean update(User u, int id);
//	
//	public User selectbyId(int id);
//	
//	public List<User> selectAll();
//	
//	public List<User> selectByRole(int id);
//	
//	public List<User> selectByName(String fname,String lname);
//	
//	public boolean userLogin(User u);
}
