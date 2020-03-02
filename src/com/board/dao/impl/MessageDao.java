package com.board.dao.impl;

import java.util.List;

import com.board.domain.Message;

public interface MessageDao {

	List<Message> findAll();

	List<Message> findOne(Integer user_id);

	Message findupdate(Integer id);

	void change(Integer id, String title, String content);

	void delete(Integer id);

	int findCount();

	List<Message> findByPage(int begin, int limit);

	int findCount2(Integer user_id);

	List<Message> findByPage2(int begin, int limit,Integer user_id);

}
