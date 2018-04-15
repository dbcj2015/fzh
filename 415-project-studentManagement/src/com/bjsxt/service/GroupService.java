package com.bjsxt.service;

import java.util.ArrayList;

import com.bjsxt.entry.Sign;
import com.bjsxt.entry.User;

public interface GroupService {
	//获取所有组员信息
	ArrayList<User> getGroupInfoService(int unumber);
	//获取用户签到签退信息
	ArrayList<Sign> getUserSignInfoService(String unumber,String page);
	//获取某个成员的签退签到的信息总数
	int getSignCountService(String unumber);


}
