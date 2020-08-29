package com.revature;

import java.util.List;

import com.revature.daos.*;
import com.revature.models.*;

public class Driver {

	
	public static DirectorDAO dirDao = new DirectorDAO();
	public static MovieDAO movDao = new MovieDAO();
	public static void main(String[] args) {
		insertValues();
		
		List<User> movies = movDao.selectAll();
		
		for(User m : movies) {System.out.println(m);}
	}
	
	
	
		public static void insertValues() {
			UserRole dir1 = new UserRole("Christopher","Nolan", null);
			UserRole dir2 = new UserRole("Stephen","Speilburg", null);
			
			dirDao.insert(dir1);
			dirDao.insert(dir2);
			
			User m1 = new User("Jurassic Park","Don't feed the lizards", dir2);
			User m2 = new User("Dark knight","DC Sucks",dir1);
			User m3 = new User("ET","Always be nice to strangers", dir2);
			
			movDao.insert(m1);
			movDao.insert(m2);
			movDao.insert(m3);
			
		}
	

}
