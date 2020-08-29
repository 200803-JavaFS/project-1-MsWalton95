package com.revature.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.Reimbursement;
import com.revature.services.ReimbService;

public class ReimburseController {
	
	private static ReimbService rs = new ReimbService();
	private static ObjectMapper om = new ObjectMapper();
	
	
	public void getAllReimburse(HttpServletResponse res) throws IOException {
		List<Reimbursement> all = rs.getAll();
		
		if(all == null) {
			res.setStatus(204);
		}else {
			res.setStatus(200);
			res.getWriter().println(om.writeValueAsString(all));
		}
	}
	
	public void getAllPending(HttpServletResponse res) throws IOException{
		List<Reimbursement> pending = rs.getAllPending();
		
		if(pending == null) {
			res.setStatus(204);
		}else {
			res.setStatus(200);
			res.getWriter().println(om.writeValueAsString(pending));
		}
	}
	
	public void getAllDenied(HttpServletResponse res) throws IOException{
		List<Reimbursement> denied = rs.getAllDenied();
		
		if(denied == null) {
			res.setStatus(204);
		}else {
			res.setStatus(200);
			res.getWriter().println(om.writeValueAsString(denied));
		}
	}
	
	public void getUser(HttpServletResponse res, int userID) throws IOException{
		List<Reimbursement> user = rs.getByUserID(userID);
		
		if(user == null) {
			res.setStatus(204);
		}else {
			res.setStatus(200);
			res.getWriter().println(om.writeValueAsString(user));
		}
	}
	
	public void getReimburse(HttpServletResponse res, int reimbID) throws IOException{
		Reimbursement re = rs.getByReimbID(reimbID);
		
		if(re == null) {
			res.setStatus(204);
		}else {
			res.setStatus(200);
			res.getWriter().println(om.writeValueAsString(re));
		}
	}
	
	public void addReimburse(HttpServletResponse res, HttpServletRequest req) throws IOException{
		BufferedReader reader = req.getReader();
		
		StringBuilder s = new StringBuilder();
		
		String line = reader.readLine();
		
		while(line != null) {
			s.append(line);
			line = reader.readLine();
		}
		
		String body= new String(s);
		
		System.out.println(body);
		
		Reimbursement re = om.readValue(body, Reimbursement.class);
		
		System.out.println(re);
		
		if(rs.addReimburse(re)) {
			res.setStatus(201);
			res.getWriter().println("Avenger was created");
		}else {
			res.setStatus(403);
		}
	}
	
	public void updateReimburse(HttpServletResponse res, HttpServletRequest req) throws IOException{
		BufferedReader reader = req.getReader();
		
		StringBuilder s = new StringBuilder();
		
		String line = reader.readLine();
		
		while(line != null) {
			s.append(line);
			line = reader.readLine();
		}
		
		String body= new String(s);
		
		System.out.println(body);
		
		Reimbursement re = om.readValue(body, Reimbursement.class);
		
		System.out.println(re);
		
		if(rs.updateReimburse(re)) {
			res.setStatus(201);
			res.getWriter().println("Avenger was updated");
		}else {
			res.setStatus(403);
		}
	}



}
