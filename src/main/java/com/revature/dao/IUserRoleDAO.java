package com.revature.dao;

import java.util.List;

import com.revature.model.UserRole;

public interface IUserRoleDAO {
	public List<UserRole> getAll();
	
	public void add(UserRole ur);
	
	public UserRole getID(int id); 
}
