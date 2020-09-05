package com.revature.daoimpl;

import java.util.List;

import com.revature.models.Users;

public interface IUserDAO {

	public boolean insert(Users u);//add int id
	
	public boolean update(Users u);//add int add
	
	public Users selectbyId(int id);
	
	public List<Users> selectAll();
	
	public List<Users> selectByName(String fName, String lName);
	
	public List<Users> selectByUsername(String username);
	
	public boolean userLogin(String username, String password);
	
}
