package com.bjsxt.nw185.entity;
import java.util.Date;
import java.io.Serializable;

public class Branch implements  Serializable{
	
	private Integer branchId;
	private String branchName;
	private Integer parentId;
	private Integer branchNature;
	private Integer branchLevel;
	private String branchPath;
	private String address;
	private String phone;
	private String contact;


	public Integer getBranchId() {
		return branchId;
	}

	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}	
	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}	
	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}	
	public Integer getBranchNature() {
		return branchNature;
	}

	public void setBranchNature(Integer branchNature) {
		this.branchNature = branchNature;
	}	
	public Integer getBranchLevel() {
		return branchLevel;
	}

	public void setBranchLevel(Integer branchLevel) {
		this.branchLevel = branchLevel;
	}	
	public String getBranchPath() {
		return branchPath;
	}

	public void setBranchPath(String branchPath) {
		this.branchPath = branchPath;
	}	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}	
	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}	
	
}
