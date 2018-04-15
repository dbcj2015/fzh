package com.bjsxt.nw185.entity;
import java.util.Date;
import java.io.Serializable;

public class Takeback implements  Serializable{
	
	private Integer takebackId;
	private Integer assetId;
	private String sn;
	private Date takebackTime;
	private Integer operator;
	private Date operatorTime;
	private Integer userId;


	public Integer getTakebackId() {
		return takebackId;
	}

	public void setTakebackId(Integer takebackId) {
		this.takebackId = takebackId;
	}	
	public Integer getAssetId() {
		return assetId;
	}

	public void setAssetId(Integer assetId) {
		this.assetId = assetId;
	}	
	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}	
	public Date getTakebackTime() {
		return takebackTime;
	}

	public void setTakebackTime(Date takebackTime) {
		this.takebackTime = takebackTime;
	}	
	public Integer getOperator() {
		return operator;
	}

	public void setOperator(Integer operator) {
		this.operator = operator;
	}	
	public Date getOperatorTime() {
		return operatorTime;
	}

	public void setOperatorTime(Date operatorTime) {
		this.operatorTime = operatorTime;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}	
	
}
