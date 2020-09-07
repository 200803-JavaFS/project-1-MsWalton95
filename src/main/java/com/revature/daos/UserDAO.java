package com.revature.daos;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.daoimpl.IUserDAO;
import com.revature.models.Users;
import com.revature.util.HibernateUtil;

public class UserDAO implements IUserDAO{
	@Override
	public boolean insert(Users u) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = null;

		try {
			tx = ses.beginTransaction();
			
			ses.save(u);
			tx.commit();
			
			return true;
		} catch (Exception e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Users u) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx = ses.beginTransaction();

			ses.merge(u);		
			tx.commit();
			
			return true;
		}catch(HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Users> selectAll() {
		Session ses = HibernateUtil.getSession();
		
		String hql = "FROM Users";
	
		@SuppressWarnings("unchecked")
		Query<Users> query = ses.createQuery(hql);
		List<Users> results = query.list();

		if(results.isEmpty()) {
			return null;
		} else {
			return results;
		}
	}

	@Override
	public Users selectbyId(int id) {
		Session ses = HibernateUtil.getSession();
		Users u = ses.get(Users.class, id);
		
		if(u != null) {
			return u;
		} else {
			return null;
		}
	}
	
	public List<Users> selectByUsername(String username) {
		Session ses = HibernateUtil.getSession();
		
		String hql = "FROM Users WHERE username=:u";
		
		@SuppressWarnings("unchecked")
		Query<Users> query = ses.createQuery(hql);
		query.setParameter("u",username);
		List<Users> results = query.list();
		
		if(results.isEmpty()) {
			return null;
		} else {
			return results;
		}
	}
	
	public boolean userLogin(String username, String password) {	
		Session ses = HibernateUtil.getSession();
		
		String hql = "FROM Users WHERE username=:u AND password=:p";

		@SuppressWarnings("unchecked")
		Query<Users> query = ses.createQuery(hql);
		
		query.setParameter("u",username);
		query.setParameter("p", password);
		
		List<Users> results = query.list();

		if(results.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}
}
