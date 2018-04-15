package com.bjsxt.maven;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DBUtils {
	public DBUtils(){
		System.out.println("pring IOC容器创建成功");
	}
	
	public void testDBUtilBySprintTest(String name){
		System.out.println("成功通过Spring-test测试了DBUtils"+name);
	}
//	public static void main(String[] args) {
//		//初始化IOC容器--创建对象
//		ApplicationContext ac=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
//		ac.getBean("du");
//	}
}
