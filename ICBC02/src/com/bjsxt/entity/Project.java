package com.bjsxt.entity;
import java.util.Date;
import java.io.Serializable;

public class Project implements  Serializable{
	
	private Integer projectId;
	private String projectNane;
	private Integer year;


	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}	
	public String getProjectNane() {
		return projectNane;
	}

	public void setProjectNane(String projectNane) {
		this.projectNane = projectNane;
	}	
	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}	
	
}
