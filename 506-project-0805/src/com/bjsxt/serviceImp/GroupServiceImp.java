package com.bjsxt.serviceImp;

import java.util.ArrayList;

import com.bjsxt.dao.GroupDao;
import com.bjsxt.daoImp.GroupDaoImp;
import com.bjsxt.entry.Sign;
import com.bjsxt.entry.User;
import com.bjsxt.service.GroupService;

public class GroupServiceImp implements GroupService{
	//创建dao层对象
	GroupDao gd=new GroupDaoImp();
	//获取小组信息
	@Override
	public ArrayList<User> getGroupInfoService(int unumber) {
		return gd.getGroupInfo(unumber);
	}
	//获取组员签到签退信息
	@Override
	public ArrayList<Sign> getSignInfoService(String unumber,String page) {
		// TODO Auto-generated method stub
		return gd.getSignInfo(unumber,page);
	}
	//获取用户签到签退总条数
	@Override
	public int getCountInfoService(String unumber) {
		// TODO Auto-generated method stub
		return gd.getCountInfo(unumber);
	}

}
