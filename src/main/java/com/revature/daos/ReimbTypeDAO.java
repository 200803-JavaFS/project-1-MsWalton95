package com.revature.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.ReimbType;
import com.revature.util.HibernateUtil;

public class ReimbTypeDAO {
	public void insert(ReimbType re) {
		Session ses = HibernateUtil.getSession();
		
		Transaction tx = ses.beginTransaction();
		
		ses.save(re);
		
		tx.commit();
	}
	
	public void update(ReimbType re) {
		Session ses = HibernateUtil.getSession();
		
		ses.merge(re);
	}
	
	public ReimbType selectbyId(int id) {
		Session ses = HibernateUtil.getSession();
		
		ReimbType re = ses.get(ReimbType.class, id);
		
		return re;
	}

	
	public List<ReimbType> selectAll(){
		Session ses = HibernateUtil.getSession();
		
		List<ReimbType> types = ses.createQuery("user_role FROM ers_reimbursement_type").list();

		return types;
	}
}
