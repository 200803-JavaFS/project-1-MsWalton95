package com.revature;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.hibernate.Session;

import com.revature.daos.*;
import com.revature.models.*;
import com.revature.util.HibernateUtil;

public class Driver {
//Fix inserting with creating other objects
	
	public static IUserRoleDAO urDao = new UserRoleDAO();
	public static UserDAO uDao = new UserDAO();
	
	public static ReimbDAO reDao = new ReimbDAO();
	public static ReimbTypeDAO rtDao = new ReimbTypeDAO();
	public static IReimbStatusDAO rsDao = new ReimbStatusDAO();
	
	public static void main(String[] args) {
		
//		insertValues();
		
		List<Reimb> reimb = reDao.selectByStatus(2);
		for(Reimb r: reimb) {System.out.println(r);}
		System.out.println("------------------------------");
		List<Reimb> reimb2 = reDao.selectByType(3);
		for(Reimb r: reimb2) {System.out.println(r);}
		System.out.println("------------------------------");
		List<User> user = uDao.selectByRole(2);
		for(User u: user) {System.out.println(u);}
		System.out.println("------------Author------------------");
		List<Reimb> reimb3 = reDao.selectByAuthor(2);
		for(Reimb r: reimb3) {System.out.println(r);}
		System.out.println("------------Resolver---------------");
		List<Reimb> reimb4 = reDao.selectByResolver(6);
		for(Reimb r: reimb4) {System.out.println(r);}
		System.out.println("------------------------------");
		
		
//		System.out.println("---------UserRoles------------");
//		List<UserRole> role = urDao.selectAll();
//		for(UserRole r: role) {System.out.println(r);}
		
//		System.out.println("-----------Users--------------");
//		List<User> user = uDao.selectAll();
//		for(User u: user) {System.out.println(u);}
		
//		System.out.println("-----------Type--------------");
//		List<ReimbType> type = rtDao.selectAll();
//		for(ReimbType t: type) {System.out.println(t);}
		
//		System.out.println("-----------Status--------------");
//		List<ReimbStatus> status = rsDao.selectAll();
//		for(ReimbStatus s: status) {System.out.println(s);}
		
//		System.out.println("-----------Reimbursement--------------");
//		List<Reimb> reimb = reDao.selectAll();
//		for(Reimb re: reimb) {System.out.println(re);}
		
//		System.out.println("-----------ReimbursementByFood--------------");
//		System.out.println("-----------ReimbursementByTravel--------------");
//		System.out.println("-----------ReimbursementByAccepted--------------");
//		System.out.println("-----------ReimbursementByPending--------------");
//		System.out.println("-----------ReimbursementByDenied--------------");
//		System.out.println("-----------User Name--------------");
//		User u = uDao.selectbyId(60);
//		System.out.println(u);
//		uDao.selectByRole(1);
//		System.out.println("-----------By ID--------------");
//		User u =uDao.selectbyId(1);
//		System.out.println(u);
//		UserRole ur =urDao.selectbyId(1);
//		System.out.println(ur);
//		Reimb r =reDao.selectbyId(2);
//		System.out.println(r);
//		
//		ReimbStatus rs = rsDao.selectbyId(2);
//		System.out.println(rs);
//		ReimbType rt =rtDao.selectbyId(3);
//		System.out.println(rt);
//		//uDao.selectByName("Phoenix");
//		System.out.println("-----------User Role--------------");
//		

	}

		public static void insertValues() { //Add new Employee object
			Session ses = HibernateUtil.getSession();

	        UserRole ur1 = new UserRole("Employee");
	        UserRole ur2 = new UserRole("Financial Manager");

	        ReimbType rt1 = new ReimbType("Lodging");
	        ReimbType rt2 = new ReimbType("Food");
	        ReimbType rt3 = new ReimbType("Travel");
	        ReimbType rt4 = new ReimbType("Other");
	        
	        ReimbStatus rs1 = new ReimbStatus("Accepted");
	        ReimbStatus rs2 = new ReimbStatus("Pending");
	        ReimbStatus rs3 = new ReimbStatus("Denied");
	       
//	        urDao.insert(ur1);
//	        urDao.insert(ur2);
//	        
//	        rtDao.insert(rt1);
//	        rtDao.insert(rt2);
//	        rtDao.insert(rt3);
//	        rtDao.insert(rt4);
//	        
//	        rsDao.insert(rs1);
//	        rsDao.insert(rs2);
//	        rsDao.insert(rs3);
	        
			User u1 = new User("emp1", "emp1", "Phoenix", "Wright", "phoenixwright@aceattorney.com", ur1);
			User u2 = new User("emp2", "emp2", "Maya", "Fey", "mayafey@aceattorney.com", ur1);
			User u3 = new User("emp3", "emp3", "Dick", "Gumshoe", "dickgumshoe@aceattorney.com", ur1);
			User u4 = new User("emp4", "emp4", "Mia", "Fey", "miafey@aceattorney.com", ur2);
			User u5 = new User("emp5", "emp5", "Miles", "Edgeworth", "milesedgeworth@aceattorney.com", ur2);
			User u6 = new User("emp6", "emp6", "Bobby", "Fulbright", "bobbyfulbright@aceattorney.com", ur2);
			                
//			User u10 = new User(1,"emp1", "emp1", "Trucy", "Wright", "trucywright@aceattorney.com", ur1);
//			uDao.update(u10);
			
			Calendar calendar = Calendar.getInstance();
			Timestamp current = new Timestamp(calendar.getTime().getTime());
			  
			Reimb r1 = new Reimb(250.00, current, current, "This is a description", u1, u5,rs1, rt1);
			Reimb r2 = new Reimb(50.00, current, current, "This is a description2", u1, u6, rs1, rt2);
			Reimb r3 = new Reimb(60.00, current, null, "This is a description3", u1, u5, rs2, rt3);
			Reimb r4 = new Reimb(66.00, current, current, "This is a description4", u3, u4, rs3, rt3);
			Reimb r5 = new Reimb(22.00, current, null, "This is a description5", u2, u4, rs2,rt3);
		      
//		        uDao.insert(u1);
//		        uDao.insert(u2);
//		        uDao.insert(u3);
//		        uDao.insert(u4);
//		        uDao.insert(u5);
//		        uDao.insert(u6);	
//		      
//		      reDao.insert(r1);
//		      reDao.insert(r2);
//		      reDao.insert(r3);
//		      reDao.insert(r4);
//		      reDao.insert(r5);
		}
		

}
