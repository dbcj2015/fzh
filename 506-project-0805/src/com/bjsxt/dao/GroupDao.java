package com.bjsxt.dao;

import java.util.ArrayList;

import com.bjsxt.entry.Sign;
import com.bjsxt.entry.User;

public interface GroupDao {
	//获取小组信息
	ArrayList<User> getGroupInfo(int unumber);
	//获取组员签到签退信息
	ArrayList<Sign> getSignInfo(String unumber, String page);
	//获取用户签到签退总条数
	int getCountInfo(String unumber);

}
