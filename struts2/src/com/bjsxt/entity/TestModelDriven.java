package com.bjsxt.entity;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class TestModelDriven extends ActionSupport implements ModelDriven<Person>{
	
	private Person person=null;
	
	public String testModelDriven(){
		System.out.println("通过ModelDriven接收参数"+person.getName());
		return this.SUCCESS;
	}
	@Override
	public Person getModel() {
		person=new Person();
		return person;
	}

}
