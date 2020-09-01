package com.revature.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.daoimpl.IUserRoleDAO;
import com.revature.models.UserRole;
import com.revature.util.HibernateUtil;

public class UserRoleDAO implements IUserRoleDAO{

	@Override
	public boolean insert(UserRole ur) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx = ses.beginTransaction();
			ses.save(ur);
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public UserRole selectbyId(int id) {
		Session ses = HibernateUtil.getSession();

		UserRole u = ses.get(UserRole.class, id);
		
		if(u == null) {
			return null;
		}else{
			return u;
		}
	}

	@Override
	public List<UserRole> selectAll() {
		Session ses = HibernateUtil.getSession();

		List<UserRole> list = ses.createQuery("FROM UserRole").list();

		if(list.isEmpty()) {
			return null;
		}else{
			return list;
		}
	}

}
