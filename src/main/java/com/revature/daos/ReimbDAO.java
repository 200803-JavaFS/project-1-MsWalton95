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
import com.revature.util.HibernateUtil;

public class ReimbDAO implements IReimbDAO{
	private static final Logger log = LogManager.getLogger(ReimbDAO.class);
	
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
			log.info("Ticket added");
			return true;
			
		}catch(HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace();
			log.warn("Unable to add ticket");
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
			log.info("Ticket updated");
			return true;
			
		}catch(HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace();
			log.warn("Unable to add ticket");
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
