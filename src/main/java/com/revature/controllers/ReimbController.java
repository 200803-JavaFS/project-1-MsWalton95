package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Reimb;
import com.revature.models.ReimbType;
import com.revature.services.ReimbService;
import com.revature.services.ReimbTypeService;

public class ReimbController {
	private static ReimbService rs = new ReimbService();
	private static ObjectMapper om = new ObjectMapper();
	
	public void getReimb(HttpServletResponse res, int id) throws IOException {
		Reimb r = rs.selectbyId(id);
		
		if(r == null) {
			res.setStatus(204);
		} else {
			res.setStatus(200);
			String json = om.writeValueAsString(r);
			res.getWriter().println(json);
		}
		
	}
	
	public void getAllReimb(HttpServletResponse res) throws IOException {
		List<Reimb> all = rs.selectAll();
		
		if(all.isEmpty()) {
			res.setStatus(204);
			res.getWriter().println("There are no tickets");
		}else {
			res.setStatus(200);
			String json = om.writeValueAsString(all);
			res.getWriter().println(json);
		}
		
		
	}
	
	public void getAllReimbByUser(HttpServletResponse res, int id) throws IOException {
		List<Reimb> all = rs.selectByUser(id);

		if(all.isEmpty()) {
			res.setStatus(204);
			res.getWriter().println("There are no tickets by this user");
		}else {
			res.setStatus(200);
			String json = om.writeValueAsString(all);
			res.getWriter().println(json);
		}
	}       
	
	
	public void addReimb(HttpServletRequest req, HttpServletResponse res, int id) throws IOException {
		BufferedReader reader = req.getReader();
		
		StringBuilder s = new StringBuilder();
		
		String line = reader.readLine();
		
		while(line != null) {
			s.append(line);
			line = reader.readLine();
		}
		
		String body = new String(s);
		
		System.out.println(body);
		
		Reimb r = om.readValue(body, Reimb.class);
		
		System.out.println(r);
		
		if (rs.insert(r)) {
			res.setStatus(201);
			res.getWriter().println("New Ticket was created");
		} else {
			res.setStatus(403);
		}
	}
	
//	public boolean update(Reimb re);
//	public List<Reimb> selectAll();
//	public List<Reimb> selectByStatus(int id);
//	public List<Reimb> selectByType(int id);
//	public List<Reimb> selectByAuthor(int id);
//	public List<Reimb> selectByResolver(int id);

}
