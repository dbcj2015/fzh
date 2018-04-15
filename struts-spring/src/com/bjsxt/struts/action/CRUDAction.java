package com.bjsxt.struts.action;

//自定义拦截器:将每个方法执行的实现打印出来
public class CRUDAction {
	public String create(){
		System.out.println("CRUDAction.create()");
		return null;
	}
	public String findById(){
		System.out.println("CRUDAction.findById()");
		return null;
	}
	
	public String update(){
		System.out.println("CRUDAction.update()");
		return null;
	}
}
