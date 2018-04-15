package com.bjsxt.serviceimp;

import java.util.ArrayList;

import com.bjsxt.dao.ClazzDao;
import com.bjsxt.daoimp.ClazzDaoImp;
import com.bjsxt.entry.User;
import com.bjsxt.service.ClazzService;

public class ClazzServiceImp implements ClazzService{
	ClazzDao cd=new ClazzDaoImp();
	@Override
	public ArrayList<User> getClazzInfoService(String rid) {
		
		return cd.getClazzInfo(rid);
	}

}
