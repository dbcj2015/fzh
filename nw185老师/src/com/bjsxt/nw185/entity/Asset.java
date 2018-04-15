package com.bjsxt.nw185.entity;
import java.util.Date;
import java.io.Serializable;

public class Asset implements  Serializable{
	
	private Integer assetId;
	private Integer branchId;
	private Integer productId;
	private Object price;
	private Integer guarateeTerm;
	private Integer checkSeq;
	private Integer state;
	private Integer empId;
	private Date createTime;
	private Integer createEmp;
	private String sn;
	private Integer runState;
	public Integer getAssetId() {
		return assetId;
	}

	public void setAssetId(Integer assetId) {
		this.assetId = assetId;
	}	
	public Integer getBranchId() {
		return branchId;
	}

	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}	
	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}	
	public Object getPrice() {
		return price;
	}

	public void setPrice(Object price) {
		this.price = price;
	}	
	public Integer getGuarateeTerm() {
		return guarateeTerm;
	}

	public void setGuarateeTerm(Integer guarateeTerm) {
		this.guarateeTerm = guarateeTerm;
	}	
	public Integer getCheckSeq() {
		return checkSeq;
	}

	public void setCheckSeq(Integer checkSeq) {
		this.checkSeq = checkSeq;
	}	
	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}	
	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}	
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}	
	public Integer getCreateEmp() {
		return createEmp;
	}

	public void setCreateEmp(Integer createEmp) {
		this.createEmp = createEmp;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public Integer getRunState() {
		return runState;
	}

	public void setRunState(Integer runState) {
		this.runState = runState;
	}	
	
}
