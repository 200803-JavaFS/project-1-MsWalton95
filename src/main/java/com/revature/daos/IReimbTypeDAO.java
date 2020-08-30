package com.revature.daos;

import java.util.List;

import com.revature.models.ReimbType;

public interface IReimbTypeDAO {
	
	public boolean insert(ReimbType re);
	
	public ReimbType selectbyId(int id);
	
	public List<ReimbType> selectAll();
}
