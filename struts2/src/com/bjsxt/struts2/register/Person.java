package com.bjsxt.struts2.register;

import java.util.Date;
import java.util.List;

public class Person {
	private String name;
	private Integer age;
	private String idno;
	private Date birthday;
	private List fun;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getIdno() {
		return idno;
	}
	public void setIdno(String idno) {
		this.idno = idno;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public List getFun() {
		return fun;
	}
	public void setFun(List fun) {
		this.fun = fun;
	}
	
	
}
