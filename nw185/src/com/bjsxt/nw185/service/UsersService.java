package com.bjsxt.nw185.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bjsxt.nw185.base.utils.SecurityUtils;
import com.bjsxt.nw185.dao.UsersDAO;
import com.bjsxt.nw185.service.exception.UserException;

@Service("usersService")
@Transactional(rollbackFor=Exception.class)
public class UsersService {
	@Resource(name="usersDAO")
	private UsersDAO usersDAO = null;
	
	/**
	 * 检查登录
	 * @return
	 * @throws UserException 
	 */
	public Map checkLogin(String username , String password) throws UserException{
		List<Map> list = usersDAO.find(username);
		if(list.size() == 0){
			throw new UserException("用户名不存在");
		}
		Map user = list.get(0); // 用户信息
		String md5Password = SecurityUtils.toMD5Hex(password, user.get("salt").toString());
		if(!md5Password.equals(user.get("password"))){ //匹配密码是否正确
			throw new UserException("用户名或密码错误");
		}
		
		if(!user.get("status").toString().equals("1")){
			throw new UserException("用户账户未启用");
		}
		
		return user;
	}
	
	public static void main(String[] args) throws UserException{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		UsersService us = (UsersService)ctx.getBean("usersService");
		us.checkLogin("qiyisoft", "123456");
	}
	
}
