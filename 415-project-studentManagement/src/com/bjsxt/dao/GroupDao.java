package com.bjsxt.dao;

import java.util.ArrayList;

import com.bjsxt.entry.Sign;
import com.bjsxt.entry.User;

public interface GroupDao {

	//获取所有组员信息
	ArrayList<User> getGroupInfo(int unumber);
	//获取组员签到签退信息
	ArrayList<Sign> getUserSignInfo(String unumber, String page);
	int getSignCount(String unumber);


}
