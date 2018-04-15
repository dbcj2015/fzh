package com.bjsxt.serviceimp;

import java.util.ArrayList;

import com.bjsxt.dao.UserDao;
import com.bjsxt.daoimp.UserDaoImp;
import com.bjsxt.entry.Menu;
import com.bjsxt.entry.User;
import com.bjsxt.fz.DBUtil;
import com.bjsxt.service.UserService;

public class UserServiceImp implements UserService{
	
		UserDao ud=new UserDaoImp();
		
	

		//�û���¼
		public User checkUserInfo(String unumber,String upwd) {
			return ud.checkUserLoginInfo(unumber,upwd);
		}

	@Override
	public ArrayList<Menu> getUserMenuInfo(int rid) {
		
		return ud.getUserMenuInfo(rid);
	}
	//��ǩ����Ϣ���뵽���ݿ���

	@Override
	public int insertInInfoService(String unumber, String inTime, String inDate,String inStatus) {
		
		return ud.insertInInfo(unumber,inTime,inDate,inStatus);
	}
	//�ж��û��Ƿ�ǩ��
	@Override
	public boolean checkSignInfoService(String unumber, String inDate) {
		// TODO Auto-generated method stub
		return ud.checkSignInfo(unumber, inDate);
	}
	//��ǩ����Ϣ���뵽���ݿ���
	@Override
	public int insertOutInfoService(String unumber, String inTime, String inDate,String outStatus) {
		
		return ud.insertOutInfo(unumber,inTime,inDate,outStatus);
	}

	@Override
	public String getRnameInfoService(String rid) {
		// TODO Auto-generated method stub
		return ud.getRnameInfo(rid);
	}
	//��ȡ�ϼ�������Ϣ
	@Override
	public String getUnameInfoService(String pnumber) {
		// TODO Auto-generated method stub
		return ud.getUnameInfo(pnumber);
	}
	//�����û�����
	@Override
	public int updateNewPwdInfoService(String newPwd, int unumber) {
		return ud.updateNewPwdInfo(newPwd,unumber);
	}

	
	
	
}
