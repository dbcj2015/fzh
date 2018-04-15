package com.bjsxt.dao;

import java.util.ArrayList;

import com.bjsxt.entry.Role;

public interface AdminDao {
	//获取所有的角色信息
	ArrayList<Role> getRoleInfo();
	//更新用户信息
	int updateUserInfo(String unumber, String rid, String pnumber);
	//删除用户信息
	int deleteUserInfo(String unumber);
	//将用户数据插入到数据库中
	int insertUserInfo(String[] udata);

}
