package com.revature.services;

import java.util.List;

import com.revature.dao.IReimbDAO;
import com.revature.dao.ReimbDAO;
import com.revature.model.Reimbursement;

public class ReimbService {

	private static IReimbDAO reDao = new ReimbDAO();
	
	public List<Reimbursement> getAll(){
		return reDao.getAll();
	}
	
	public List<Reimbursement> getAllPending(){
		return reDao.getAllPending();
	}
	
	public List<Reimbursement> getAllDenied(){
		return reDao.getAllDenied();
	}
	
	public List<Reimbursement> getByUserID(int userID){
		return reDao.getByUserID(userID);
	}
	
	public Reimbursement getByReimbID(int reimbID) {
		return reDao.getByReimbID(reimbID);
	}
	
	public boolean addReimburse(Reimbursement re) {
		return reDao.addReimburse(re);
	}

	public boolean updateReimburse(Reimbursement re) {
		return reDao.updateReimburse(re);
	}
	
	public boolean deleteReimburse(int reimbID) {
		return reDao.deleteReimburse(reimbID);
	}
}
