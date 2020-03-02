package com.board.dao.impl;

import com.board.domain.User;

public interface UserDao {

	boolean findUser(String username);

	void insertUser(String username, String password);

	User getUser(String username, String password);

	void change(String username, String password);

	void add(Integer user_id, String username, String title, String content);

}
