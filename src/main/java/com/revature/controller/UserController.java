package com.revature.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.Reimbursement;
import com.revature.model.User;
import com.revature.services.UserService;

public class UserController {
	
	private static UserService us = new UserService();
	private static ObjectMapper om = new ObjectMapper();
	
	public void getAllUser(HttpServletResponse res) throws IOException {
		List<User> all = us.getAll();
		
		if(all == null) {
			res.setStatus(204);
		}else {
			res.setStatus(200);
			res.getWriter().println(om.writeValueAsString(all));
		}
	}

	public void getUserByID(HttpServletResponse res, int id) throws IOException{
		User u = us.getUserByID(id);
		
		if(u == null) {
			res.setStatus(204);
		}else {
			res.setStatus(200);
			res.getWriter().println(om.writeValueAsString(u));
		}
		
	}

	public void login(HttpServletResponse res, HttpServletRequest req) throws IOException{
		
	}

	public void addUser(HttpServletResponse res, HttpServletRequest req) throws IOException{
		BufferedReader reader = req.getReader();
		
		StringBuilder s = new StringBuilder();
		
		String line = reader.readLine();
		
		while(line != null) {
			s.append(line);
			line = reader.readLine();
		}
		
		String body= new String(s);
		
		System.out.println(body);
		
		User u = om.readValue(body, User.class);
		
		System.out.println(u);
		
		if(us.addUser(u)) {
			res.setStatus(201);
			res.getWriter().println("User was created");
		}else {
			res.setStatus(403);
		}
	}

	public void updateUser(HttpServletResponse res, HttpServletRequest req) throws IOException{
		BufferedReader reader = req.getReader();
		
		StringBuilder s = new StringBuilder();
		
		String line = reader.readLine();
		
		while(line != null) {
			s.append(line);
			line = reader.readLine();
		}
		
		String body= new String(s);
		
		System.out.println(body);
		
		User u = om.readValue(body, User.class);
		
		System.out.println(u);
		
		if(us.updateUser(u)) {
			res.setStatus(201);
			res.getWriter().println("User was updated");
		}else {
			res.setStatus(403);
		}
	}

	public void deleteUser(HttpServletResponse res, int id) throws IOException{
		//User u = us.deleteUser(id);
		
	}
}
