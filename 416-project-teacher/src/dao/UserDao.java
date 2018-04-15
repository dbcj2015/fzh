package com.bjsxt.dao;

import java.util.ArrayList;

import com.bjsxt.entry.Menu;
import com.bjsxt.entry.User;

public interface UserDao {

	User checkLoginInfo(String unumber, String pwd);
	//查询用户菜单信息
	ArrayList<Menu> getMenuInfo(int rid);
	//插入用户签到信息
	int insertSignInInfo(String unumber, String inTime, String indate, String inStatus);
	//查询用户是否签到
	boolean checkSignInInfo(String unumber, String indate);
	//更新签退信息
	int updateSignOutInfo(String unumber, String outTime, String outdate, String outStatus);
	//更新用户密码
	int updateNewPwdInfo(String newPwd, int unumber);
	//获取角色名
	String getRnameInfo(String rid);
	//获取上级姓名
	String getUnameInfo(String pnumber);

}
