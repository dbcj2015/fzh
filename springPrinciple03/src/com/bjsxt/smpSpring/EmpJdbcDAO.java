package com.bjsxt.smpSpring;

public class EmpJdbcDAO implements IEmpDAO{
	
	public EmpJdbcDAO(){
		System.out.println("���ڴ���EmpJdbcDAO����,HashCode:" + this.hashCode());
	}
	
	public void insert(){
		System.out.println("EmpDAO.insert() JDBCʵ��");
	}
}
