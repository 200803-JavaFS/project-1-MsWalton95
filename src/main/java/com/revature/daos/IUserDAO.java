package com.revature.daos;

import java.util.List;

import com.revature.models.User;
import com.revature.models.UserRole;

public interface IUserDAO {

	public boolean insert(User u, int id);
	
	public boolean update(User u, int id);
	
	public User selectbyId(int id);
	
	public List<User> selectAll();
	
	public List<User> selectByRole(int id);
	
	public List<User> selectByName(String fname,String lname);
	
	public boolean userLogin(User u);
}
