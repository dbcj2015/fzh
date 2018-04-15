package com.bjsxt.nw185.entity;
import java.util.Date;
import java.io.Serializable;

public class Takeout implements  Serializable{
	
	private Integer takeoutId;
	private Integer assetId;
	private Integer userId;
	private String purpose;
	private Date takeoutTime;
	private Date takebackTime;
	private Integer operator;
	private Date operatorTime;
	private String sn;

	public Integer getTakeoutId() {
		return takeoutId;
	}

	public void setTakeoutId(Integer takeoutId) {
		this.takeoutId = takeoutId;
	}	
	public Integer getAssetId() {
		return assetId;
	}

	public void setAssetId(Integer assetId) {
		this.assetId = assetId;
	}	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}	
	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
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

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public Date getTakeoutTime() {
		return takeoutTime;
	}

	public void setTakeoutTime(Date takeoutTime) {
		this.takeoutTime = takeoutTime;
	}	
	
}
