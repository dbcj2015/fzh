package com.bjsxt.service;

import java.util.ArrayList;

import com.bjsxt.entry.User;

public interface ClazzService {
	//获取所有的学生信息
	ArrayList<User> getClazzInfoService(String rid);

}
