package com.bjsxt.entity;

import java.util.Date;

public class Reply {
	private int replyId;
	private int topicId;
	private String author;
	private String contnt;
	private Date createDate;
	public int getReplyId() {
		return replyId;
	}
	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}
	public int getTopicId() {
		return topicId;
	}
	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getContnt() {
		return contnt;
	}
	public void setContnt(String contnt) {
		this.contnt = contnt;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
}
