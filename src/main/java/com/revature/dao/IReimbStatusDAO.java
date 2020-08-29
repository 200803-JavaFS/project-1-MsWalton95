package com.revature.dao;

import java.util.List;

import com.revature.model.ReimbursementStatus;

public interface IReimbStatusDAO {
	public List<ReimbursementStatus> getAll();
	
	public boolean add(ReimbursementStatus res);
	
	public ReimbursementStatus getID(int id);
}
