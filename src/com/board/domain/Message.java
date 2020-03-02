package com.board.domain;

import java.util.Date;

public class Message {
	private Integer id;
	private Integer user_id;
	private String username;
	private String title;
	private String content;
	private Date createTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Message(Integer id, Integer user_id, String username, String title, String content, Date createTime) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.username = username;
		this.title = title;
		this.content = content;
		this.createTime = createTime;
	}
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Message [id=" + id + ", user_id=" + user_id + ", username=" + username + ", title=" + title
				+ ", content=" + content + ", createTime=" + createTime + "]";
	}
	
}
