package com.bjsxt.nw185.entity;
import java.util.Date;
import java.io.Serializable;

public class Emp implements  Serializable{
	
	private Integer empId;
	private String empCode;
	private String name;
	private Integer branchId;


	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}	
	public String getEmpCode() {
		return empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	
	public Integer getBranchId() {
		return branchId;
	}

	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}	
	
}
