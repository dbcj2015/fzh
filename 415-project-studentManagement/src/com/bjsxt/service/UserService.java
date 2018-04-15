package com.bjsxt.service;

import java.util.ArrayList;

import com.bjsxt.entry.Menu;
import com.bjsxt.entry.User;

public interface UserService {
	//用户登录
		User checkUserInfo(String unumber,String upwd);
	//查看用户角色信息
	ArrayList<Menu> getUserMenuInfo(int rid);
	//将签到信息插入到数据库中
	int insertInInfoService(String unumber, String inTime, String inDate, String inStatus);
	//判断用户是否已经签到
	boolean checkSignInfoService(String unumber, String inDate);
	//将签退信息插入到数据库中
	int insertOutInfoService(String unumber, String inTime, String inDate, String outStatus);
	//获取用户上级姓名以及用户角色
	String getRnameInfoService(String rid);
	String getUnameInfoService(String pnumber);
	//更新用户密码
	int updateNewPwdInfoService(String newPwd, int unumber);
	
}
