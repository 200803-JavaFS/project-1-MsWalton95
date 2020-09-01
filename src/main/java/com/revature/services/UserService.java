
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
	
	public List<Users> selectByRole(int id){
		return uDao.selectByRole(id);
	}
	
	public List<Users> selectByName(String fName, String lName){
		return uDao.selectByName(fName, lName);
	}
	
	public boolean userLogin(String username, String password){
		return uDao.userLogin(username, password);
	}

}
