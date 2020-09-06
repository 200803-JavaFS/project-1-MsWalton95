package com.revature.daos;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.daoimpl.IReimbDAO;
import com.revature.models.Reimb;
import com.revature.models.ReimbStatus;
import com.revature.models.ReimbType;
import com.revature.models.Users;
import com.revature.util.HibernateUtil;

public class ReimbDAO implements IReimbDAO{
	
	public ReimbDAO() {
		// TODO Auto-generated constructor stub
	}

	public boolean insert(Reimb re, int user, int type) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = null;
		try {
			tx = ses.beginTransaction();
			
			ReimbStatus status = ses.get(ReimbStatus.class, 2);
			ReimbType types = ses.get(ReimbType.class, type);
			Users users = ses.get(Users.class, user);

			re.setType(types);
			re.setStatus(status);
			re.setAuthor(users);
			
			ses.save(re);
			tx.commit();

			return true;
			
		}catch(HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		
			return false;
		}
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
		
			return false;
		}
		
	}
	
	public Reimb selectbyId(int id) {
		Session ses = HibernateUtil.getSession();
		
		try {
			Reimb re = ses.get(Reimb.class, id);
			
			if(re == null) {
				return null;
			}else{
				return re;
			}
		}catch(HibernateException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public List<Reimb> selectAll(){
		Session ses = HibernateUtil.getSession();

		try {
			String hql = "FROM Reimb";
		
			@SuppressWarnings("unchecked")
			Query<Reimb> query = ses.createQuery(hql);
			List<Reimb> results = query.list();
			
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
	
	public List<Reimb> selectByUser(int id){
		Session ses = HibernateUtil.getSession();
		
		try {
			String hql = "FROM Reimb WHERE author.userID=:u";
			
			@SuppressWarnings("unchecked")
			Query<Reimb> query = ses.createQuery(hql);
			query.setParameter("u", id);
			List<Reimb> results = query.list();
			
			
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

}
