package com.bjsxt.entry;

public class User {
	private int unumber;
	private String uname;
	private String upwd;
	private String usex;
	private int uage;
	private String uaddress;
	private int rid;
	private int pnumber;
	private String rname;
	private String pname;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int unumber, String uname, String upwd, String usex, int uage,
			String uaddress, int rid, int pnumber, String rname, String pname) {
		super();
		this.unumber = unumber;
		this.uname = uname;
		this.upwd = upwd;
		this.usex = usex;
		this.uage = uage;
		this.uaddress = uaddress;
		this.rid = rid;
		this.pnumber = pnumber;
		this.rname = rname;
		this.pname = pname;
	}
	public int getUnumber() {
		return unumber;
	}
	public void setUnumber(int unumber) {
		this.unumber = unumber;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	public String getUsex() {
		return usex;
	}
	public void setUsex(String usex) {
		this.usex = usex;
	}
	public int getUage() {
		return uage;
	}
	public void setUage(int uage) {
		this.uage = uage;
	}
	public String getUaddress() {
		return uaddress;
	}
	public void setUaddress(String uaddress) {
		this.uaddress = uaddress;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public int getPnumber() {
		return pnumber;
	}
	public void setPnumber(int pnumber) {
		this.pnumber = pnumber;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	@Override
	public String toString() {
		return "User [unumber=" + unumber + ", uname=" + uname + ", upwd="
				+ upwd + ", usex=" + usex + ", uage=" + uage + ", uaddress="
				+ uaddress + ", rid=" + rid + ", pnumber=" + pnumber
				+ ", rname=" + rname + ", pname=" + pname + "]";
	}
	
}
