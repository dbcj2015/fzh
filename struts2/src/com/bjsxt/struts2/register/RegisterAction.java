package com.bjsxt.struts2.register;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class RegisterAction extends ActionSupport implements ModelDriven<Person>{
	private Person p = null;
	public String doReg(){
		System.out.println(p);
		return null;
	}
	@Override
	public Person getModel() {
		// TODO Auto-generated method stub
		p = new Person();
		return p;
	}
	
}
