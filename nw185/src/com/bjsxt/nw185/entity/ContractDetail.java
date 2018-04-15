package com.bjsxt.nw185.entity;
import java.util.Date;
import java.io.Serializable;

public class ContractDetail implements  Serializable{
	
	private Integer cdId;
	private Integer contractId;
	private Integer productId;
	private Integer num;
	private Object price;
	private Integer guaranteeTerm;
	private Integer checkFrequency;
	private Object comment;
	private Integer createUser;
	private Date createTime;
	private Integer updateUser;
	private Date updateTime;
	private Integer isvalid;
	private Integer state;

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getCdId() {
		return cdId;
	}

	public void setCdId(Integer cdId) {
		this.cdId = cdId;
	}	
	public Integer getContractId() {
		return contractId;
	}

	public void setContractId(Integer contractId) {
		this.contractId = contractId;
	}	
	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}	
	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}	
	public Object getPrice() {
		return price;
	}

	public void setPrice(Object price) {
		this.price = price;
	}	
	public Integer getGuaranteeTerm() {
		return guaranteeTerm;
	}

	public void setGuaranteeTerm(Integer guaranteeTerm) {
		this.guaranteeTerm = guaranteeTerm;
	}	
	public Integer getCheckFrequency() {
		return checkFrequency;
	}

	public void setCheckFrequency(Integer checkFrequency) {
		this.checkFrequency = checkFrequency;
	}	
	public Object getComment() {
		return comment;
	}

	public void setComment(Object comment) {
		this.comment = comment;
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
	public Integer getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(Integer updateUser) {
		this.updateUser = updateUser;
	}	
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}	
	public Integer getIsvalid() {
		return isvalid;
	}

	public void setIsvalid(Integer isvalid) {
		this.isvalid = isvalid;
	}	
	
}
