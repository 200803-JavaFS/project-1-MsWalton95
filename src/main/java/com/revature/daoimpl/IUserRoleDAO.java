package com.revature.daoimpl;

import java.util.List;

import com.revature.models.UserRole;

public interface IUserRoleDAO {
	
	public boolean insert(UserRole ur);
	
	public UserRole selectbyId(int id);
	
	public List<UserRole> selectAll();
}
