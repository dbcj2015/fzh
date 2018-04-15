package com.bjsxt.service;

import java.util.ArrayList;

import com.bjsxt.entry.Sign;
import com.bjsxt.entry.User;

public interface GroupService {
	//获取小组信息
	ArrayList<User> getGroupInfoService(int unumber);
	//获取组员签到签退信息
	ArrayList<Sign> getSignInfoService(String unumber, String page);
	//获取用户签到签退总条数
	int getCountInfoService(String unumber);

}
