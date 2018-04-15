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
		//��MyBaits�Զ����ɵ�DAOʵ����,bean Id��ѭ�Ĺ����� �ӿ���EmpDAO,����ĸСд����Bean Id
		EmpDao dao = (EmpDao)acx.getBean("empDao");
		System.out.println(new Gson().toJson(dao.findAll()));
	}
	
	
}
