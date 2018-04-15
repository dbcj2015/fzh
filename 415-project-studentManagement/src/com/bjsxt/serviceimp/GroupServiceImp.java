package com.bjsxt.serviceimp;

import java.util.ArrayList;

import com.bjsxt.dao.GroupDao;
import com.bjsxt.daoimp.GroupDaoImp;
import com.bjsxt.entry.Sign;
import com.bjsxt.entry.User;
import com.bjsxt.service.GroupService;

public class GroupServiceImp implements GroupService {
	
	GroupDao gd=new GroupDaoImp();
	//获取所有组员信息
	@Override
	public ArrayList<User> getGroupInfoService(int unumber) {
		
		return gd.getGroupInfo(unumber);
	}
	//获取组员签到签退信息
	@Override
	public ArrayList<Sign> getUserSignInfoService(String unumber,String page) {
		
		return gd.getUserSignInfo(unumber,page);
	}
	//获取某个成员的签退签到的信息总数
	@Override
	public int getSignCountService(String unumber) {
		return gd.getSignCount(unumber);
	}
	



}
