package com.revature.services;

import java.util.List;

import com.revature.dao.IUserRoleDAO;
import com.revature.dao.UserRoleDAO;
import com.revature.model.UserRole;

public class UserRoleService {
	IUserRoleDAO urDao = new UserRoleDAO();
	
	public List<UserRole> getAll(){
		return urDao.getAll();
	}
	
	public boolean add(UserRole ur) {
		return urDao.add(ur);
	}
	
	public UserRole getID(int id) {
		return urDao.getID(id);
	}
}
