package com.bjsxt.maven;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DBUtils {
	public DBUtils(){
		System.out.println("pring IOC���������ɹ�");
	}
	
	public void testDBUtilBySprintTest(String name){
		System.out.println("�ɹ�ͨ��Spring-test������DBUtils"+name);
	}
//	public static void main(String[] args) {
//		//��ʼ��IOC����--��������
//		ApplicationContext ac=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
//		ac.getBean("du");
//	}
}
