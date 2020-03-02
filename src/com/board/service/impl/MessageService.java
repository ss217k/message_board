package com.board.service.impl;

import java.util.List;

import com.board.domain.Message;
import com.board.domain.PageBean;

public interface MessageService {

	List<Message> findAll();

	List<Message> findOne(Integer user_id);

	Message findupdate(Integer id);

	void change(Integer id, String title, String content);

	void add(Integer user_id, String username, String title, String content);

	void delete(Integer id);

	PageBean<Message> findByPage(int page);

	PageBean<Message> findByPage2(int page,Integer user_id);
}
