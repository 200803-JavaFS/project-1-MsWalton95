package com.revature.services;

import java.util.List;

import com.revature.dao.IReimbTypeDAO;
import com.revature.dao.ReimbTypeDAO;
import com.revature.model.ReimbursementStatus;
import com.revature.model.ReimbursementType;

public class ReimbTypeService {
	IReimbTypeDAO rtDao = new ReimbTypeDAO();
	
	public List<ReimbursementType> getAll(){
		return rtDao.getAll();
	}
	
	public boolean add(ReimbursementType ret) {
		return rtDao.add(ret);
	}
	
	public ReimbursementType getID(int id) {
		return rtDao.getID(id);
	}
}
