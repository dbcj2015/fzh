package com.bjsxt.entry;

public class User {
	private int uid;
	private String name;
	private int pwd;
	private String realName;
	private String photoName;
	private String type;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int uid, String name, int pwd, String realName,
			String photoName, String type) {
		super();
		this.uid = uid;
		this.name = name;
		this.pwd = pwd;
		this.realName = realName;
		this.photoName = photoName;
		this.type = type;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPwd() {
		return pwd;
	}
	public void setPwd(int pwd) {
		this.pwd = pwd;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getPhotoName() {
		return photoName;
	}
	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", name=" + name + ", pwd=" + pwd
				+ ", realName=" + realName + ", photoName=" + photoName
				+ ", type=" + type + "]";
	}
	
}
