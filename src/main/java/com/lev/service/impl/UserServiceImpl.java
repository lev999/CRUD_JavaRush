package com.lev.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lev.dao.UserDao;
import com.lev.model.User;
import com.lev.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	
	@Transactional
	public void add(User user) {
		userDao.add(user);
	}

	@Transactional
	public String edit(User user) {
		return userDao.edit(user);
	}

	@Transactional
	public String delete(int userId) {
		return userDao.delete(userId);
	}

	@Transactional
	public User getUser(int userId) {
		return userDao.getUser(userId);
	}

	@Transactional
	public int getAllUserNumber() {
		return userDao.getAllUserNumber();
	}
	
	@Transactional
	public List showOnePage(int page,int recordsPerPage) {
		return userDao.showOnePage(page,recordsPerPage);
	}

	@Transactional
	public User getUserByName(String name) {
		// TODO Auto-generated method stub
		return userDao.getUserByName(name);
	}


}
