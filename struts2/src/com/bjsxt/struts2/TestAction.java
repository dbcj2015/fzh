package com.bjsxt.struts2;

public class TestAction {
	private String name=null;
	public String action(){
		System.out.println("名字为:"+name);
		return "success";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
