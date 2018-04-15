package com.bjsxt.dao;

import java.util.ArrayList;

import com.bjsxt.entry.User;

public interface ClazzDao {
	//获取所有的学生信息
	ArrayList<User> getClazzInfo(String rid);

}
