package com.revature.services;

import java.util.List;

import com.revature.daoimpl.IReimbTypeDAO;
import com.revature.daos.ReimbTypeDAO;
import com.revature.models.ReimbType;

public class ReimbTypeService {
private static IReimbTypeDAO reDao = new ReimbTypeDAO();
	
	public boolean insert(ReimbType re) {
		return reDao.insert(re);
	}
	
	public ReimbType selectbyId(int id) {
		return reDao.selectbyId(id);
	}
	
	public List<ReimbType> selectAll(){
		return reDao.selectAll();
	}
}
