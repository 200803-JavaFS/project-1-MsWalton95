package com.revature.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.IReimbDAO;
import com.revature.dao.IUserDAO;
import com.revature.dao.ReimbDAO;
import com.revature.dao.UserDAO;
import com.revature.model.Reimbursement;
import com.revature.model.User;

public class AddTicketServlet extends HttpServlet{
		
		IReimbDAO dao = new ReimbDAO();
		Reimbursement re = new Reimbursement();
		
		public AddTicketServlet() {}

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			resp.sendRedirect("addTicket.html");
		}

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			PrintWriter out = resp.getWriter();
			
//			re.setReimbType(req.getParameter("type"));
//			re.setReimbType();
//			re.setReimbAmount(Double.parseDouble(req.getParameter("amount")));
//			re.setReimbDesc(req.getParameter("description"));
//			re.setReimbAuthor(1);
//			
//			dao.addReimburse(re);
			req.getRequestDispatcher("homepage.html").forward(req, resp);
			out.print(re);
		}
}
