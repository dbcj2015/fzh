package com.bjsxt.service;

import java.util.ArrayList;

import com.bjsxt.entry.Role;

public interface AdminService {
	//获取所有的角色信息
	ArrayList<Role> getRoleInfoService();
	//更新用户信息
	int updateUserInfoService(String unumber, String rid, String pnumber);
	//删除用户信息
	int deleteUserInfoService(String unumber);
	//将用户数据插入到数据库中
	int insertUserInfoService(String[] udata);

}
