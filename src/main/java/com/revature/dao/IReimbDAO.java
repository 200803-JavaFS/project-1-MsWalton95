package com.revature.dao;

import java.util.List;

import com.revature.model.Reimbursement;

public interface IReimbDAO {
	
	public List<Reimbursement> getAll();
	
	public List<Reimbursement> getAllPending();
	
	public List<Reimbursement> getAllDenied();
	
	public List<Reimbursement> getByUserID(int userID);
	
	public Reimbursement getByReimbID(int reimbID);
	
	public boolean addReimburse(Reimbursement re);

	public boolean updateReimburse(Reimbursement re);
	
	public boolean deleteReimburse(int reimbID);
	
}
 