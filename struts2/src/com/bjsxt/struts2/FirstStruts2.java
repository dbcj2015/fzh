package com.bjsxt.struts2;

public class FirstStruts2 {
	public FirstStruts2(){
		System.out.println("创建对象成功");
	}
	private String name=null;
	public String firstStruts(){
		System.out.println("name="+name);
		return "success";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
