package com.revature.daos;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.models.User;
import com.revature.models.UserRole;
import com.revature.util.HibernateUtil;

public class UserRoleDAO implements IUserRoleDAO{
		public UserRoleDAO() {
		// TODO Auto-generated constructor stub
	}

	public boolean insert(UserRole ur) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx = ses.beginTransaction();
			
			ses.save(ur);
			tx.commit();
			
			return true;
			
		}catch(HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean update(UserRole ur) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx = ses.beginTransaction();
	
			ses.merge(ur);		
			tx.commit();
			
			return true;
			
		}catch(HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		}
		
		return false;
	}
	
	public UserRole selectbyId(int id) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx = ses.beginTransaction();
			
			UserRole ur = ses.get(UserRole.class, id);
			
			if(ur == null) {
				System.out.println(" There are no reimbursement type by that id");
				return null;
			}else{
				tx.commit();
				return ur;
			}
			
		}catch(HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		}
		
		return null;
	}
	
	public List<UserRole> selectAll(){
		Session ses = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx = ses.beginTransaction();
			String hql = "FROM com.revature.models.UserRole";
		
			@SuppressWarnings("unchecked")
			Query<UserRole> query = ses.createQuery(hql);
			List<UserRole> results = query.list();
			
			if(results.isEmpty()) {
				System.out.println(" There are no user roles");
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
}
