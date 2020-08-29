package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.model.UserRole;
import com.revature.util.ConnectionUtil;

public class UserRoleDAO implements IUserRoleDAO{

	@Override
	public List<UserRole> getAll() {
		Session ses = ConnectionUtil.getSession();
		
		List<UserRole> ur = ses.createQuery("FROM ers_user_roles").list();
		
		return ur;
	}

	@Override
	public UserRole getID(int id) {
		
		Session ses = ConnectionUtil.getSession();
		
		UserRole ur = ses.get(UserRole.class, id);
		
		return ur;
	}

	@Override
	public boolean add(UserRole ur) {
		Session ses = ConnectionUtil.getSession();
		
		Transaction tx = ses.beginTransaction();
		
		ses.save(ur);
		
		tx.commit();
		
		return true;
		
	}

}
