package com.revature.tests;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Reimb;
import com.revature.models.ReimbStatus;
import com.revature.models.ReimbType;
import com.revature.models.UserRole;
import com.revature.models.Users;
import com.revature.services.ReimbService;
import com.revature.services.ReimbStatusService;
import com.revature.services.ReimbTypeService;
import com.revature.services.UserRoleService;
import com.revature.services.UserService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import org.junit.Test;

public class ServiceTest {
	ReimbStatusService status = new ReimbStatusService();
	ReimbTypeService type = new ReimbTypeService();
	ReimbService reimb = new ReimbService();
	
	UserRoleService role = new UserRoleService();
	UserService user = new UserService();
	
    @Test
    public void insert1() {
    	UserRole ur1 = new UserRole("Employee");
    	UserRole ur2 = new UserRole("Financial Manager");
    	
        ReimbType rt1 = new ReimbType("Lodging");
        ReimbType rt2 = new ReimbType("Food");
        ReimbType rt3 = new ReimbType("Travel");
        ReimbType rt4 = new ReimbType("Other");
        
        ReimbStatus rs1 = new ReimbStatus("Accepted");
        ReimbStatus rs2 = new ReimbStatus("Pending");
        ReimbStatus rs3 = new ReimbStatus("Denied");
        
        role.insert(ur1); role.insert(ur2);
        type.insert(rt1);type.insert(rt2);type.insert(rt3);type.insert(rt4);
        status.insert(rs1);status.insert(rs2);status.insert(rs3);	
    }
	
	@Test
	public void insert2() {
		UserRole role1 = role.selectbyId(1);
		UserRole role2 = role.selectbyId(2);

		Users u1 = new Users("emp1", "emp1", "Phoenix", "Wright", "phoenixwright@aceattorney.com",role1);
		Users u2 = new Users("emp2", "emp2", "Maya", "Fey", "mayafey@aceattorney.com", role1);
		Users u3 = new Users("emp3", "emp3", "Dick", "Gumshoe", "dickgumshoe@aceattorney.com", role1);
		Users u4 = new Users("emp4", "emp4", "Mia", "Fey", "miafey@aceattorney.com", role2);
		Users u5 = new Users("emp5", "emp5", "Miles", "Edgeworth", "milesedgeworth@aceattorney.com", role2);
		Users u6 = new Users("emp6", "emp6", "Bobby", "Fulbright", "bobbyfulbright@aceattorney.com", role2);
	
		user.insert(u1);user.insert(u2); user.insert(u3);
		user.insert(u4);user.insert(u5); user.insert(u6);
	}
	
	public void insert3() {
		ReimbStatus status1 = status.selectbyId(1);
		ReimbStatus status2 = status.selectbyId(2);
		ReimbStatus status3 = status.selectbyId(3);
		
		ReimbType type1 = type.selectbyId(1);
		ReimbType type2 = type.selectbyId(2);
		ReimbType type3 = type.selectbyId(3);
		ReimbType type4 = type.selectbyId(4);
		
		Users author1 = user.selectbyId(1);
		Users author2 = user.selectbyId(2);
		Users author3 = user.selectbyId(3);
		Users resolver1 = user.selectbyId(4);
		Users resolver2 = user.selectbyId(5);
		Users resolver3 = user.selectbyId(6);
		
		Calendar calendar = Calendar.getInstance();
		Timestamp current = new Timestamp(calendar.getTime().getTime());
		
		Reimb r1 = new Reimb(85.00, current, "Jojo's Bizarre Adventure", status2, type1, author1);
		Reimb r2 = new Reimb(50.00, current, "This is a description2", status2, type1, author1);
		Reimb r3 = new Reimb(60.00, current, "This is a description3", status3, type4, author3);
		Reimb r4 = new Reimb(66.00, current, "This is a description4", status2, type3, author2);
		Reimb r5 = new Reimb(22.00, current, "This is a description5", status1, type1, author1);
		
		reimb.insert(r1);reimb.insert(r2);reimb.insert(r3);reimb.insert(r4);reimb.insert(r5);
	}
	
	@Test
	public void json() throws Exception{
	List<UserRole> roles = role.selectAll();
	for(UserRole ur : roles) {ObjectMapper om = new ObjectMapper();
	System.out.println(om.writeValueAsString(ur));}		

	List<ReimbType> types = type.selectAll();
	for(ReimbType rt : types) {ObjectMapper om = new ObjectMapper();
	System.out.println(om.writeValueAsString(rt));}		

	List<ReimbStatus> statuses = status.selectAll();
	for(ReimbStatus rs : statuses) {ObjectMapper om = new ObjectMapper();
	System.out.println(om.writeValueAsString(rs));}

	
	List<Users> users = user.selectAll();
	for(Users u : users) {ObjectMapper om = new ObjectMapper();
	System.out.println(om.writeValueAsString(u));}
	
	List<Reimb> reimbs = reimb.selectAll();
	for(Reimb r : reimbs) {ObjectMapper om = new ObjectMapper();
	System.out.println(om.writeValueAsString(r));}
	

	}
	
	  
	@Test
	public void select() {
		List<Users> us1 = user.selectByName("Maya","Fey");
	}

	
	@Test
	public void login() {
		boolean us2 = user.userLogin("emp5", "emp5");
		assertTrue(us2);
		
		boolean us1 = user.userLogin("emp55", "emp5");
		assertFalse(us1);
	}
}
