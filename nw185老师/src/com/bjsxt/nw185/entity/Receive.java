package com.bjsxt.nw185.entity;
import java.util.Date;
import java.io.Serializable;

public class Receive implements  Serializable{
	
	private Integer receiveId;
	private Integer distId;
	private Integer empId;
	private Date receiveTime;


	public Integer getReceiveId() {
		return receiveId;
	}

	public void setReceiveId(Integer receiveId) {
		this.receiveId = receiveId;
	}	
	public Integer getDistId() {
		return distId;
	}

	public void setDistId(Integer distId) {
		this.distId = distId;
	}	
	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}	
	public Date getReceiveTime() {
		return receiveTime;
	}

	public void setReceiveTime(Date receiveTime) {
		this.receiveTime = receiveTime;
	}	
	
}
