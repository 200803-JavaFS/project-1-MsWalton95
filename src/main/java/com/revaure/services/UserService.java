package com.revaure.services;

import java.util.List;

import com.revature.daos.IUserDAO;
import com.revature.daos.UserDAO;
import com.revature.models.User;

public class UserService {
	
	public static IUserDAO uDao = new UserDAO(); 

	public boolean insert(User u) {
		return uDao.insert(u);
	}
	
	public boolean update(User u) {
		return uDao.update(u);
	}
	
	public User selectbyId(int id) {
		return uDao.selectbyId(id);
	}
	
	public List<User> selectAll(){
		return uDao.selectAll();
	}
	
	public List<User> selectByName(String fname,String lname){
		return uDao.selectByName(fname, lname);
	}
}
