package com.bjsxt.service;

import java.util.ArrayList;

import com.bjsxt.entry.Menu;
import com.bjsxt.entry.User;

public interface UserService {
	//用户登录
	User checkLoginInfoService(String unumber, String pwd);
	//查看用户对应的菜单信息
	ArrayList<Menu> getMenuInfoService(int rid);
	//插入用户签到信息
	int insertSignInInfoService(String unumber, String inTime, String indate, String inStatus);
	//查询用户是否签到
	boolean checkSignInInfoService(String unumber, String indate);
	//更新签退信息
	int updateSignOutInfoService(String unumber, String outTime, String outdate, String outStatus);
	//更新用户密码
	int updateNewPwdInfoService(String newPwd, int unumber);
	//获取角色名
	String getRnameInfoService(String rid);
	//获取上级姓名
	String getUnameInfoService(String pnumber);
	
}
