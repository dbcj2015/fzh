package com.bjsxt.nw185.entity;
import java.util.Date;
import java.io.Serializable;

public class Project implements  Serializable{
	
	private Integer projectId;
	private String projectName;
	private Integer year;


	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}	
	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}	
	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}	
	
}
