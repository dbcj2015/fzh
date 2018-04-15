package com.bjsxt.entity;

import java.io.Serializable;
import java.util.Date;

public class News implements Serializable{
	private String title;
	private String content;
	private Date date;
	private String author;
	
	public News(String title, String content , String author, Date date) {
		super();
		this.title = title;
		this.content = content;
		this.date = date;
		this.author = author;
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
}
