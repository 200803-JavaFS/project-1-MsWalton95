package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Reimb;
import com.revature.models.ReimbStatus;
import com.revature.models.ReimbType;
import com.revature.services.ReimbService;
import com.revature.services.ReimbStatusService;
import com.revature.services.ReimbTypeService;

public class ReimbController {
	private static ReimbService rs = new ReimbService();
	
	private static ReimbTypeService rts = new ReimbTypeService();
	private static ReimbStatusService rss = new ReimbStatusService();
	
	private static ObjectMapper om = new ObjectMapper();
	
	private static final Logger log = LogManager.getLogger(ReimbController.class);
	
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
	
	public void getType(HttpServletResponse res, int id) throws IOException {
		ReimbType t = rts.selectbyId(id);
		
		if(t == null) {
			res.setStatus(204);
		} else {
			res.setStatus(200);
			String json = om.writeValueAsString(t);
			res.getWriter().println(json);
		}
		
	}
	
	public void getStatus(HttpServletResponse res, int id) throws IOException {
		ReimbStatus s = rss.selectbyId(id);
		
		if(s == null) {
			res.setStatus(204);
		} else {
			res.setStatus(200);
			String json = om.writeValueAsString(s);
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
	
	
	public void addReimb(HttpServletRequest req, HttpServletResponse res) throws IOException {
		BufferedReader reader = req.getReader();
		
		StringBuilder s = new StringBuilder();
		
		String line = reader.readLine();
		
		while(line != null) {
			s.append(line);
			line = reader.readLine();
		}
		
		String body = new String(s);
		
		Reimb r = om.readValue(body, Reimb.class);
		
		if (rs.insert(r)) {
			res.setStatus(201);
			log.info("New Ticket was created");
		} else {
			res.setStatus(403);
			log.warn("Unable to create ticket");
		}
	}
	
	public void updateReimb(HttpServletRequest req, HttpServletResponse res) throws IOException {
		BufferedReader reader = req.getReader();
		
		StringBuilder s = new StringBuilder();
		
		String line = reader.readLine();
		
		while(line != null) {
			s.append(line);
			line = reader.readLine();
		}
		
		String body = new String(s);
		
		Reimb r = om.readValue(body, Reimb.class);
		
		if(rs.update(r)) {
			res.setStatus(202); //Accepted
			log.info("New Ticket was updated");
		} else {
			res.setStatus(403);
			log.warn("Unable to update ticket");
		}
	}

}
