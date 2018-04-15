package com.bjsxt.smpSpring;

public class EmpService {
	public EmpService(){
		System.out.println("正在创建EmpService对象,HashCode:" + this.hashCode());
	}
	
	private IEmpDAO dao  = null;
	
	public void regiest(){
		System.out.println("EmpService.regeist()");
		dao.insert();
	}

	public IEmpDAO getDao() {
		return dao;
	}

	public void setDao(IEmpDAO dao) {
		System.out.println("正在利用setDao方法为EmpService.dao属性赋值,dao对象HashCode:" + dao.hashCode());
		this.dao = dao;
	}
}
