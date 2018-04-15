package com.bjsxt.entity;

import com.opensymphony.xwork2.ActionSupport;

public class GetParameterTest extends ActionSupport{
	private Person person=null;
	public String TestEntity(){
		System.out.println("实体类得到的参数为:"+person.getAge());
		return this.SUCCESS;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	
}
