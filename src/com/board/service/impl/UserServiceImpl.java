package com.board.service.impl;

import com.board.dao.impl.UserDao;
import com.board.dao.impl.UserDaoImpl;
import com.board.domain.User;

public class UserServiceImpl implements UserService {

	@Override
	public boolean findUser(String username) {
		// TODO Auto-generated method stub
		UserDao userDao=new UserDaoImpl();
		return userDao.findUser(username);
	}

	@Override
	public void insertUser(String username, String password) {
		// TODO Auto-generated method stub
		UserDao userDao=new UserDaoImpl();
		userDao.insertUser(username,password);
	}

	@Override
	public User getUser(String username, String password) {
		// TODO Auto-generated method stub
		UserDao userDao=new UserDaoImpl();
		return userDao.getUser(username,password);
	}

	@Override
	public void change(String username, String password) {
		// TODO Auto-generated method stub
		UserDao userDao=new UserDaoImpl();
		userDao.change(username,password);
	}

}
