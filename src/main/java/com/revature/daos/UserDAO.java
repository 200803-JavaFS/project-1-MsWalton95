package com.revature.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.User;
import com.revature.util.HibernateUtil;

public class UserDAO {

	public UserDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public void insert(User chara) {
		Session ses = HibernateUtil.getSession();
		
		Transaction tx = ses.beginTransaction();
		
		ses.save(chara);
		
		tx.commit();
	}
	
	public void update(User chara) {
		Session ses = HibernateUtil.getSession();
		
		ses.merge(chara);
	}
	
	public User selectbyId(int id) {
		Session ses = HibernateUtil.getSession();
		
		User chara = ses.get(User.class, id);
		
		return chara;
	}
	
	public User selectByName(int id) {
		Session ses = HibernateUtil.getSession();
		
		List<User> charList = ses.createQuery("FROM ers_users WHERE ers_users_id=" + id, User.class).list();
		
		User chara = charList.get(0);
		
		return chara;
	}
	
	public List<User> selectAll(){
		Session ses = HibernateUtil.getSession();
		
		List<User> charList = ses.createQuery("user_role FROM ers_users").list();

		return charList;
	}
}
