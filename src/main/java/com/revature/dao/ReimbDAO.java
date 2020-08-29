package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.model.Reimbursement;
import com.revature.model.User;
import com.revature.util.ConnectionUtil;

public class ReimbDAO implements IReimbDAO{
	
	Reimbursement re = new Reimbursement();
	User us = new User();

	@Override
	public List<Reimbursement> getAll() {
		Session ses = ConnectionUtil.getSession();
		
		List<Reimbursement> list = ses.createQuery("FROM ers_reimbursement").list();
		
		return list;
	}

	@Override
	public List<Reimbursement> getAllPending() {
		return null;
	}

	@Override
	public List<Reimbursement> getAllDenied() {
		return null;
	}
	
	@Override
	public List<Reimbursement> getByUserID(int userID) {
		return null;
	}

	@Override
	public Reimbursement getByReimbID(int reimbID) {
		Session ses = ConnectionUtil.getSession();
		
		Reimbursement re = ses.get(Reimbursement.class, reimbID);
		
		if(re != null) {
			return re;
		}else {
			return null;
		}
		
	}
	
	@Override
	public boolean addReimburse(Reimbursement re) {
		Session ses = ConnectionUtil.getSession();
		Transaction tx = ses.beginTransaction();
		
		try {
			IUserDAO uDao = new UserDAO();
			//uDao.addUser(a.getHomeBase());
			ses.save(re);
			tx.commit();
			return true;
		
		}catch(HibernateException e) {
			tx.rollback();
			e.printStackTrace(); 
			return false;
		}finally {
			ses.close();
		}
	}

	@Override
	public boolean updateReimburse(Reimbursement re) {
		Session ses = ConnectionUtil.getSession();
		Transaction tx = ses.beginTransaction();
		
		try {
			ses.merge(re);
			tx.commit();
			return true;
		}catch(HibernateException e) {
			tx.rollback();
			e.printStackTrace();
			return false;
		}finally {
			ses.close();
		}
	}
	
	@Override
	public boolean deleteReimburse(int reimbID) {
		Session ses = ConnectionUtil.getSession();
		
		try {
			ses.createQuery("DELETE FROM ers_reimbursement WHERE reimb_id ="+reimbID);
			return true;
		}catch(HibernateException e) {
			e.printStackTrace();
			return false;
		}finally {
			ses.close();
		}
	}
	
	
//	public boolean addReimbursementwithStatus(Reimbursement re) {
//		Session ses = ConnectionUtil.getSession();
//		
//		Transaction tx = ses.beginTransaction();
//		try {
//		IUserDAO uDao = new UserDAO();
//		//uDao.addHome(a.getHomeBase());
//		//ses.saveOrUpdate(a);
//		tx.commit();
//		return true;
//		}catch(HibernateException e) {
//			e.printStackTrace();
//			tx.rollback();
//			return false;
//		}
//		
//	}

}
