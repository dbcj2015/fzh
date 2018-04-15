package com.bjsxt.serviceImp;

import java.util.ArrayList;

import com.bjsxt.dao.UserDao;
import com.bjsxt.daoImp.UserDaoImp;
import com.bjsxt.entry.Menu;
import com.bjsxt.entry.User;
import com.bjsxt.service.UserService;

public class UserServiceImp implements UserService{
	//创建Dao层对象
		UserDao ud=new UserDaoImp();
	@Override
	public User checkLoginInfoService(String unumber, String pwd) {
		//业务逻辑判断
		//调用dao层操作数据
		return ud.checkLoginInfo(unumber,pwd);
	}
	//查询用户菜单信息
	@Override
	public ArrayList<Menu> getMenuInfoService(int rid) {
		return ud.getMenuInfo(rid);
	}
	//将用户签到信息插入到数据库
	@Override
	public int insertSignInInfoService(String unumber, String inTime,
			String indate,String inStatus) {
		return ud.insertSignInInfo(unumber,inTime,indate,inStatus);
	}
	//查询用户是否签到
	@Override
	public boolean checkSignInInfoService(String unumber, String indate) {
		
		return ud.checkSignInInfo(unumber,indate);
	}
	//更新签退信息
	@Override
	public int updateSignOutInfoService(String unumber, String outTime,
			String outdate,String outStatus) {
		return ud.updateSignOutInfo(unumber,outTime,outdate,outStatus);
	}
	//更新用户密码
	@Override
	public int updateNewPwdInfoService(String newPwd, int unumber) {
		
		return ud.updateNewPwdInfo(newPwd,unumber);
	}
	//获取角色名
	@Override
	public String getRnameInfoService(String rid) {
		
		return ud.getRnameInfo(rid);
	}
	//获取组长姓名
	@Override
	public String getUnameInfoService(String pnumber) {
		// TODO Auto-generated method stub
		return ud.getUnameInfo(pnumber);
	}

}
