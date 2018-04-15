package com.bjsxt.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LearningService {
	//实现拦截所有get,set方法
	private String url = "";
	public void learn(){
		System.out.println("学习时间");
		if(true){
			throw new RuntimeException("呵呵,故意哒");
		}
	}
	public String getUrl() {
		System.out.println("为URL赋值");
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public static void main(String[] args) {
		ApplicationContext acx=new ClassPathXmlApplicationContext("classpath:applicateContent.xml");
		LearningService learn =(LearningService) acx.getBean("learn");
//		learn.getUrl();
		learn.learn();
	}
}
