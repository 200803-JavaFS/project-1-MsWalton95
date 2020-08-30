package com.revature.daos;

import java.util.List;

import com.revature.models.User;

public interface IUserDAO {

	public boolean insert(User u);
	
	public boolean update(User u);
	
	public User selectbyId(int id);
	
	public List<User> selectAll();
	
	public List<User> selectByRole(int id);
	
	public List<User> selectByName(String fname,String lname);
	
	public List<User> userLogin(String username,String password);
}
