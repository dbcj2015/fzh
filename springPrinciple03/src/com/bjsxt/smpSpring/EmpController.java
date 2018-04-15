package com.bjsxt.smpSpring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
@SuppressWarnings("all")
public class EmpController {
	public EmpController(){
		System.out.println("正在创建EmpController对象,HashCode:" + this.hashCode());
	}
	private EmpService eservice = null;
	public void regiestEmp(){
		System.out.println("EmpController.regiestEmp()");
		eservice.regiest();
	}
	
	public EmpService getEservice() {
		return eservice;
	}

	public void setEservice(EmpService es) {
		System.out.println("正在利用setEservice方法为EmpController.eservice属性赋值,参数es对象HashCode:" + es.hashCode());
		this.eservice = es;
	}

	public static void main(String[] args) {
		//对配置文件进行初始化
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		//getBean(参数:IOC容器中存储的对象值对应的键值，也就是配置文件中id属性值)
		EmpController c  = (EmpController)ctx.getBean("empControllerObj");
		c.regiestEmp();
	}
}
