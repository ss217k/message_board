package com.board.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.board.domain.User;
import com.board.utils.JDBCUtils;

public class UserDaoImpl implements UserDao {

	@Override
	public boolean findUser(String username) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=JDBCUtils.getConnection();
			String sql="select * from user where username=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, username);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				return true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.release(rs, pstmt, conn);
		}
		return false;
	}

	@Override
	public void insertUser(String username, String password) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=JDBCUtils.getConnection();
			String sql="insert into user values(null,?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.executeUpdate();
		}catch(Exception e ) {
			e.printStackTrace();
		}finally {
			JDBCUtils.release(pstmt, conn);
		}
	}

	@Override
	public User getUser(String username, String password) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=JDBCUtils.getConnection();
			String sql="select * from user where username=? and password=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				User user=new User();
				user.setId(rs.getInt("id"));
				user.setUsername(username);
				user.setPassword(password);
				return user;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.release(rs, pstmt, conn);
		}
		return null;
	}

	@Override
	public void change(String username, String password) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=JDBCUtils.getConnection();
			String sql="UPDATE user SET password=? WHERE username=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, password);
			pstmt.setString(2, username);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.release(pstmt, conn);
		}
	}

	@Override
	public void add(Integer user_id, String username, String title, String content) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=JDBCUtils.getConnection();
			String sql="insert into message values(null,?,?,?,?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setLong(1, user_id);
			pstmt.setString(2, username);
			pstmt.setString(3, title);
			pstmt.setString(4, content);
			pstmt.setDate(5, new Date(System.currentTimeMillis()));
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.release(pstmt, conn);
		}
	}

}
