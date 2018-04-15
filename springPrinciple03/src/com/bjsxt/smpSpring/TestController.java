package com.bjsxt.smpSpring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestController {
	
	//��̬�������ݿ�����-������set()����
	private String driver;
	private String url;
	private String userName;
	private String password;
	
	
	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		System.out.println("����ʹ��set������ֵ");
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private EmpDAO dao=null;
	
	public TestController(EmpDAO emp){
		System.out.println("ͨ�����췽��������������"+emp.hashCode());
		this.dao=emp;
	}
	
	public void test(){
		dao.insert();
	}
	
	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		TestController tc = (TestController)ctx.getBean("testController");
		tc.test();
		System.out.println(tc.driver);
		System.out.println(tc.url);
		System.out.println(tc.password);
		
	}
}
