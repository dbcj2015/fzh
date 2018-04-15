package com.bjsxt.dao;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
public class EmpDaoImp {
	public static void main(String[] args) {
		ApplicationContext acx=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		//由MyBaits自动生成的DAO实现类,bean Id遵循的规则是 接口名EmpDAO,首字母小写就是Bean Id
		EmpDao dao = (EmpDao)acx.getBean("empDao");
		System.out.println(new Gson().toJson(dao.findAll()));
	}
	
	
}
