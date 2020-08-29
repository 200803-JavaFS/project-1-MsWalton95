package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.model.ReimbursementType;
import com.revature.util.ConnectionUtil;

public class ReimbTypeDAO implements IReimbTypeDAO{

	@Override
	public List<ReimbursementType> getAll() {
		Session ses = ConnectionUtil.getSession();
		
		List<ReimbursementType> type = ses.createQuery("FROM ers_reimbursement_type").list();
		
		return type;
	}

	@Override
	public boolean add(ReimbursementType res) {
		Session ses = ConnectionUtil.getSession();
		
		Transaction tx = ses.beginTransaction();
		
		ses.save(res);
		
		tx.commit();
		
		return true;
		
	}

	@Override
	public ReimbursementType getID(int id) {
		Session ses = ConnectionUtil.getSession();
		
		ReimbursementType ret = ses.get(ReimbursementType.class, id);
		
		return ret;
	}

}
