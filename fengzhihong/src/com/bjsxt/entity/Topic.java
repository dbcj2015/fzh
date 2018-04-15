package com.bjsxt.entity;

import java.util.Date;

public class Topic {
	private int topicId;
	private String title;
	private String content;
	private String author;
	private String createDate;
	private int clickAmount;
	public int getTopicId() {
		return topicId;
	}
	public void setTopicId(int topicId) {
		this.topicId = topicId;
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
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		createDate = createDate;
	}
	public int getClickAmount() {
		return clickAmount;
	}
	public void setClickAmount(int clickAmount) {
		this.clickAmount = clickAmount;
	}
	
	
}
