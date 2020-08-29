package com.revature;

import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.List;

import com.revature.daos.*;
import com.revature.models.*;

public class Driver {

	
	public static UserRoleDAO urDao = new UserRoleDAO();
	public static UserDAO uDao = new UserDAO();
	
	public static ReimbDAO reDao = new ReimbDAO();
	public static ReimbTypeDAO rtDao = new ReimbTypeDAO();
	public static ReimbStatusDAO rsDao = new ReimbStatusDAO();
	
	public static void main(String[] args) {
		insertValues();
//		List<UserRole> urs = urDao.selectAll();
//		
//		for(UserRole ur: urs) {System.out.println(ur);}
		
		UserRole u = urDao.selectbyId(2);
		System.out.println(u);
		
		User use = uDao.selectbyId(3);
		System.out.println(use);
		
		ReimbStatus rs = rsDao.selectbyId(3);
		System.out.println(rs);
		
		ReimbType rt = rtDao.selectbyId(1);
		System.out.println(rt);
		
		Reimb re = reDao.selectbyId(1);
		System.out.println(re);
		
	}
	
	
	
		public static void insertValues() {
			UserRole ur1 = new UserRole("employee");
			UserRole ur2 = new UserRole("financial manager");
			
			urDao.insert(ur1);
			urDao.insert(ur2);
			
			User u1 = new User("emp1","emp1","Phoenix","Wright","pw@gmail.com", ur1);
			User u2 = new User("emp2","emp2","Miles","Edgeworth","em@gmail.com",ur2);
			User u3 = new User("emp3","emp3","Bobby","Fulbright","bf@gmail.com", ur2);
			
			uDao.insert(u1);
			uDao.insert(u2);
			uDao.insert(u3);
			
			ReimbStatus rs1 = new ReimbStatus("Accepted");
			ReimbStatus rs2 = new ReimbStatus("Pending");
			ReimbStatus rs3 = new ReimbStatus("Denied");
			
			rsDao.insert(rs1);
			rsDao.insert(rs2);
			rsDao.insert(rs3);
			
			ReimbType rt1 = new ReimbType("Lodging");
			ReimbType rt2 = new ReimbType("Food");
			ReimbType rt3 = new ReimbType("Travel");
			ReimbType rt4 = new ReimbType("Other");
			
			rtDao.insert(rt1);
			rtDao.insert(rt2);
			rtDao.insert(rt3);
			rtDao.insert(rt4);
			Calendar calendar = Calendar.getInstance();
		    Timestamp ourTime = new Timestamp(calendar.getTime().getTime());
			
			Reimb r1 = new Reimb(255.00, ourTime, null, "this is desc1", u2, u1,rs2, rt2);
			//amount,submitted,resolved,desc,author, resolver,status,type
			reDao.insert(r1);
		}
	

}
