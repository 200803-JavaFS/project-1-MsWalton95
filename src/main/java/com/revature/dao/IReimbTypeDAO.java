package com.revature.dao;

import java.util.List;

import com.revature.model.ReimbursementType;

public interface IReimbTypeDAO {
	public List<ReimbursementType> getAll();
	
	public boolean add(ReimbursementType res);
	
	public ReimbursementType getID(int id);
}
