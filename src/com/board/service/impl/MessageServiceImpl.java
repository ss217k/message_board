package com.board.service.impl;

import java.util.List;

import com.board.dao.impl.MessageDao;
import com.board.dao.impl.MessageDaoImpl;
import com.board.dao.impl.UserDao;
import com.board.dao.impl.UserDaoImpl;
import com.board.domain.Message;
import com.board.domain.PageBean;

public class MessageServiceImpl implements MessageService {

	@Override
	public List<Message> findAll() {
		// TODO Auto-generated method stub
		MessageDao messageDao=new MessageDaoImpl();
		return messageDao.findAll();
	}

	@Override
	public List<Message> findOne(Integer user_id) {
		// TODO Auto-generated method stub
		MessageDao messageDao=new MessageDaoImpl();
		return messageDao.findOne(user_id);
	}

	@Override
	public Message findupdate(Integer id) {
		// TODO Auto-generated method stub
		MessageDao messageDao=new MessageDaoImpl();
		return messageDao.findupdate(id);
	}

	@Override
	public void change(Integer id, String title, String content) {
		// TODO Auto-generated method stub
		MessageDao messageDao=new MessageDaoImpl();
		messageDao.change(id,title,content);
	}

	@Override
	public void add(Integer user_id, String username, String title, String content) {
		// TODO Auto-generated method stub
		UserDao userDao=new UserDaoImpl();
		userDao.add(user_id,username,title,content);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		MessageDao messageDao=new MessageDaoImpl();
		messageDao.delete(id);
	}

	@Override
	public PageBean<Message> findByPage(int page) {
		// TODO Auto-generated method stub
		PageBean<Message> pageBean=new PageBean<>();
		//封装当前页数
		pageBean.setPage(page);
		//封装每页显示的记录数
		int limit=6;
		pageBean.setLimit(limit);
		//封装总记录数
		MessageDao messageDao=new MessageDaoImpl();
		int totalCount=messageDao.findCount();
		pageBean.setTotalCount(totalCount);
		//封装总页数
		int totalPage=0;
		if(totalCount%limit==0) {
			totalPage=totalCount/limit;
		}else {
			totalPage=totalCount/limit+1;
		}
		pageBean.setTotalPage(totalPage);
		//每页显示数据的list集合
		int begin=(page-1)*limit;
		List<Message> list=messageDao.findByPage(begin,limit);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public PageBean<Message> findByPage2(int page,Integer user_id) {
		// TODO Auto-generated method stub
		PageBean<Message> pageBean=new PageBean<>();
		//封装当前页数
		pageBean.setPage(page);
		//封装每页显示的记录数
		int limit=6;
		pageBean.setLimit(limit);
		//封装总记录数
		MessageDao messageDao=new MessageDaoImpl();
		int totalCount=messageDao.findCount2(user_id);
		pageBean.setTotalCount(totalCount);
		//封装总页数
		int totalPage=0;
		if(totalCount%limit==0) {
			totalPage=totalCount/limit;
		}else {
			totalPage=totalCount/limit+1;
		}
		pageBean.setTotalPage(totalPage);
		//每页显示数据的list集合
		int begin=(page-1)*limit;
		List<Message> list=messageDao.findByPage2(begin,limit,user_id);
		pageBean.setList(list);
		return pageBean;
		//return null;
	}

}
