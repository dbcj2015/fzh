package com.bjsxt.uploadserviceimp;

import java.util.ArrayList;

import com.bjsxt.entry.User;
import com.bjsxt.uploadService.UserService;
import com.bjsxt.uploaddao.UserDao;
import com.bjsxt.uploaddaoimp.UserDaoImp;

public class UserServiceImp implements UserService{
	UserDao ud=new UserDaoImp();
	@Override
	public ArrayList<User> selectUserInfoService() {
		// TODO Auto-generated method stub
		return ud.selectUserInfo();
	}

}
