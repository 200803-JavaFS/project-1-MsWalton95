package com.revature.daos;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.daoimpl.IReimbDAO;
import com.revature.models.Reimb;
import com.revature.models.ReimbStatus;
import com.revature.models.ReimbType;
import com.revature.models.Users;
import com.revature.util.HibernateUtil;

public class ReimbDAO implements IReimbDAO{
	public ReimbDAO() {}

	@Override
	public boolean insert(Reimb re, int user, int type) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = null;
		try {
			tx = ses.beginTransaction();
			
			ReimbStatus status = ses.get(ReimbStatus.class, 2);
			ReimbType types = ses.get(ReimbType.class, type);
			Users author = ses.get(Users.class, user);

			re.setType(types);
			re.setStatus(status);
			re.setAuthor(author);
			
			ses.save(re);
			tx.commit();

			return true;
		}catch(HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean update(Reimb re, int user, int status) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx = ses.beginTransaction();
			
			ReimbStatus statuses = ses.get(ReimbStatus.class, status);
			Users resolver = ses.get(Users.class, user);
			
			Calendar calendar = Calendar.getInstance();
			Timestamp current = new Timestamp(calendar.getTime().getTime());
			
			re.setReimbID(re.getReimbID());
			re.setStatus(statuses);
			re.setResolver(resolver);
			re.setResolved(current);

			ses.merge(re);		
			tx.commit();
			
			return true;
		}catch(HibernateException e) {
			if (tx!=null) tx.rollback();
			
			return false;
		}
	}
	
	public Reimb selectbyId(int id) {
		Session ses = HibernateUtil.getSession();
		Reimb re = ses.get(Reimb.class, id);

		if(re != null) {
			return re;
		} else {
			return null;
		}
	}
	
	public List<Reimb> selectAll(){
		Session ses = HibernateUtil.getSession();
		String hql = "FROM Reimb";
	
		@SuppressWarnings("unchecked")
		Query<Reimb> query = ses.createQuery(hql);
		List<Reimb> results = query.list();

		if(results.isEmpty()) {
			return null;
		} else {
			return results;
		}
	}
	
	public List<Reimb> selectByUser(int id){
		Session ses = HibernateUtil.getSession();
		String hql = "FROM Reimb WHERE author.userID=:u";
		
		@SuppressWarnings("unchecked")
		Query<Reimb> query = ses.createQuery(hql);
		query.setParameter("u", id);
		List<Reimb> results = query.list();System.out.println("Select By user"+results);

		if(results.isEmpty()) {
			return null;
		} else {
			return results;
		}
	}

}
