package com.bjsxt.serviceimp;

import java.util.ArrayList;

import com.bjsxt.dao.UserDao;
import com.bjsxt.daoimp.UserDaoImp;
import com.bjsxt.entry.User;
import com.bjsxt.service.UserService;

public class UserServiceImp implements UserService{
	UserDao ud=new UserDaoImp();
	@Override
	public User insertUserInfoService(String uname, String unumber) {
		// TODO Auto-generated method stub
		return ud.insertUserInfo(uname,unumber);
	}

}
