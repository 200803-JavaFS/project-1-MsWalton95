package com.revaure.services;

import java.util.List;

import com.revature.daos.IReimbDAO;
import com.revature.daos.ReimbDAO;
import com.revature.models.Reimb;

public class ReimbService {
	public static IReimbDAO reDao = new ReimbDAO();
	
	public boolean insert(Reimb re, int type, int status, int author) { 
		return reDao.insert(re, type, status, author);
	}
	
	public boolean update(Reimb re, int type, int status, int author, int resolver) {
		return reDao.update(re, type, status, author, resolver);
	}
	
	public Reimb selectbyId(int id) {
		return reDao.selectbyId(id);
	}
	
	public List<Reimb> selectAll(){
		return reDao.selectAll();
	}
	
	public List<Reimb> selectByStatus(int id){
		return reDao.selectByStatus(id);
	}
	
	public List<Reimb> selectByType(int id){
		return reDao.selectByType(id);
	}
	
	public List<Reimb> selectByAuthor(int id){
		return reDao.selectByAuthor(id);
	}
	
	public List<Reimb> selectByResolver(int id){
		return reDao.selectByResolver(id);
	}
}
