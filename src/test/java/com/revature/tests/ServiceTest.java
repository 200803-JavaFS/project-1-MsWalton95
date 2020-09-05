package com.revature.tests;

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
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import java.sql.Timestamp;
import java.util.Calendar;
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
		
		assertNotNull(user.selectByName("Maya", "Fey"));
		assertNull(user.selectByName("Pearl", "Fey"));
		
		assertNotNull(user.selectByUsername("emp4"));
		assertNull(user.selectByUsername("emp44"));		
	}
	
	@Test
	public void update() {
		UserRole ur1 = role.selectbyId(1);
		Users u = user.selectbyId(2);
		Users u2 = new Users(1, "emp1", "emp1", "Phoenix", "Wright", "phoenixwright@aceattorney.com", ur1);
		assertNotSame(u2, user.update(u));
		
		Calendar calendar = Calendar.getInstance();
		Timestamp current = new Timestamp(calendar.getTime().getTime());
		Timestamp current2 = new Timestamp(calendar.getTime().getTime()+100);
		
		Users u3 = user.selectbyId(5);
		ReimbStatus rs1 = status.selectbyId(1);
		ReimbType rt1 = type.selectbyId(3); 
		Reimb r = reimb.selectbyId(1);
		Reimb r2 = new Reimb(1, 72.25, current, current2, "Wright Office", rs1, rt1, u, u3);
		assertNotSame(r2, reimb.update(r));
	}

	
	
}
