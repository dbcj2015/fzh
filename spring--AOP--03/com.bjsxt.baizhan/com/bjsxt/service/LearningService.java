package com.bjsxt.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LearningService {
	//ʵ����������get,set����
	private String url = "";
	public void learn(){
		System.out.println("ѧϰʱ��");
		if(true){
			throw new RuntimeException("�Ǻ�,������");
		}
	}
	public String getUrl() {
		System.out.println("ΪURL��ֵ");
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
