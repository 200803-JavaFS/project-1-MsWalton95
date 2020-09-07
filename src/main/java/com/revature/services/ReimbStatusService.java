package com.revature.services;

import java.util.List;

import com.revature.daoimpl.IReimbStatusDAO;
import com.revature.daos.ReimbStatusDAO;
import com.revature.models.ReimbStatus;

public class ReimbStatusService {
	
	public static IReimbStatusDAO rsDao = new ReimbStatusDAO();
	
	public boolean insert(ReimbStatus re) {
		return rsDao.insert(re);
	}
	
	public ReimbStatus selectbyId(int id) {
		return rsDao.selectbyId(id);
	}
	
	public List<ReimbStatus> selectAll(){
		return rsDao.selectAll();
	}
}
