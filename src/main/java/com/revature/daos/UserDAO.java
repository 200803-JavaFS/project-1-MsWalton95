package com.revature.daos;

import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.daoimpl.IUserDAO;
import com.revature.models.ReimbStatus;
import com.revature.models.Users;
import com.revature.models.UserRole;
import com.revature.util.HibernateUtil;

public class UserDAO implements IUserDAO{

	@Override
	public List<Users> selectAll() {
		Session ses = HibernateUtil.getSession();

		List<Users> list = ses.createQuery("FROM Users").list();

		if(list.isEmpty()) {
			return null;
		}else {
		return list;
		}
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

	public List<Users> selectByName(String fName, String lName){
		Session ses = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx = ses.beginTransaction();
			String hql = "FROM Users WHERE firstName=:f AND lastName=:l";
			
			@SuppressWarnings("unchecked")
			Query<Users> query = ses.createQuery(hql);
			query.setParameter("f",fName);
			query.setParameter("l",lName);
			List<Users> results = query.list();
			
			if(results.isEmpty()) {
				System.out.println(fName + " " + lName + " is not in this file");
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
	
	public List<Users> selectByRole(int id){
		Session ses = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx = ses.beginTransaction();
			String hql = "FROM Users WHERE user.roleID=:r";
			
			@SuppressWarnings("unchecked")
			Query<Users> query = ses.createQuery(hql);
			query.setParameter("r",id);
			List<Users> results = query.list();
			
			if(results.isEmpty()) {
				System.out.println( "There is no employees under this role id: " + id);
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
	
	public boolean userLogin(String username, String password) {	
		Session ses = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx = ses.beginTransaction();
			String hql = "FROM Users WHERE username=:u AND password=:p";

			@SuppressWarnings("unchecked")
			Query<Users> query = ses.createQuery(hql);
			
			query.setParameter("u", username);
			query.setParameter("p", password);
			
			List<Users> results = query.list();
	
			if(results.isEmpty()) {
				System.out.println("Username or password incorrect");
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
