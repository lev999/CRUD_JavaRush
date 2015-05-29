package com.lev.dao.impl;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lev.dao.UserDao;
import com.lev.model.User;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(User user) {
		session.getCurrentSession().save(user);
	}

	@Override
	public String edit(User user) {
		try {
			session.getCurrentSession().update(user);	
		} catch (Exception e) {
			// TODO: handle exception
			return "Some problems of your input";
		}
		return "user updated. Thanks";
	}

	@Override
	public String delete(int userId) {		
		try {
			session.getCurrentSession().delete(getUser(userId));	
		} catch (Exception e) {
			// TODO: handle exception
			return "user ID not correct :( ";
			
		}
		return "user with id="+userId+" deleted. Thank you ";
	}

	@Override
	public User getUser(int userId) {
		return (User)session.getCurrentSession().get(User.class, userId);
	}

	@Override
	public int getAllUserNumber() {
			
		return ((Long) session.getCurrentSession().createQuery("SELECT COUNT(*) from User").uniqueResult()).intValue();
	}

	
	@Override
	public List showOnePage(int page, int recordsPerPage) {
		int begin;
		begin=(page-1)*recordsPerPage;
	
		Query query = session.getCurrentSession().createQuery("from User");
		query.setFirstResult(begin);
		query.setMaxResults(recordsPerPage);
		return query.list();
		
	}

	@Override
	public User getUserByName(String name) {

		String query="from User as user where user.name like '"+name+"'";
		try {
			return (User) session.getCurrentSession().createQuery(query).list().get(0);	
		} catch (Exception e) {
			return null;
		}
		
	}
	

}
