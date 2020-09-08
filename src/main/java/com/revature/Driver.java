package com.revature;

import java.sql.Timestamp;
import java.util.Calendar;

import com.revature.models.*;
import com.revature.services.*;

public class Driver {
	
	public static void main(String[] args) throws Exception {

		ReimbStatusService status = new ReimbStatusService();
		ReimbTypeService type = new ReimbTypeService();
		ReimbService reimb = new ReimbService();
		
		UserRoleService role = new UserRoleService();
		UserService user = new UserService();

//		List<Users> users = user.selectAll();
//		for(Users u : users) {ObjectMapper om = new ObjectMapper();
//		System.out.println(om.writeValueAsString(u));}
		
    	UserRole ur1 = new UserRole("Employee");
    	UserRole ur2 = new UserRole("Financial Manager");
    	
        ReimbType rt1 = new ReimbType("Lodging");
        ReimbType rt2 = new ReimbType("Food");
        ReimbType rt3 = new ReimbType("Travel");
        ReimbType rt4 = new ReimbType("Other");
        
        ReimbStatus rs1 = new ReimbStatus("Accepted");
        ReimbStatus rs2 = new ReimbStatus("Pending");
        ReimbStatus rs3 = new ReimbStatus("Denied");
        
//        role.insert(ur1); role.insert(ur2);
//        type.insert(rt1);type.insert(rt2);type.insert(rt3);type.insert(rt4);
//        status.insert(rs1);status.insert(rs2);status.insert(rs3);	

		UserRole role1 = role.selectbyId(1);
		UserRole role2 = role.selectbyId(2);

		Users u1 = new Users("emp1", "emp1", "Phoenix", "Wright", "phoenixwright@aceattorney.com",role1);
		Users u2 = new Users("emp2", "emp2", "Maya", "Fey", "mayafey@aceattorney.com", role1);
		Users u3 = new Users("emp3", "emp3", "Mia", "Fey", "miafey@aceattorney.com", role2);
		Users u4 = new Users("emp4", "emp4", "Miles", "Edgeworth", "milesedgeworth@aceattorney.com", role2);
		Users u5 = new Users("emp5", "emp5", "Bobby", "Fulbright", "bobbyfulbright@aceattorney.com", role2);
	
//		user.insert(u1);user.insert(u2); user.insert(u3);user.insert(u4);user.insert(u5);

		ReimbStatus status1 = status.selectbyId(1);
		ReimbStatus status2 = status.selectbyId(2);
		ReimbStatus status3 = status.selectbyId(3);
		
		ReimbType type1 = type.selectbyId(1);
		ReimbType type2 = type.selectbyId(2);
		ReimbType type3 = type.selectbyId(3);
		ReimbType type4 = type.selectbyId(4);
		
		Users author1 = user.selectbyId(1);
		Users author2 = user.selectbyId(2);
		Users resolver1 = user.selectbyId(3);
		Users resolver2 = user.selectbyId(4);
		Users resolver3 = user.selectbyId(5);
		
		Calendar calendar = Calendar.getInstance();
		Timestamp current = new Timestamp(calendar.getTime().getTime());
		Timestamp current2 = new Timestamp(calendar.getTime().getTime());

		//re, user, type
		//amount, submitted, description, status //insert
		//amount, submitted, resolved, description, status, resolver
		//amount, submitted, resolved, description, status, type, author, resolver //update
		Reimb r1 = new Reimb(85.00, current, "Business Conference", status2);//Pending 2 Lodging 1
		Reimb r2 = new Reimb(28.00, current, "Group Lunch", status1);//Pending 2  Food 2
		Reimb r3 = new Reimb(120.00, current, current2, "Hamburgers", status3, resolver1);//Denied 3 Food 2
		Reimb r4 = new Reimb(56.75, current, current2, "Medical billing", status1, resolver3);//Accepted 1 Other 4
		Reimb r5 = new Reimb(160.00, current, current2, "Attorney Pin", status3, resolver2);// Denied 1 Other 4
		Reimb r6 = new Reimb(52.00, current, "Studio One", status2); //Pending 2 Travel 3
		Reimb r7 = new Reimb(125.00, current, current2, "Blue Badger supplies", status3, resolver2);//Denied 3 Other 4
		Reimb r8 = new Reimb(80.00, current, "Gatewater Hotel", status2);//Pending 2 Lodging 1
		Reimb r9 = new Reimb(98.75, current, "Detention Center", status2);//Pending 2 Travel 3
		Reimb r10 = new Reimb(58.50, current, current2, "Kurain Village", status1, resolver1);//Accepted 1 Travel 3
		
		//reimb.insert(r1, 1, 1);reimb.insert(r2, 1, 2);reimb.insert(r3, 2, 2);
//		reimb.insert(r4,1,4);reimb.insert(r5,1,4);
		reimb.insert(r6,2,3);reimb.insert(r7,2,4);reimb.insert(r8,1,1);
//		reimb.insert(r9,1,3);reimb.insert(r10,1,3);

	}

		

}
