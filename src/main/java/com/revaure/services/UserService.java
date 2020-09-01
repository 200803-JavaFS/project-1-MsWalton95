package com.revaure.services;

import java.util.List;

import com.revature.daos.IUserDAO;
import com.revature.daos.UserDAO;
import com.revature.models.User;

public class UserService {
	
	public static IUserDAO uDao = new UserDAO(); 

	public boolean insert(User u, int id) {
		return uDao.insert(u, id);
	}
	
	public boolean update(User u, int id) {
		return uDao.update(u, id);
	}
	
	public User selectbyId(int id) {
		return uDao.selectbyId(id);
	}
	
	public List<User> selectAll(){
		return uDao.selectAll();
	}
	
	public List<User> selectByRole(int id){
		return uDao.selectByRole(id);
	}
	
	public List<User> selectByName(String fname,String lname){
		return uDao.selectByName(fname, lname);
	}
	
	public boolean userLogin(User u){
		return uDao.userLogin(u);
	}
}
