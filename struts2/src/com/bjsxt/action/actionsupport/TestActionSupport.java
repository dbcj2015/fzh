package com.bjsxt.action.actionsupport;

import com.opensymphony.xwork2.ActionSupport;

public class TestActionSupport extends ActionSupport{
	
	public String testDMI(){
		System.out.println("我是dmi1");
		return this.SUCCESS;
	}
	
	public String testDMI2(){
		System.out.println("我是dmi2");
		return this.SUCCESS;
	}
}
