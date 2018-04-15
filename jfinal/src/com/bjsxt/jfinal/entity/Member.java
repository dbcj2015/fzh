package com.bjsxt.jfinal.entity;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Member {
	private String name;
	private Integer level;
	private Date joinTime;
	private Float price;
	private Map others = new HashMap();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public Date getJoinTime() {
		return joinTime;
	}
	public void setJoinTime(Date joinTime) {
		this.joinTime = joinTime;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Map getOthers() {
		return others;
	}
	public void setOthers(Map others) {
		this.others = others;
	}
	
	
}
