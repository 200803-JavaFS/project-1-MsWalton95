package com.revature.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controller.ReimburseController;
import com.revature.model.Reimbursement;

public class MasterServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static ReimburseController rc = new ReimburseController();
	private static Reimbursement re = new Reimbursement();
	
	public MasterServlet() {}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.setContentType("application/json");
		res.setStatus(404);
		
		final String URI = req.getRequestURI().replace("/project1/", "");
		
		String[] portions = URI.split("/");
		System.out.println(Arrays.toString(portions));
		
		try {
			switch(portions[0]) {
				case "reimbursement":
					if(req.getMethod().equals("GET")) {
						if(portions.length == 2) {
							int id = Integer.parseInt(portions[1]);
							rc.getReimburse(res, id);
						} else if(portions.length == 1) {
							rc.getAllReimburse(res);
						}
					} else if(req.getMethod().equals("POST")) {
						rc.addReimburse(res, req);
					}
					break;
				case "login": 
					break;
				case "logout": break;
			}
			
		}catch(NumberFormatException e) {
			e.printStackTrace();
			res.getWriter().print("");
			res.setStatus(400);
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
