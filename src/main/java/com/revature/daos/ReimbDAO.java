package com.revature.daos;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.daoimpl.IReimbDAO;
import com.revature.models.Reimb;
import com.revature.models.ReimbStatus;
import com.revature.models.ReimbType;
import com.revature.models.Users;
import com.revature.models.UserRole;
import com.revature.util.HibernateUtil;

public class ReimbDAO implements IReimbDAO{
	
	public ReimbDAO() {
		// TODO Auto-generated constructor stub
	}

	public boolean insert(Reimb re) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = null;
		try {
			tx = ses.beginTransaction();

			ses.save(re);
			tx.commit();
			
			return true;
			
		}catch(HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean update(Reimb re) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx = ses.beginTransaction();

			ses.merge(re);		
			tx.commit();
			
			return true;
			
		}catch(HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	public Reimb selectbyId(int id) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx = ses.beginTransaction();
			
			Reimb re = ses.get(Reimb.class, id);
			
			if(re == null) {
				System.out.println(" There are no reimbursement by that id");
				return null;
			}else{
				tx.commit();
				return re;
			}
			
		}catch(HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		}
		
		return null;
	}
	
	public List<Reimb> selectAll(){
		Session ses = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx = ses.beginTransaction();
			String hql = "FROM Reimb";
		
			@SuppressWarnings("unchecked")
			Query<Reimb> query = ses.createQuery(hql);
			List<Reimb> results = query.list();
			
			if(results.isEmpty()) {
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
	
	public List<Reimb> selectPending(){
		Session ses = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx = ses.beginTransaction();
			String hql = "FROM Reimb WHERE status.statusID=:s";
		
			@SuppressWarnings("unchecked")
			Query<Reimb> query = ses.createQuery(hql);
			List<Reimb> results = query.list();
			query.setParameter("s", "pending");
			
			if(results.isEmpty()) {
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
	
	public List<Reimb> selectComplete(){
		Session ses = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx = ses.beginTransaction();
			String hql = "FROM Reimb WHERE NOT status.statusID=:s";
		
			@SuppressWarnings("unchecked")
			Query<Reimb> query = ses.createQuery(hql);
			List<Reimb> results = query.list();
			query.setParameter("s", "pending");
			
			if(results.isEmpty()) {
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
	
	public List<Reimb> selectByUser(int id){
		Session ses = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx = ses.beginTransaction();
			String hql = "FROM Reimb WHERE author.userID=:u";
			
			@SuppressWarnings("unchecked")
			Query<Reimb> query = ses.createQuery(hql);
			query.setParameter("u", id);
			List<Reimb> results = query.list();
			
			
			if(results.isEmpty()) {
				System.out.println("There is no status under that id: " + id);
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
