package com.revature.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.model.User;
import com.revature.util.ConnectionUtil;

public class UserDAO implements IUserDAO{

	@Override
	public List<User> getAll() {
		Session ses = ConnectionUtil.getSession();
		
		List<User> users = ses.createQuery("FROM ers_users").list();
		
		return users;
	}
	
	@Override
	public User getUserByID(int id) {
		Session ses = ConnectionUtil.getSession();
		
		User u = ses.get(User.class, id);
		
		if(u != null) {
			return u;
		}else {
			return null;
		}
	}

	@Override
	public boolean login(User u) {
		Session ses = ConnectionUtil.getSession();
		Query q = ses.createQuery("FROM ers_users WHERE user_name=:user AND pass_word=:pwd");
		q.setParameter("user", u.getErsPassword());  
		q.setParameter("pwd", u.getErsPassword());  
		q.executeUpdate();
		
		return true;
	}

	@Override
	public boolean addUser(User u) {
		Session ses = ConnectionUtil.getSession();
		Transaction tx = ses.beginTransaction();
		
		try {
			ses.save(u);
			tx.commit();
			return true;
		}catch(HibernateException e) {
			tx.rollback();
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean updateUser(User u) {
		Session ses = ConnectionUtil.getSession();
		Transaction tx = ses.beginTransaction();
		
		try {
			ses.merge(u);
			tx.commit();
			return true;
		}catch(HibernateException e) {
			tx.rollback();
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteUser(int id) {
		Session ses = ConnectionUtil.getSession();
		
		try {
			Query q = ses.createQuery("DELETE FROM ers_users WHERE ers_user_id=:id");
			q.setParameter("id", id);  
			q.executeUpdate();
			return true;
		}catch(HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	
	
	//username.equals() && password.equals
}
