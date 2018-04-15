package com.bjsxt.service;

import javax.annotation.Resource;



import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.bjsxt.dao.UserDAO;


@Service("userService")
public class UserService {
	@Resource(name="userDAO")
	private UserDAO udao = null;
	public void register(Integer empId , String username , String password){
		System.out.println("用户注册成功");
		udao.insert();
	}
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicateContent.xml");
		UserService userService = (UserService)ctx.getBean("userService");
		userService.register(10,"qiyisoft" , "123456");
	}
}
