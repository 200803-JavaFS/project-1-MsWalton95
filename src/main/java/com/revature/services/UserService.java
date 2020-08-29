package com.revature.services;

import java.util.List;

import com.revature.dao.IUserDAO;
import com.revature.dao.UserDAO;
import com.revature.model.User;

public class UserService {
	IUserDAO uDao = new UserDAO();
	
	public List<User> getAll(){
		return uDao.getAll();
	}
	
	public User getUserByID(int id) {
		return uDao.getUserByID(id);
	}
	
	public boolean login(User u) {
		return uDao.login(u);
	}
	
	public boolean addUser(User u) {
		return uDao.addUser(u);
	}
	
	public boolean updateUser(User u) {
		return uDao.updateUser(u);
	}
	
	public boolean deleteUser(int id) {
		return uDao.deleteUser(id);
	}
}
