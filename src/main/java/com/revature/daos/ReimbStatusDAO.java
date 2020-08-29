package com.revature.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.ReimbStatus;
import com.revature.util.HibernateUtil;

public class ReimbStatusDAO {
	public void insert(ReimbStatus re) {
		Session ses = HibernateUtil.getSession();
		
		Transaction tx = ses.beginTransaction();
		
		ses.save(re);
		
		tx.commit();
	}
	
	public void update(ReimbStatus re) {
		Session ses = HibernateUtil.getSession();
		
		ses.merge(re);
	}
	
	public ReimbStatus selectbyId(int id) {
		Session ses = HibernateUtil.getSession();
		
		ReimbStatus re = ses.get(ReimbStatus.class, id);
		
		return re;
	}
	

	public List<ReimbStatus> selectAll(){
		Session ses = HibernateUtil.getSession();
		
		List<ReimbStatus> re = ses.createQuery("user_role FROM ers_users").list();

		return re;
	}
}
