package com.revature;

import java.sql.Timestamp;
import java.util.List;

import com.revature.dao.IUserRoleDAO;
import com.revature.dao.ReimbDAO;
import com.revature.dao.ReimbStatusDAO;
import com.revature.dao.ReimbTypeDAO;
import com.revature.dao.UserDAO;
import com.revature.dao.UserRoleDAO;
import com.revature.model.Reimbursement;
import com.revature.model.ReimbursementStatus;
import com.revature.model.ReimbursementType;
import com.revature.model.User;
import com.revature.model.UserRole;

public class Driver {
	public static ReimbStatusDAO rsDao = new ReimbStatusDAO();
	public static ReimbTypeDAO rtDao = new ReimbTypeDAO();
	public static ReimbDAO rDao = new ReimbDAO();
	
	public static IUserRoleDAO urDao = new UserRoleDAO();
	public static UserDAO uDao = new UserDAO();
	
	public static void main(String[] args) {
		
		
		insertValues();
		
		List<UserRole> users = urDao.getAll();
		for(UserRole ur : users) {System.out.println(ur);}

	}
	
	public static void insertValues() {
		UserRole ur1 = new UserRole("employee"); 
		UserRole ur2 = new UserRole("financial manager"); 
		urDao.add(ur1);
		urDao.add(ur2);
		
		//Username, Password, FirstName, LastName, Email, userRoleID
//		User u1 = new User("employee1", "employee1","Phoenix","Wright","phoenixwright@aceattorney.com", ur1);
//		User u2 = new User("employee2", "employee2","Maya","Fey","mayafey@aceattorney.com", ur1);
//		User u3 = new User("employee3", "employee3","Dick","Gumshoe","detectivegumshoe@aceattorney.com", ur1);
//		User u4 = new User("employee4", "employee4","Franzsika","Von Karma","franzsikakarma@aceattorney.com", ur2);
//		User u5 = new User("employee5", "employee5","Miles","EdgeWorth","milesedgeworth@aceattorney.com", ur2);
//		uDao.addUser(u1);
//		uDao.addUser(u2);
//		uDao.addUser(u3);
//		uDao.addUser(u4);
//		uDao.addUser(u5);
//		
//		ReimbursementStatus res1 = new ReimbursementStatus("Approved");
//		ReimbursementStatus res2 = new ReimbursementStatus("Pending");
//		ReimbursementStatus res3 = new ReimbursementStatus("Denied");
//		rsDao.add(res1);
//		rsDao.add(res2);
//		rsDao.add(res3);
//		
//		ReimbursementType ret1 = new ReimbursementType("Food");
//		ReimbursementType ret2 = new ReimbursementType("Travel");
//		ReimbursementType ret3 = new ReimbursementType("Lodging");
//		ReimbursementType ret4 = new ReimbursementType("Other");
//		rtDao.add(ret1);
//		rtDao.add(ret2);
//		rtDao.add(ret3);
//		rtDao.add(ret4);
//		//Amount, Submitted, Resolved, Description,Author,Resolver,Status,Type
//		Reimbursement re1 = new Reimbursement(250.00, null, null, "client lunch", u1, u4,  res1, ret1);
//		Reimbursement re2 = new Reimbursement(10.00, null, null, "snacks", u1, u5,  res1, ret1);
//		rDao.addReimburse(re1);
//		rDao.addReimburse(re2);
		
	}

}
