package com.board.service.impl;

import com.board.domain.User;

public interface UserService {

	boolean findUser(String username);

	void insertUser(String username, String password);

	User getUser(String username, String password);

	void change(String username, String password);

}
