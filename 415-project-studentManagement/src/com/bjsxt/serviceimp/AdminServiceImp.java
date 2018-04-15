package com.bjsxt.serviceimp;

import java.util.ArrayList;

import com.bjsxt.dao.AdminDao;
import com.bjsxt.daoimp.AdminDaoImp;
import com.bjsxt.entry.Role;
import com.bjsxt.service.AdminService;

public class AdminServiceImp implements AdminService{
	AdminDao ad=new AdminDaoImp();
	@Override
	public ArrayList<Role> selectRoleInfoService() {
		
		return ad.selectRoleInfo();
	}

}
