package com.bjsxt.serviceimp;

import java.util.ArrayList;

import com.bjsxt.dao.GroupDao;
import com.bjsxt.daoimp.GroupDaoImp;
import com.bjsxt.entry.Sign;
import com.bjsxt.entry.User;
import com.bjsxt.service.GroupService;

public class GroupServiceImp implements GroupService {
	
	GroupDao gd=new GroupDaoImp();
	//��ȡ������Ա��Ϣ
	@Override
	public ArrayList<User> getGroupInfoService(int unumber) {
		
		return gd.getGroupInfo(unumber);
	}
	//��ȡ��Աǩ��ǩ����Ϣ
	@Override
	public ArrayList<Sign> getUserSignInfoService(String unumber,String page) {
		
		return gd.getUserSignInfo(unumber,page);
	}
	//��ȡĳ����Ա��ǩ��ǩ������Ϣ����
	@Override
	public int getSignCountService(String unumber) {
		return gd.getSignCount(unumber);
	}
	



}
