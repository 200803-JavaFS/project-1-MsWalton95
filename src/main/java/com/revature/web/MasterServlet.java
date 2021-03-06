package com.revature.web;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.revature.controllers.LoginController;
import com.revature.controllers.ReimbController;
import com.revature.controllers.UserController;

public class MasterServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private static LoginController lc = new LoginController();
	private static UserController uc = new UserController();
	private static ReimbController rc = new ReimbController();
	
	public MasterServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	res.setContentType("application/json");
	res.setStatus(404);

	final String URI = req.getRequestURI().replace("/project0/", "");

	String[] portions = URI.split("/");

	System.out.println(Arrays.toString(portions));
	if(portions.length==0) {
		req.getRequestDispatcher("index.html").forward(req, res);
	}
	try {
		switch (portions[0]) {
			case "user":
				if (req.getSession(false) != null && (boolean) req.getSession().getAttribute("loggedin")) {
					if (req.getMethod().equals("GET")) {
						if (portions.length == 1) {		
							uc.getAllUsers(res);
						} else if (portions.length == 2) {	
							int id = Integer.parseInt(portions[1]);
							uc.getUser(res, id);
						}
					} else if (req.getMethod().equals("POST")) {
							uc.addUser(req, res);
					}
				} else {
					res.setStatus(403);
					res.getWriter().println("You must be logged in to do that!");
				}
				break;
			case "reimbursement": //ex. reimbursement length:1		//ex. reimbursement/2  length:2		//ex. reimbursement/user/2 length:3
				if (req.getSession(false) != null && (boolean) req.getSession().getAttribute("loggedin")) {
					if (req.getMethod().equals("GET")) { // [0]reimbursement/[1]user/[2]/[3]status/[4]
						if (portions.length == 1) {					
							rc.getAllReimb(res);
						} else if (portions.length == 2) {			
							int id = Integer.parseInt(portions[1]);
							rc.getReimb(res, id);
						} else if (portions.length == 3) {
							int id = Integer.parseInt(portions[2]);
							rc.getAllReimbByUser(res, req, id);
						}
					} else if (req.getMethod().equals("POST")) {	//ex. reimbursement/user/2/type/3 length:5
						switch(portions[3]) {
						case "type":
								int author = Integer.parseInt(portions[2]);
								int type = Integer.parseInt(portions[4]);
								rc.addReimb(req, res, author, type);
							break;
						case "status":
							int resolver = Integer.parseInt(portions[2]);
							int status = Integer.parseInt(portions[4]);		//reimbursement/user/1/status/3
							rc.updateReimb(req, res, resolver, status);
							break;
						}
					}
				} else {
					res.setStatus(403);
					res.getWriter().println("You must be logged in to do that!");
				}
				break;
			case "type":
				int id = Integer.parseInt(portions[1]);
				rc.getType(res, id);
				break;
			case "status":
				int id2 = Integer.parseInt(portions[1]);
				rc.getStatus(res, id2);
				break;
			case "login":
				lc.login(req, res);
				break;
			case "logout":
				lc.logout(req, res);
				break;
		}
	} catch (NumberFormatException e) {
		e.printStackTrace();
		res.getWriter().print("The id you provided is not an integer");
		res.setStatus(400);
	}

}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
 