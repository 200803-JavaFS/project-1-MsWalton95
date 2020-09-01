package com.revature.daoimpl;

import java.util.List;

import com.revature.models.ReimbStatus;

public interface IReimbStatusDAO {
	
	public boolean insert(ReimbStatus re);
	
	public ReimbStatus selectbyId(int id);
	
	public List<ReimbStatus> selectAll();
}
