package com.revature.daos;

import java.util.List;

import com.revature.models.UserRole;

public interface IUserRoleDAO {
	
	public boolean insert(UserRole ur);
	
	public boolean update(UserRole ur);
	
	public UserRole selectbyId(int id);
	
	public List<UserRole> selectAll();
}
