package com.bjsxt.entry;

public class Sign {
	private String sintime;
	private String sinstatus;
	private String souttime;
	private String soutstatus;
	private String sdate;
	private int unumber;
	public Sign() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Sign(String sintime, String sinstatus, String souttime,
			String soutstatus, String sdate, int unumber) {
		super();
		this.sintime = sintime;
		this.sinstatus = sinstatus;
		this.souttime = souttime;
		this.soutstatus = soutstatus;
		this.sdate = sdate;
		this.unumber = unumber;
	}
	public String getSintime() {
		return sintime;
	}
	public void setSintime(String sintime) {
		this.sintime = sintime;
	}
	public String getSinstatus() {
		return sinstatus;
	}
	public void setSinstatus(String sinstatus) {
		this.sinstatus = sinstatus;
	}
	public String getSouttime() {
		return souttime;
	}
	public void setSouttime(String souttime) {
		this.souttime = souttime;
	}
	public String getSoutstatus() {
		return soutstatus;
	}
	public void setSoutstatus(String soutstatus) {
		this.soutstatus = soutstatus;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	public int getUnumber() {
		return unumber;
	}
	public void setUnumber(int unumber) {
		this.unumber = unumber;
	}
	@Override
	public String toString() {
		return "Sign [sintime=" + sintime + ", sinstatus=" + sinstatus
				+ ", souttime=" + souttime + ", soutstatus=" + soutstatus
				+ ", sdate=" + sdate + ", unumber=" + unumber + "]";
	}
	
}
