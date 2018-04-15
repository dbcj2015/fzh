package com.bjsxt.serviceImp;

import java.util.ArrayList;

import com.bjsxt.dao.AdminDao;
import com.bjsxt.daoImp.AdminDaoImp;
import com.bjsxt.entry.Role;
import com.bjsxt.service.AdminService;

public class AdminServiceImp implements AdminService{
	//创建dao层对象
	AdminDao ad=new AdminDaoImp();
	//获取所有的角色信息
	@Override
	public ArrayList<Role> getRoleInfoService() {
		return ad.getRoleInfo();
	}
	//更新用户信息
	@Override
	public int updateUserInfoService(String unumber, String rid, String pnumber) {
		return ad.updateUserInfo(unumber,rid,pnumber);
	}
	//删除用户信息
	@Override
	public int deleteUserInfoService(String unumber) {
		return ad.deleteUserInfo(unumber);
	}
	//将用户数据插入到数据库中
	@Override
	public int insertUserInfoService(String[] udata) {
		
		return ad.insertUserInfo(udata);
	}

}
