package com.bjsxt.entry;

public class Menu {
	private int mid;
	private String mname;
	private String murl;
	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Menu(int mid, String mname, String murl) {
		super();
		this.mid = mid;
		this.mname = mname;
		this.murl = murl;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMurl() {
		return murl;
	}
	public void setMurl(String murl) {
		this.murl = murl;
	}
	@Override
	public String toString() {
		return "Menu [mid=" + mid + ", mname=" + mname + ", murl=" + murl + "]";
	}
	
	
}
