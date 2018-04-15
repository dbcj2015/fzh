package com.bjsxt.serviceImp;

import java.util.ArrayList;

import com.bjsxt.dao.UserDao;
import com.bjsxt.daoImp.UserDaoImp;
import com.bjsxt.entry.Menu;
import com.bjsxt.entry.User;
import com.bjsxt.service.UserService;

public class UserServiceImp implements UserService{
	//����Dao�����
		UserDao ud=new UserDaoImp();
	@Override
	public User checkLoginInfoService(String unumber, String pwd) {
		//ҵ���߼��ж�
		//����dao���������
		return ud.checkLoginInfo(unumber,pwd);
	}
	//��ѯ�û��˵���Ϣ
	@Override
	public ArrayList<Menu> getMenuInfoService(int rid) {
		return ud.getMenuInfo(rid);
	}
	//���û�ǩ����Ϣ���뵽���ݿ�
	@Override
	public int insertSignInInfoService(String unumber, String inTime,
			String indate,String inStatus) {
		return ud.insertSignInInfo(unumber,inTime,indate,inStatus);
	}
	//��ѯ�û��Ƿ�ǩ��
	@Override
	public boolean checkSignInInfoService(String unumber, String indate) {
		
		return ud.checkSignInInfo(unumber,indate);
	}
	//����ǩ����Ϣ
	@Override
	public int updateSignOutInfoService(String unumber, String outTime,
			String outdate,String outStatus) {
		return ud.updateSignOutInfo(unumber,outTime,outdate,outStatus);
	}
	//�����û�����
	@Override
	public int updateNewPwdInfoService(String newPwd, int unumber) {
		
		return ud.updateNewPwdInfo(newPwd,unumber);
	}
	//��ȡ��ɫ��
	@Override
	public String getRnameInfoService(String rid) {
		
		return ud.getRnameInfo(rid);
	}
	//��ȡ�鳤����
	@Override
	public String getUnameInfoService(String pnumber) {
		// TODO Auto-generated method stub
		return ud.getUnameInfo(pnumber);
	}

}
