package com.revature.daos;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.daoimpl.IReimbTypeDAO;
import com.revature.models.ReimbType;
import com.revature.util.HibernateUtil;

public class ReimbTypeDAO implements IReimbTypeDAO{
	
	public ReimbTypeDAO() {
		// TODO Auto-generated constructor stub
	}

	public boolean insert(ReimbType re) {
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
	
	public ReimbType selectbyId(int id) {
		Session ses = HibernateUtil.getSession();
		try {
			ReimbType re = ses.get(ReimbType.class, id);
			
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
	
	public List<ReimbType> selectAll(){
		Session ses = HibernateUtil.getSession();
		try {
			String hql = "FROM ReimbType";
		
			@SuppressWarnings("unchecked")
			Query<ReimbType> query = ses.createQuery(hql);
			List<ReimbType> results = query.list();
			
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
