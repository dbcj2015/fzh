package com.bjsxt.serviceImp;

import java.util.ArrayList;

import com.bjsxt.dao.ClazzDao;
import com.bjsxt.daoImp.ClazzDaoImp;
import com.bjsxt.entry.User;
import com.bjsxt.service.ClazzService;

public class ClazzServiceImp implements ClazzService{
	//创建dao层对象
	ClazzDao cd=new ClazzDaoImp();
	//获取所有的学生信息
	@Override
	public ArrayList<User> getClazzInfoService(String rid) {
		return cd.getClazzInfo(rid);
	}

}
