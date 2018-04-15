package com.bjsxt.login;

public class Select {
	private int areaid;
	private String areaname;
	private int parentid;
	private int arealevel;
	private int status;
	public Select(int areaid, String areaname, int parentid, int arealevel,
			int status) {
		super();
		this.areaid = areaid;
		this.areaname = areaname;
		this.parentid = parentid;
		this.arealevel = arealevel;
		this.status = status;
	}
	
	public Select(){
		
	}

	public int getAreaid() {
		return areaid;
	}

	public void setAreaid(int areaid) {
		this.areaid = areaid;
	}

	public String getAreaname() {
		return areaname;
	}

	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}

	public int getParentid() {
		return parentid;
	}

	public void setParentid(int parentid) {
		this.parentid = parentid;
	}

	public int getArealevel() {
		return arealevel;
	}

	public void setArealevel(int arealevel) {
		this.arealevel = arealevel;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Select [areaid=" + areaid + ", areaname=" + areaname
				+ ", parentid=" + parentid + ", arealevel=" + arealevel
				+ ", status=" + status + "]";
	}
	
	
}
