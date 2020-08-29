package com.revature.services;

import java.util.List;

import com.revature.dao.IReimbStatusDAO;
import com.revature.dao.ReimbStatusDAO;
import com.revature.model.ReimbursementStatus;

public class ReimbStatusService {
	IReimbStatusDAO rsDao = new ReimbStatusDAO();
	
	public List<ReimbursementStatus> getAll(){
		return rsDao.getAll();
	}
	
	public boolean add(ReimbursementStatus res) {
		return rsDao.add(res);
	}
	
	public ReimbursementStatus getID(int id) {
		return rsDao.getID(id);
	}
}
