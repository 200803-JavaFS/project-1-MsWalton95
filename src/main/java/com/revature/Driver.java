package com.revature;

import java.io.FileOutputStream;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.revature.models.*;
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
	
	public static void main(String[] args) throws Exception {
		insertValues();
	}

		public static void insertValues() throws Exception { 
	        UserRole ur1 = new UserRole("Employee");
	        UserRole ur2 = new UserRole("Financial Manager");

	        ReimbType rt1 = new ReimbType("Lodging");
	        ReimbType rt2 = new ReimbType("Food");
	        ReimbType rt3 = new ReimbType("Travel");
	        ReimbType rt4 = new ReimbType("Other");
	        
	        ReimbStatus rs1 = new ReimbStatus("Accepted");
	        ReimbStatus rs2 = new ReimbStatus("Pending");
	        ReimbStatus rs3 = new ReimbStatus("Denied");
	        
	        //String username, String password, String firstName, String lastName, String email
			User u1 = new User("emp1", "emp1", "Phoenix", "Wright", "phoenixwright@aceattorney.com");
			User u2 = new User("emp2", "emp2", "Maya", "Fey", "mayafey@aceattorney.com");
			User u3 = new User("emp3", "emp3", "Dick", "Gumshoe", "dickgumshoe@aceattorney.com");
			User u4 = new User("emp4", "emp4", "Mia", "Fey", "miafey@aceattorney.com");
			User u5 = new User("emp5", "emp5", "Miles", "Edgeworth", "milesedgeworth@aceattorney.com");
			User u6 = new User("emp6", "emp6", "Bobby", "Fulbright", "bobbyfulbright@aceattorney.com");
			
			Calendar calendar = Calendar.getInstance();
			Timestamp current = new Timestamp(calendar.getTime().getTime());
			  
			//double amount, Timestamp submitted, String description
			Reimb r1 = new Reimb(85.00, current, "Jojo's Bizarre Adventure");
			Reimb r2 = new Reimb(50.00, current, "This is a description2");
			Reimb r3 = new Reimb(60.00, current, "This is a description3");
			Reimb r4 = new Reimb(66.00, current, "This is a description4");
			Reimb r5 = new Reimb(22.00, current,  "This is a description5");

//			urs.insert(ur1);
//			urs.insert(ur2);
//
//			//User u, int roleid
//			us.insert(u2, 1);
//			us.insert(u3, 1);
//			us.insert(u4, 2);
//			us.insert(u5, 2);
//			us.insert(u6, 2);
//
//			rs.insert(rs1);
//			rs.insert(rs2);
//			rs.insert(rs3);
//
//			rt.insert(rt1);
//			rt.insert(rt2);
//			rt.insert(rt3);
//			rt.insert(rt4);

			//Reimb re, int type, int status, int author
//			re.insert(r1, 1, 1, 1);
//			re.insert(r2, 4, 1, 1);
//			re.insert(r3, 2, 2, 2);
//			re.insert(r4, 3, 3, 3);
//			re.insert(r5, 1, 2, 2);
//			re.insert(r6, 1, 2, 1);
			
			
			//int userID, String username, String password, String firstName, String lastName, String email
//			User u13 = new User(3, "emp3", "emp3", "Dick", "Gumshoe", "detectivegumshoe@aceattorney.com");
//			
			//User u, int id
//			us.update(u13, 1);
			
			//int reimbID, double amount, Timestamp submitted, Timestamp resolved, String description
//			Reimb r11 = new Reimb(1, 85.00, current, current, "Jojo's Bizarre Adventure");
//			
//			//Reimb re, int type, int status, int author, int resolver
//			re.update(r11, 1, 1, 1, 4);
			
			ObjectMapper om = new ObjectMapper();
			
			
			 
			String postJson = om.writeValueAsString(u1);
		    System.out.println(postJson);
		    
		    String postJson2 = om.writeValueAsString(ur1);
		    System.out.println(postJson2);
		    
		    String postJson3 = om.writeValueAsString(rt1);
		    System.out.println(postJson3);
		    
		    String postJson4 = om.writeValueAsString(rs1);
		    System.out.println(postJson4);
		    
		    String postJson5 = om.writeValueAsString(r1);
		    System.out.println(postJson5);

			
			//List<UserRole> roles = urs.selectAll(); for(UserRole r: roles)System.out.println(r);
			//System.out.println(urs.selectbyId(1));
			System.out.println("----------------------");
			
			//List<User> users = us.selectAll();for(User r: users)System.out.println(r);
			//System.out.println(us.selectbyId(2));
			System.out.println("----------------------");
			
			//List<ReimbStatus> status = rs.selectAll();for(ReimbStatus s: status)System.out.println(s);
//			System.out.println(rs.selectbyId(2));
			System.out.println("----------------------");
			
			//List<ReimbType> type = rt.selectAll();for(ReimbType t: type)System.out.println(t);
			//System.out.println(rt.selectbyId(3));
			System.out.println("----------------------");
			
			//List<Reimb> reimb = re.selectAll(); for(Reimb r: reimb) {System.out.println(r);}
			//System.out.println(re.selectbyId(2));
			System.out.println("----------------------");
			

		}
		

}
