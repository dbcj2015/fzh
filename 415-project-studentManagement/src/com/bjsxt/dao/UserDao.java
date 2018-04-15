package com.bjsxt.dao;

import java.util.ArrayList;

import com.bjsxt.entry.Menu;
import com.bjsxt.entry.User;

public interface UserDao {
	User checkUserLoginInfo(String unumber,String upwd);

	ArrayList<Menu> getUserMenuInfo(int rid);
	//将签到信息插入到数据库中
	int insertInInfo(String unumber, String inTime, String inDate, String inStatus);
	//判断用户是否已经签到
	boolean checkSignInfo(String unumber, String inDate);

	int insertOutInfo(String unumber, String inTime, String inDate, String outStatus);
	//获取用户上级姓名以及用户角色信息
	String getRnameInfo(String rid);
	//获取上级姓名信息
	String getUnameInfo(String pnumber);

	int updateNewPwdInfo(String newPwd, int unumber);
}
