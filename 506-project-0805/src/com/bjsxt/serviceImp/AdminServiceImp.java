package com.bjsxt.serviceImp;

import java.util.ArrayList;

import com.bjsxt.dao.AdminDao;
import com.bjsxt.daoImp.AdminDaoImp;
import com.bjsxt.entry.Role;
import com.bjsxt.service.AdminService;

public class AdminServiceImp implements AdminService{
	//����dao�����
	AdminDao ad=new AdminDaoImp();
	//��ȡ���еĽ�ɫ��Ϣ
	@Override
	public ArrayList<Role> getRoleInfoService() {
		return ad.getRoleInfo();
	}
	//�����û���Ϣ
	@Override
	public int updateUserInfoService(String unumber, String rid, String pnumber) {
		return ad.updateUserInfo(unumber,rid,pnumber);
	}
	//ɾ���û���Ϣ
	@Override
	public int deleteUserInfoService(String unumber) {
		return ad.deleteUserInfo(unumber);
	}
	//���û����ݲ��뵽���ݿ���
	@Override
	public int insertUserInfoService(String[] udata) {
		
		return ad.insertUserInfo(udata);
	}

}
