package com.revature.daos;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.daoimpl.IUserDAO;
import com.revature.models.Users;
import com.revature.util.HibernateUtil;

public class UserDAO implements IUserDAO{
	private static final Logger log = LogManager.getLogger(UserDAO.class);

	@Override
	public List<Users> selectAll() {
		Session ses = HibernateUtil.getSession();
		Transaction tx = null;
		try {
			tx = ses.beginTransaction();
			String hql = "FROM Users";
		
			@SuppressWarnings("unchecked")
			Query<Users> query = ses.createQuery(hql);
			List<Users> results = query.list();
			
			if(results.isEmpty()) {
				tx.rollback();
				return null;
			}else{
				tx.commit();
				return results;
			}
			
		}catch(HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Users selectbyId(int id) {
		Session ses = HibernateUtil.getSession();

		Users u = ses.get(Users.class, id);
		
		if(u == null) {
			return null;
		}else{
			return u;
		}
	}

	@Override
	public boolean insert(Users u) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = null;

		try {
			tx = ses.beginTransaction();
			
			ses.save(u);
			tx.commit();
			
			log.info("User added");
			
			return true;
		} catch (Exception e) {
			if (tx!=null) tx.rollback();
			log.warn("Unable to add user");
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
			
			log.info("User updated");
			
			return true;
			
		}catch(HibernateException e) {
			if (tx!=null) tx.rollback();
			log.warn("Unable to update");
			e.printStackTrace();
		}
		
		return false;
	}

	public List<Users> selectByName(String fName, String lName){
		Session ses = HibernateUtil.getSession();
		
		try {
			String hql = "FROM Users WHERE firstName=:f AND lastName=:l";
			
			@SuppressWarnings("unchecked")
			Query<Users> query = ses.createQuery(hql);
			query.setParameter("f",fName);
			query.setParameter("l",lName);
			List<Users> results = query.list();
			
			if(results.isEmpty()) {
				return null;
			}else{
				return results;
			}
		}catch(HibernateException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public List<Users> selectByUsername(String username) {
		Session ses = HibernateUtil.getSession();
		
		try {
			String hql = "FROM Users WHERE username=:u";
			
			@SuppressWarnings("unchecked")
			Query<Users> query = ses.createQuery(hql);
			query.setParameter("u",username);
			List<Users> results = query.list();
			
			if(results.isEmpty()) {
				return null;
			}else {
				return results;
				
			}
			
		}catch(HibernateException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean userLogin(String username, String password) {	
		Session ses = HibernateUtil.getSession();
		Transaction tx = null;
		try {
			tx = ses.beginTransaction();
			String hql = "FROM Users WHERE username=:u AND password=:p";

			@SuppressWarnings("unchecked")
			Query<Users> query = ses.createQuery(hql);
			
			query.setParameter("u",username);
			query.setParameter("p", password);
			
			List<Users> results = query.list();
	
			if(results.isEmpty()) {
				tx.rollback();
				return false;
			}else {
				tx.commit();
				return true;
				
			}

		}catch(HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		}
		
		return false;
	}


}
