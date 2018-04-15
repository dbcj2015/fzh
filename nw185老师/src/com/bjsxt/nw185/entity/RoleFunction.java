package com.bjsxt.nw185.entity;
import java.util.Date;
import java.io.Serializable;

public class RoleFunction implements  Serializable{
	
	private Integer rfId;
	private Integer roleId;
	private Integer functionId;


	public Integer getRfId() {
		return rfId;
	}

	public void setRfId(Integer rfId) {
		this.rfId = rfId;
	}	
	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}	
	public Integer getFunctionId() {
		return functionId;
	}

	public void setFunctionId(Integer functionId) {
		this.functionId = functionId;
	}	
	
}
