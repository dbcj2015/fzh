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
		
	

		//用户登录
		public User checkUserInfo(String unumber,String upwd) {
			return ud.checkUserLoginInfo(unumber,upwd);
		}

	@Override
	public ArrayList<Menu> getUserMenuInfo(int rid) {
		
		return ud.getUserMenuInfo(rid);
	}
	//将签到信息插入到数据库中

	@Override
	public int insertInInfoService(String unumber, String inTime, String inDate,String inStatus) {
		
		return ud.insertInInfo(unumber,inTime,inDate,inStatus);
	}
	//判断用户是否签到
	@Override
	public boolean checkSignInfoService(String unumber, String inDate) {
		// TODO Auto-generated method stub
		return ud.checkSignInfo(unumber, inDate);
	}
	//将签退信息插入到数据库中
	@Override
	public int insertOutInfoService(String unumber, String inTime, String inDate,String outStatus) {
		
		return ud.insertOutInfo(unumber,inTime,inDate,outStatus);
	}

	@Override
	public String getRnameInfoService(String rid) {
		// TODO Auto-generated method stub
		return ud.getRnameInfo(rid);
	}
	//获取上级姓名信息
	@Override
	public String getUnameInfoService(String pnumber) {
		// TODO Auto-generated method stub
		return ud.getUnameInfo(pnumber);
	}
	//更新用户密码
	@Override
	public int updateNewPwdInfoService(String newPwd, int unumber) {
		return ud.updateNewPwdInfo(newPwd,unumber);
	}

	
	
	
}
