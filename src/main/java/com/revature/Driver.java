package com.revature;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.hibernate.Session;

import com.revature.daos.*;
import com.revature.models.*;
import com.revature.util.HibernateUtil;
import com.revaure.services.ReimbService;
import com.revaure.services.ReimbStatusService;
import com.revaure.services.ReimbTypeService;
import com.revaure.services.UserRoleService;
import com.revaure.services.UserService;

public class Driver {
//Fix inserting with creating other objects
	
	public static UserService us = new UserService();
	public static UserRoleService urs = new UserRoleService();
	
	public static ReimbService re = new ReimbService();
	public static ReimbTypeService rt = new ReimbTypeService();
	public static ReimbStatusService rs = new ReimbStatusService();
	
	public static void main(String[] args) {
		//NO DUPLICATE ENTRY
		insertValues();
	}

		public static void insertValues() { 
	        UserRole ur1 = new UserRole("Employee");
	        UserRole ur2 = new UserRole("Financial Manager");

	        ReimbType rt1 = new ReimbType("Lodging");
	        ReimbType rt2 = new ReimbType("Food");
	        ReimbType rt3 = new ReimbType("Travel");
	        ReimbType rt4 = new ReimbType("Other");
	        
	        ReimbStatus rs1 = new ReimbStatus("Accepted");
	        ReimbStatus rs2 = new ReimbStatus("Pending");
	        ReimbStatus rs3 = new ReimbStatus("Denied");
	        
			User u1 = new User("emp1", "emp1", "Phoenix", "Wright", "phoenixwright@aceattorney.com", ur1);
			User u2 = new User("emp2", "emp2", "Maya", "Fey", "mayafey@aceattorney.com", ur1);
			User u3 = new User("emp3", "emp3", "Dick", "Gumshoe", "dickgumshoe@aceattorney.com", ur1);
			User u4 = new User("emp4", "emp4", "Mia", "Fey", "miafey@aceattorney.com", ur2);
			User u5 = new User("emp5", "emp5", "Miles", "Edgeworth", "milesedgeworth@aceattorney.com", ur2);
			User u6 = new User("emp6", "emp6", "Bobby", "Fulbright", "bobbyfulbright@aceattorney.com", ur2);
							
			Calendar calendar = Calendar.getInstance();
			Timestamp current = new Timestamp(calendar.getTime().getTime());
			  
			Reimb r1 = new Reimb(250.00, current, current, "This is a description", u1, u5,rs1, rt1);
			Reimb r2 = new Reimb(50.00, current, current, "This is a description2", u1, u6, rs1, rt2);
			Reimb r3 = new Reimb(60.00, current, null, "This is a description3", u1, u5, rs2, rt3);
			Reimb r4 = new Reimb(66.00, current, current, "This is a description4", u3, u4, rs3, rt3);
			Reimb r5 = new Reimb(22.00, current, null, "This is a description5", u2, u4, rs2,rt3);
			Reimb r6 = new Reimb(221.00, current, null, "This is a description5", u2, u4, rs2,rt3); 

//			urs.insert(ur1);
//			urs.insert(ur2);
//
//			us.insert(u1);
//			us.insert(u2);
//			us.insert(u3);
//			us.insert(u4);
//			us.insert(u5);
//			us.insert(u6);
//
//			rs.insert(rs1);
//			rs.insert(rs2);
//			rs.insert(rs3);
//
//			rt.insert(rt1);
//			rt.insert(rt2);
//			rt.insert(rt3);
//			rt.insert(rt4);
//
//			re.insert(r1);
//			re.insert(r2);
//			re.insert(r3);
//			re.insert(r4);
//			re.insert(r5);
//			re.insert(r6);
			
//			User u7 = new User(1,"emp1", "emp1", "Bobby", "Fulbright", "bobbyfulbright@ace.com", ur2);
//			us.update(u7);
			
//			Reimb r7 = new Reimb(1, 21.00, current, null, "This is a description7", u2, u4, rs2,rt3); 
//			re.update(r7);
			
			List<UserRole> roles = urs.selectAll(); for(UserRole r: roles)System.out.println(r);
			//System.out.println(urs.selectbyId(1));
			System.out.println("----------------------");
			
			List<User> users = us.selectAll();for(User u: users)System.out.println(u);
			//System.out.println(us.selectbyId(2));
			System.out.println("----------------------");
			
			List<ReimbStatus> status = rs.selectAll();for(ReimbStatus s: status)System.out.println(s);
			//System.out.println(rs.selectbyId(2));
			System.out.println("----------------------");
			
			List<ReimbType> type = rt.selectAll();for(ReimbType t: type)System.out.println(t);
			//System.out.println(rt.selectbyId(3));
			System.out.println("----------------------");
			
			List<Reimb> reimb = re.selectAll(); for(Reimb r: reimb) {System.out.println(r);}
			//System.out.println(re.selectbyId(2));
			System.out.println("----------------------");
			

		}
		

}
