package com.bjsxt.smpSpring;

public class EmpDAO implements IEmpDAO{
	
	public EmpDAO(){
		System.out.println("正在创建EmpDAO对象,HashCode::" + this.hashCode());
	}
	public void insert(){
		System.out.println("EmpDAO.insert() MyBatis实现");
	}
}
