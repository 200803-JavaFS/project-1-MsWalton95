package com.revature.daos;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.models.User;
import com.revature.models.UserRole;
import com.revature.util.HibernateUtil;

public class UserDAO implements IUserDAO{

	public UserDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean insert(User u, int id) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx = ses.beginTransaction();
			
			UserRole ur = ses.get(UserRole.class, id);
			u.setUser(ur);
			
			ses.save(u);
			tx.commit();
			
			return true;
			
		}catch(HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean update(User u, int id) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx = ses.beginTransaction();
	
			UserRole ur = ses.get(UserRole.class, id);
			u.setUser(ur);
			
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
			String hql = "FROM User";
		
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
			String hql = "FROM User WHERE firstName=:f AND lastName=:l";
			
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
			String hql = "FROM User WHERE user.roleID=:r";
			
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

	public boolean userLogin(User u) {	
		Session ses = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx = ses.beginTransaction();
			String hql = "FROM User WHERE username=:u AND password=:p";
			
			@SuppressWarnings("unchecked")
			Query<User> query = ses.createQuery(hql);
			query.setParameter("u", u.getUsername());
			query.setParameter("p",u.getPassword());
			List<User> results = query.list();
	
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
