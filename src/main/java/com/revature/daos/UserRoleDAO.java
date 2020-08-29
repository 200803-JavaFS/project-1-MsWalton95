package com.revature.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.models.UserRole;
import com.revature.util.HibernateUtil;

public class UserRoleDAO {
	public UserRoleDAO() {
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
	
	public List<UserRole> selectAll(){
		Session ses = HibernateUtil.getSession();
		
		String hql = "FROM ERS_USER_ROLES";
		List<UserRole> list = ses.createQuery(hql).list();
		//List results = query.list();
		//List<UserRole> charList = ses.createQuery("FROM ers_user_roles").list();

		return list;
	}
}
