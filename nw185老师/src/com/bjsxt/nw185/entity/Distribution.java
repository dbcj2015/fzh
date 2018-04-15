package com.bjsxt.nw185.entity;
import java.util.Date;
import java.io.Serializable;

public class Distribution implements  Serializable{
	
	private Integer distId;
	private Integer fromBranchId;
	private Integer toBranchId;
	private Date distTime;
	private Integer state;


	public Integer getDistId() {
		return distId;
	}

	public void setDistId(Integer distId) {
		this.distId = distId;
	}	
	public Integer getFromBranchId() {
		return fromBranchId;
	}

	public void setFromBranchId(Integer fromBranchId) {
		this.fromBranchId = fromBranchId;
	}	
	public Integer getToBranchId() {
		return toBranchId;
	}

	public void setToBranchId(Integer toBranchId) {
		this.toBranchId = toBranchId;
	}	
	public Date getDistTime() {
		return distTime;
	}

	public void setDistTime(Date distTime) {
		this.distTime = distTime;
	}	
	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}	
	
}
