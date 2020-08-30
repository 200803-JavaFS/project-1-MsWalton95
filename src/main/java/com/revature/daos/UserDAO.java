package com.revature.daos;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.models.User;
import com.revature.util.HibernateUtil;

public class UserDAO implements IUserDAO{

	public UserDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean insert(User u) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx = ses.beginTransaction();
			
			ses.save(u);
			tx.commit();
			
			return true;
			
		}catch(HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean update(User u) {
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
	
	public User selectbyId(int id) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx = ses.beginTransaction();
			
			User u = ses.get(User.class, id);
			
			if(u ==  null) {
				System.out.println(" There are no users by that id: " + id);
				return null;
			}else{
				tx.commit();
				return u;
			}
			
		}catch(HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	public List<User> selectAll(){
		Session ses = HibernateUtil.getSession();
		Transaction tx = null;
		try {
			tx = ses.beginTransaction();
			String hql = "FROM com.revature.models.User";
		
			@SuppressWarnings("unchecked")
			Query<User> query = ses.createQuery(hql);
			List<User> results = query.list();
			
			if(results.isEmpty()) {
				System.out.println("There are no users");
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
	
	public List<User> selectByName(String fname,String lname){
		Session ses = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx = ses.beginTransaction();
			String hql = "FROM com.revature.models.User WHERE firstName=:f AND lastName=:l";
			
			@SuppressWarnings("unchecked")
			Query<User> query = ses.createQuery(hql);
			query.setParameter("f",fname);
			query.setParameter("l",lname);
			List<User> results = query.list();
			
			if(results.isEmpty()) {
				System.out.println(fname + " " + lname + " is not in this file");
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
	
	public List<User> selectByRole(int id){
		Session ses = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx = ses.beginTransaction();
			String hql = "FROM com.revature.models.User WHERE user.roleID=:r";
			
			@SuppressWarnings("unchecked")
			Query<User> query = ses.createQuery(hql);
			query.setParameter("r",id);
			List<User> results = query.list();
			
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

	public List<User> userLogin(String username,String password) {	
		Session ses = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx = ses.beginTransaction();
			String hql = "FROM com.revature.models.User WHERE username=:u AND password=:p";
			
			@SuppressWarnings("unchecked")
			Query<User> query = ses.createQuery(hql);
			query.setParameter("u", username);
			query.setParameter("p",password);
			List<User> results = query.list();
	
			if(results.isEmpty()) {
				System.out.println("Username or password incorrect");
				return null;
			}else {
				tx.commit();System.out.println(results);
				return results;
				
			}
		}catch(HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		}
		
		return null;
	}
	
}
