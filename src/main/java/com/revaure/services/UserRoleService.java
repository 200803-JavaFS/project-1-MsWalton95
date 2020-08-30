package com.revaure.services;

import java.util.List;

import com.revature.daos.IUserRoleDAO;
import com.revature.daos.UserRoleDAO;
import com.revature.models.UserRole;

public class UserRoleService {

	private static IUserRoleDAO urDao = new UserRoleDAO();
	
	public boolean insert(UserRole ur) {
		return urDao.insert(ur);
	}
	
	public UserRole selectbyId(int id) {
		return urDao.selectbyId(id);
	}
	
	public List<UserRole> selectAll(){
		return urDao.selectAll();
	}
}
