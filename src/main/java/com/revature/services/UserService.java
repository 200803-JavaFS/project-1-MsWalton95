
package com.revature.services;

import java.util.List;

import com.revature.daoimpl.IUserDAO;
import com.revature.daos.UserDAO;
import com.revature.models.Users;

public class UserService {
	
	public static IUserDAO uDao = new UserDAO(); 

	public boolean insert(Users u) {
		return uDao.insert(u);
	}
	
	public boolean update(Users u) {
		return uDao.update(u);
	}
	
	public Users selectbyId(int id) {
		return uDao.selectbyId(id);
	}
	
	public List<Users> selectAll(){
		return uDao.selectAll();
	}
	
	public boolean userLogin(String username, String password){
		return uDao.userLogin(username, password);
	}
	
	public List<Users> selectByUsername(String username){
		return uDao.selectByUsername(username);
	}

}
