package com.bjsxt.service;

import java.util.ArrayList;

import com.bjsxt.entry.Role;

public interface AdminService {
	//获取所有角色信息

	ArrayList<Role> selectRoleInfoService();

}
