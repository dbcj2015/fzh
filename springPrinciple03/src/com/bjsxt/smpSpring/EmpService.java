package com.bjsxt.smpSpring;

public class EmpService {
	public EmpService(){
		System.out.println("���ڴ���EmpService����,HashCode:" + this.hashCode());
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
		System.out.println("��������setDao����ΪEmpService.dao���Ը�ֵ,dao����HashCode:" + dao.hashCode());
		this.dao = dao;
	}
}
