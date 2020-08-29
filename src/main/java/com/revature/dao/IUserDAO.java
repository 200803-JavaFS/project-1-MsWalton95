package com.revature.dao;

import java.util.List;

import com.revature.model.User;

public interface IUserDAO {

	public List<User> getAll();
	
	public User getUserByID(int id);
	
	public boolean login(User u);
	
	public boolean addUser(User u);
	
	public boolean updateUser(User u);
	
	public boolean deleteUser(int id);
}
