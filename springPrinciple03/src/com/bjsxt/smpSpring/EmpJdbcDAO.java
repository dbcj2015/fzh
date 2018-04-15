package com.bjsxt.smpSpring;

public class EmpJdbcDAO implements IEmpDAO{
	
	public EmpJdbcDAO(){
		System.out.println("正在创建EmpJdbcDAO对象,HashCode:" + this.hashCode());
	}
	
	public void insert(){
		System.out.println("EmpDAO.insert() JDBC实现");
	}
}
