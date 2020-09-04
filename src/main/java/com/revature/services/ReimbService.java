package com.revature.services;

import java.util.List;

import com.revature.daoimpl.IReimbDAO;
import com.revature.daos.ReimbDAO;
import com.revature.models.Reimb;

public class ReimbService {
	public static IReimbDAO reDao = new ReimbDAO();
	
	public boolean insert(Reimb re) { 
		return reDao.insert(re);
	}
	
	public boolean update(Reimb re) {
		return reDao.update(re);
	}
	
	public Reimb selectbyId(int id) {
		return reDao.selectbyId(id);
	}
	
	public List<Reimb> selectAll(){
		return reDao.selectAll();
	}
	
	public List<Reimb> selectByUser(int id){
		return reDao.selectByUser(id);
	}

}
