package com.bjsxt.nw185.entity;
import java.util.Date;
import java.io.Serializable;

public class Fault implements  Serializable{
	
	private Integer faultId;
	private Integer assetId;
	private String faultDescription;
	private Date faultTime;
	private Integer venderId;
	private Date maintenanceTime;
	private String maintenanceDetail;
	private Object cost;
	private Integer faultState;
	private Integer operator;
	private Date operatorDate;


	public Integer getFaultId() {
		return faultId;
	}

	public void setFaultId(Integer faultId) {
		this.faultId = faultId;
	}	
	public Integer getAssetId() {
		return assetId;
	}

	public void setAssetId(Integer assetId) {
		this.assetId = assetId;
	}	
	public String getFaultDescription() {
		return faultDescription;
	}

	public void setFaultDescription(String faultDescription) {
		this.faultDescription = faultDescription;
	}	
	public Date getFaultTime() {
		return faultTime;
	}

	public void setFaultTime(Date faultTime) {
		this.faultTime = faultTime;
	}	
	public Integer getVenderId() {
		return venderId;
	}

	public void setVenderId(Integer venderId) {
		this.venderId = venderId;
	}	
	public Date getMaintenanceTime() {
		return maintenanceTime;
	}

	public void setMaintenanceTime(Date maintenanceTime) {
		this.maintenanceTime = maintenanceTime;
	}	
	public String getMaintenanceDetail() {
		return maintenanceDetail;
	}

	public void setMaintenanceDetail(String maintenanceDetail) {
		this.maintenanceDetail = maintenanceDetail;
	}	
	public Object getCost() {
		return cost;
	}

	public void setCost(Object cost) {
		this.cost = cost;
	}	
	public Integer getFaultState() {
		return faultState;
	}

	public void setFaultState(Integer faultState) {
		this.faultState = faultState;
	}	
	public Integer getOperator() {
		return operator;
	}

	public void setOperator(Integer operator) {
		this.operator = operator;
	}	
	public Date getOperatorDate() {
		return operatorDate;
	}

	public void setOperatorDate(Date operatorDate) {
		this.operatorDate = operatorDate;
	}	
	
}
