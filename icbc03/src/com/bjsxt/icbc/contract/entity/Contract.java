package com.bjsxt.icbc.contract.entity;
import java.util.Date;
import java.io.Serializable;

public class Contract implements  Serializable{
	
	private Integer contractId;
	private Date contractDate;
	private Integer contractCode;
	private Integer venderId;
	private Integer projectId;
	private String title;
	private String docFile;
	private Integer state;
	private Integer createUser;
	private Date createTime;
	private Date updateTime;
	private Integer updateUser;


	public Integer getContractId() {
		return contractId;
	}

	public void setContractId(Integer contractId) {
		this.contractId = contractId;
	}	
	public Date getContractDate() {
		return contractDate;
	}

	public void setContractDate(Date contractDate) {
		this.contractDate = contractDate;
	}	
	public Integer getContractCode() {
		return contractCode;
	}

	public void setContractCode(Integer contractCode) {
		this.contractCode = contractCode;
	}	
	public Integer getVenderId() {
		return venderId;
	}

	public void setVenderId(Integer venderId) {
		this.venderId = venderId;
	}	
	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}	
	public String getDocFile() {
		return docFile;
	}

	public void setDocFile(String docFile) {
		this.docFile = docFile;
	}	
	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}	
	public Integer getCreateUser() {
		return createUser;
	}

	public void setCreateUser(Integer createUser) {
		this.createUser = createUser;
	}	
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}	
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}	
	public Integer getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(Integer updateUser) {
		this.updateUser = updateUser;
	}	
	
}
