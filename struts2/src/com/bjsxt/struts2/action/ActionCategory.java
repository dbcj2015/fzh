package com.bjsxt.struts2.action;

import com.opensymphony.xwork2.Action;

public class ActionCategory implements Action{
	
	public String toReg(){
		System.out.println("我是Action的实现action接口的定义方式");
		return this.SUCCESS;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
