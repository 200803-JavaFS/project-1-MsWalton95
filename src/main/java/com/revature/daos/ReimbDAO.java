package com.revature.daos;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.models.Reimb;
import com.revature.models.ReimbStatus;
import com.revature.models.ReimbType;
import com.revature.models.User;
import com.revature.models.UserRole;
import com.revature.util.HibernateUtil;

public class ReimbDAO implements IReimbDAO{
	
	public ReimbDAO() {
		// TODO Auto-generated constructor stub
	}

	public boolean insert(Reimb re, int type, int status, int author) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = null;
		try {
			tx = ses.beginTransaction();
			
			User au = ses.get(User.class, author);
			ReimbType rt = ses.get(ReimbType.class, type);
			ReimbStatus rs = ses.get(ReimbStatus.class, status);
			
			re.setAuthor(au);
			re.setStatus(rs);
			re.setType(rt);
			
			ses.save(re);
			tx.commit();
			
			return true;
			
		}catch(HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean update(Reimb re, int resolver, int type, int status, int author) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx = ses.beginTransaction();
	
			User au = ses.get(User.class, author);
			User res = ses.get(User.class, resolver);
			ReimbType rt = ses.get(ReimbType.class, type);
			ReimbStatus rs = ses.get(ReimbStatus.class, status);
			
			re.setAuthor(au);
			re.setResolver(res);
			re.setStatus(rs);
			re.setType(rt);
			
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
			String hql = "FROM com.revature.models.Reimb";
		
			@SuppressWarnings("unchecked")
			Query<Reimb> query = ses.createQuery(hql);
			List<Reimb> results = query.list();
			
			if(results.isEmpty()) {
				System.out.println(" There are no reimbursements");
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
	
	public List<Reimb> selectByStatus(int id){
		Session ses = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx = ses.beginTransaction();
			String hql = "FROM com.revature.models.Reimb WHERE status.statusID=:s";
			
			@SuppressWarnings("unchecked")
			Query<Reimb> query = ses.createQuery(hql);
			query.setParameter("s", id);
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
	
	public List<Reimb> selectByType(int id){
		Session ses = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx = ses.beginTransaction();
			String hql = "FROM com.revature.models.Reimb WHERE type.typeID=:t";
			
			@SuppressWarnings("unchecked")
			Query<Reimb> query = ses.createQuery(hql);
			query.setParameter("t", id);
			List<Reimb> results = query.list();
			
			if(results.isEmpty()) {
				System.out.println("There is no type under that id: " + id );
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
	
	public List<Reimb> selectByAuthor(int id){
		Session ses = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx = ses.beginTransaction();
			String hql = "FROM com.revature.models.Reimb WHERE author.userID=:a";
			
			@SuppressWarnings("unchecked")
			Query<Reimb> query = ses.createQuery(hql);
			query.setParameter("a", id);
			List<Reimb> results = query.list();
			
			if(results.isEmpty()) {
				System.out.println("There is no reimbursement under that id: " + id );
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
	
	public List<Reimb> selectByResolver(int id){
		Session ses = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx = ses.beginTransaction();
			String hql = "FROM com.revature.models.Reimb WHERE resolver.userID=:r";
			
			@SuppressWarnings("unchecked")
			Query<Reimb> query = ses.createQuery(hql);
			query.setParameter("r", id);
			List<Reimb> results = query.list();
			
			if(results.isEmpty()) {
				System.out.println("There is no reimbursement under that id: " + id );
				return null;
			}else{
				tx.commit();
				return results;
			}
		}catch(HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		}catch(NullPointerException e) {System.out.println(e);}
		
		return null;
	}
}