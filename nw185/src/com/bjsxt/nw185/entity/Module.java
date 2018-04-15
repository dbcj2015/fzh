package com.bjsxt.nw185.entity;
import java.util.Date;
import java.io.Serializable;

public class Module implements  Serializable{
	
	private Integer moduleId;
	private String moduleName;
	private String icon;


	public Integer getModuleId() {
		return moduleId;
	}

	public void setModuleId(Integer moduleId) {
		this.moduleId = moduleId;
	}	
	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}	
	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}	
	
}
