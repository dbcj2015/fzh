package com.bjsxt.serviceImp;

import java.util.ArrayList;

import com.bjsxt.dao.ClazzDao;
import com.bjsxt.daoImp.ClazzDaoImp;
import com.bjsxt.entry.User;
import com.bjsxt.service.ClazzService;

public class ClazzServiceImp implements ClazzService{
	//����dao�����
	ClazzDao cd=new ClazzDaoImp();
	//��ȡ���е�ѧ����Ϣ
	@Override
	public ArrayList<User> getClazzInfoService(String rid) {
		return cd.getClazzInfo(rid);
	}

}
