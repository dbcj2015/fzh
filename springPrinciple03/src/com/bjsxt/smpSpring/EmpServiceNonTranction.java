package com.bjsxt.smpSpring;

public class EmpServiceNonTranction extends EmpService {

	private IEmpDAO dao = null;
	public EmpServiceNonTranction(){
		System.out.println("���ڴ���EmpServiceNonTranction����,HashCode:" + this.hashCode());
	}
	
	@Override
	public void regiest() {
		// TODO Auto-generated method stub
		System.out.println("����ִ��EmpServiceNonTranction.regiest()");
		dao.insert();
	}
	public IEmpDAO getDao() {
		return dao;
	}
	public void setDao(IEmpDAO dao) {
		System.out.println("��������setDao����ΪEmpServiceNonTranction.dao���Ը�ֵ,dao����HashCode:" + dao.hashCode());
		this.dao = dao;
	}
}
