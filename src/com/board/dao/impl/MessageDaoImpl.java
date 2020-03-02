package com.board.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.board.domain.Message;
import com.board.utils.JDBCUtils;

public class MessageDaoImpl implements MessageDao {

	@Override
	public List<Message> findAll() {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Message> list=null;
		try {
			conn=JDBCUtils.getConnection();
			String sql="select * from message order by create_time desc";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			list=new ArrayList<Message>();
			while(rs.next()) {
				Message message=new Message();
				message.setId(rs.getInt("id"));
				message.setUser_id(rs.getInt("user_id"));
				message.setUsername(rs.getString("username"));
				message.setTitle(rs.getString("title"));
				message.setContent(rs.getString("content"));
				message.setCreateTime(rs.getDate("create_time"));
				list.add(message);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.release(rs, pstmt, conn);
		}
		return list;
	}

	@Override
	public List<Message> findOne(Integer user_id) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Message> list=null;
		try {
			conn=JDBCUtils.getConnection();
			String sql="select * from message where user_id=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, user_id);
			rs=pstmt.executeQuery();
			list=new ArrayList<Message>();
			while(rs.next()) {
				Message message=new Message();
				message.setId(rs.getInt("id"));
				message.setUser_id(rs.getInt("user_id"));
				message.setUsername(rs.getString("username"));
				message.setTitle(rs.getString("title"));
				message.setContent(rs.getString("content"));
				message.setCreateTime(rs.getDate("create_time"));
				list.add(message);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.release(rs, pstmt, conn);
		}
		return list;
	}

	@Override
	public Message findupdate(Integer id) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=JDBCUtils.getConnection();
			String sql="select * from message where id=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				Message message=new Message();
				message.setId(rs.getInt("id"));
				message.setUser_id(rs.getInt("user_id"));
				message.setUsername(rs.getString("username"));
				message.setTitle(rs.getString("title"));
				message.setContent(rs.getString("content"));
				message.setCreateTime(rs.getDate("create_time"));
				return message;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.release(rs, pstmt, conn);
		}
		return null;
	}

	@Override
	public void change(Integer id, String title, String content) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=JDBCUtils.getConnection();
			String sql="update message set title=?,content=? where id=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, id);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.release(pstmt, conn);
		}
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=JDBCUtils.getConnection();
			String sql="delete from message where id=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.release(pstmt, conn);
		}
	}

	@Override
	public int findCount() {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Long count=0l;
		try {
			conn=JDBCUtils.getConnection();
			String sql="select count(*) as count from message";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				count=rs.getLong("count");
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.release(rs, pstmt, conn);
		}
		return count.intValue();
	}

	@Override
	public List<Message> findByPage(int begin, int limit) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Message> list=null;
		try {
			conn=JDBCUtils.getConnection();
			String sql="select * from message order by create_time desc limit ?,? ";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, begin);
			pstmt.setInt(2, limit);
			rs=pstmt.executeQuery();
			list=new ArrayList<Message>();
			while(rs.next()) {
				Message message=new Message();
				message.setId(rs.getInt("id"));
				message.setUser_id(rs.getInt("user_id"));
				message.setUsername(rs.getString("username"));
				message.setTitle(rs.getString("title"));
				message.setContent(rs.getString("content"));
				message.setCreateTime(rs.getDate("create_time"));
				list.add(message);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.release(rs, pstmt, conn);
		}
		return list;
	}

	@Override
	public int findCount2(Integer user_id) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Long count=0l;
		try {
			conn=JDBCUtils.getConnection();
			String sql="select count(*) as count from message where user_id=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, user_id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				count=rs.getLong("count");
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.release(rs, pstmt, conn);
		}
		return count.intValue();
	}

	@Override
	public List<Message> findByPage2(int begin, int limit,Integer user_id) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Message> list=null;
		try {
			conn=JDBCUtils.getConnection();
			String sql="select * from message where user_id=? order by create_time desc limit ?,? ";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, user_id);
			pstmt.setInt(2, begin);
			pstmt.setInt(3, limit);
			
			rs=pstmt.executeQuery();
			list=new ArrayList<Message>();
			while(rs.next()) {
			//	System.out.println("1111");
				Message message=new Message();
				message.setId(rs.getInt("id"));
				message.setUser_id(rs.getInt("user_id"));
				message.setUsername(rs.getString("username"));
				message.setTitle(rs.getString("title"));
				message.setContent(rs.getString("content"));
				message.setCreateTime(rs.getDate("create_time"));
				list.add(message);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.release(rs, pstmt, conn);
		}
		return list;
	}

}
