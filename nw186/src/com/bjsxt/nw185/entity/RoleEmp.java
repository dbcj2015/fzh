package com.bjsxt.nw185.entity;
import java.util.Date;
import java.io.Serializable;

public class RoleEmp implements  Serializable{
	
	private Integer ruId;
	private Integer empId;
	private Integer roleId;


	public Integer getRuId() {
		return ruId;
	}

	public void setRuId(Integer ruId) {
		this.ruId = ruId;
	}	
	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}	
	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}	
	
}
