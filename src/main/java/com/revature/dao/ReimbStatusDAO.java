package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.model.ReimbursementStatus;

import com.revature.util.ConnectionUtil;

public class ReimbStatusDAO implements IReimbStatusDAO{

	@Override
	public List<ReimbursementStatus> getAll() {
		Session ses = ConnectionUtil.getSession();
		
		List<ReimbursementStatus> status= ses.createQuery("FROM ers_reimbursement_status").list();
		
		return status;
	}

	@Override
	public boolean add(ReimbursementStatus res) {
		Session ses = ConnectionUtil.getSession();
		
		Transaction tx = ses.beginTransaction();
		
		ses.save(res);
		
		tx.commit();
		
		return true;
		
	}

	@Override
	public ReimbursementStatus getID(int id) {
		Session ses = ConnectionUtil.getSession();
		
		ReimbursementStatus res = ses.get(ReimbursementStatus.class, id);
		
		return res;
	}

}
