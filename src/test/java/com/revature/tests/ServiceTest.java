package com.revature.tests;

import com.revature.models.Reimb;
import com.revature.models.UserRole;
import com.revature.models.Users;
import com.revature.services.ReimbService;
import com.revature.services.ReimbStatusService;
import com.revature.services.ReimbTypeService;
import com.revature.services.UserRoleService;
import com.revature.services.UserService;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.util.List;

import org.junit.Test;

public class ServiceTest {
	ReimbStatusService status = new ReimbStatusService();
	ReimbTypeService type = new ReimbTypeService();
	ReimbService reimb = new ReimbService();
	
	UserRoleService role = new UserRoleService();
	UserService user = new UserService();
	
	@Test
	public void login() {
		boolean u2 = user.userLogin("emp5", "emp5");
		assertTrue(u2);
		
		boolean u1 = user.userLogin("emp55", "emp5");
		assertFalse(u1);
		
		List<Users> u3 = user.selectByUsername("emp5");
		assertNotNull(u3);
		
		List<Users> u4 = user.selectByUsername("emp55");
		assertNull(u4);
	}
	
	@Test
	public void selectAll() {
		assertNotNull(user.selectAll());
		assertNotNull(role.selectAll());
		assertNotNull(type.selectAll());
		assertNotNull(status.selectAll());
		assertNotNull(reimb.selectAll());
	}
	  
	@Test
	public void selectID() {
		assertNotNull(user.selectbyId(1));
		assertNull(user.selectbyId(10));
		
		assertNotNull(role.selectbyId(1));
		assertNull(role.selectbyId(5));
		
		assertNotNull(type.selectbyId(1));
		assertNull(type.selectbyId(5));
		
		assertNotNull(status.selectbyId(1));
		assertNull(status.selectbyId(5));
		
		assertNotNull(reimb.selectbyId(1));
		assertNull(reimb.selectbyId(100));
	}
	
	@Test
	public void selectUser() {
		assertNotNull(reimb.selectByUser(1));
		assertNull(reimb.selectByUser(12));
	}
	
	@Test
	public void update() {
		UserRole ur1 = role.selectbyId(1);
		Users u = user.selectbyId(1);
		Users u2 = new Users(1, "emp1", "emp1", "Phoenix", "Wright", "phoenixwright@aceattorney.com", ur1);
		assertNotSame(u2, user.update(u));
		
		//reimbID, amount, submitted, resolved, description, status, type, author, resolver
		Reimb r = reimb.selectbyId(1);
		Reimb r2 = reimb.selectbyId(1);
		assertNotSame(r2, reimb.update(r, 2, 3));//id, user, status
		
		Reimb r3 = reimb.selectbyId(1);
		assertNotSame(r, reimb.update(r3, 2, 3));
		
	}

	
	
}
