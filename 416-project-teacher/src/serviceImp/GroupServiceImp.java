package com.bjsxt.serviceImp;

import java.util.ArrayList;

import com.bjsxt.dao.GroupDao;
import com.bjsxt.daoImp.GroupDaoImp;
import com.bjsxt.entry.Sign;
import com.bjsxt.entry.User;
import com.bjsxt.service.GroupService;

public class GroupServiceImp implements GroupService{
	//����dao�����
	GroupDao gd=new GroupDaoImp();
	//��ȡС����Ϣ
	@Override
	public ArrayList<User> getGroupInfoService(int unumber) {
		return gd.getGroupInfo(unumber);
	}
	//��ȡ��Աǩ��ǩ����Ϣ
	@Override
	public ArrayList<Sign> getSignInfoService(String unumber,String page) {
		// TODO Auto-generated method stub
		return gd.getSignInfo(unumber,page);
	}
	//��ȡ�û�ǩ��ǩ��������
	@Override
	public int getCountInfoService(String unumber) {
		// TODO Auto-generated method stub
		return gd.getCountInfo(unumber);
	}

}
