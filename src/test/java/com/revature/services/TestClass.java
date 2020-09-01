package com.revature.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.Timestamp;
import java.util.Calendar;

import org.junit.Test;

import com.revature.models.Reimb;
import com.revature.models.ReimbStatus;
import com.revature.models.ReimbType;
import com.revature.models.User;
import com.revature.models.UserRole;
import com.revaure.services.UserRoleService;
import com.revaure.services.UserService;


public class TestClass {
	UserService us = new UserService();
	UserRoleService urs = new UserRoleService();
	
	
	@Test
	public void insert() {
		UserRole ur1 = new UserRole("Employee");
		assertTrue(urs.insert(ur1));
		ReimbType rt1 = new ReimbType("Lodging");
		//assertTrue();
		User u = new User();
		u.setUsername("emp10");
		u.setPassword("emp10");
		u.setFirstName("Wendy");
		u.setLastName("OldBag");
		u.setEmail("wendyoldbag@aceattorney.com");
		
		assertTrue(us.insert(u, 1));
		
		

		
		ReimbStatus rs1 = new ReimbStatus("Accepted");
		Calendar calendar = Calendar.getInstance();
		Timestamp current = new Timestamp(calendar.getTime().getTime());
	}
	
	@Test
	public void update() {
		
	}
}
