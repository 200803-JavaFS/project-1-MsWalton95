package com.revature.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.UserRole;
import com.revature.util.HibernateUtil;

public class DirectorDAO {
	public DirectorDAO() {
		// TODO Auto-generated constructor stub
	}

	public void insert(UserRole chara) {
		Session ses = HibernateUtil.getSession();
		
		Transaction tx = ses.beginTransaction();
		
		ses.save(chara);
		
		tx.commit();
	}
	
	public void update(UserRole chara) {
		Session ses = HibernateUtil.getSession();
		
		ses.merge(chara);
	}
	
	public UserRole selectbyId(int id) {
		Session ses = HibernateUtil.getSession();
		
		UserRole chara = ses.get(UserRole.class, id);
		
		return chara;
	}
	
	public List<Character> selectAll(){
		Session ses = HibernateUtil.getSession();
		
		List<Character> charList = ses.createQuery("FROM Director").list();

		return charList;
	}
}
