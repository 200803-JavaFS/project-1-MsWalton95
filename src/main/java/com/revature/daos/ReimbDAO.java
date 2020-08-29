package com.revature.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Reimb;
import com.revature.models.User;
import com.revature.util.HibernateUtil;

public class ReimbDAO {
	
	public ReimbDAO() {
		// TODO Auto-generated constructor stub
	}

	public void insert(Reimb re) {
		Session ses = HibernateUtil.getSession();
		
		Transaction tx = ses.beginTransaction();
		
		ses.save(re);
		
		tx.commit();
	}
	
	public void update(Reimb re) {
		Session ses = HibernateUtil.getSession();
		
		ses.merge(re);
	}
	
	public Reimb selectbyId(int id) {
		Session ses = HibernateUtil.getSession();
		
		Reimb re = ses.get(Reimb.class, id);
		
		return re;
	}
	
	
	public List<Reimb> selectAll(){
		Session ses = HibernateUtil.getSession();
		
		List<Reimb> re = ses.createQuery("user_role FROM ers_reimbrsement").list();

		return re;
	}
}
