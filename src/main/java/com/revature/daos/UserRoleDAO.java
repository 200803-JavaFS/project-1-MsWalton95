package com.revature.daos;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

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
		}catch(HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public UserRole selectbyId(int id) {
		Session ses = HibernateUtil.getSession();
		UserRole u = ses.get(UserRole.class, id);
		
		if(u != null) {
			return u;
		} else {
			return null;
		}
	}

	@Override
	public List<UserRole> selectAll() {
		Session ses = HibernateUtil.getSession();

		String hql = "FROM UserRole";
		
		@SuppressWarnings("unchecked")
		Query<UserRole> query = ses.createQuery(hql);
		List<UserRole> results = query.list();

		if(results.isEmpty()) {
			return null;
		} else {
			return results;
		}
	}

}
