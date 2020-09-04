package com.revature.daoimpl;

import java.util.List;

import com.revature.models.Reimb;

public interface IReimbDAO {

	public boolean insert(Reimb re);
	
	public boolean update(Reimb re);
	
	public Reimb selectbyId(int id);
	
	public List<Reimb> selectAll();
	
	public List<Reimb> selectByUser(int id);
}
