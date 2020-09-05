package com.revature.daos;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.daoimpl.IReimbStatusDAO;
import com.revature.models.ReimbStatus;
import com.revature.util.HibernateUtil;

public class ReimbStatusDAO implements IReimbStatusDAO{
	
	public ReimbStatusDAO() {
		// TODO Auto-generated constructor stub
	}

	public boolean insert(ReimbStatus re) {
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
	
	public ReimbStatus selectbyId(int id) {
		Session ses = HibernateUtil.getSession();
		
		try {
			ReimbStatus re = ses.get(ReimbStatus.class, id);
			
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
	
	public List<ReimbStatus> selectAll(){
		Session ses = HibernateUtil.getSession();
		try {
			String hql = "FROM ReimbStatus";
		
			@SuppressWarnings("unchecked")
			Query<ReimbStatus> query = ses.createQuery(hql);
			List<ReimbStatus> results = query.list();
			
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
