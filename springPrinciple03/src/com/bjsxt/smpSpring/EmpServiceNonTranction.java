package com.bjsxt.smpSpring;

public class EmpServiceNonTranction extends EmpService {

	private IEmpDAO dao = null;
	public EmpServiceNonTranction(){
		System.out.println("正在创建EmpServiceNonTranction对象,HashCode:" + this.hashCode());
	}
	
	@Override
	public void regiest() {
		// TODO Auto-generated method stub
		System.out.println("正在执行EmpServiceNonTranction.regiest()");
		dao.insert();
	}
	public IEmpDAO getDao() {
		return dao;
	}
	public void setDao(IEmpDAO dao) {
		System.out.println("正在利用setDao方法为EmpServiceNonTranction.dao属性赋值,dao对象HashCode:" + dao.hashCode());
		this.dao = dao;
	}
}
