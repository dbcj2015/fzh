package com.bjsxt.jfinal;

import com.bjsxt.model.Department;
import com.bjsxt.model.Employee;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;

import controller.RegisterController;

public class JFConfig extends JFinalConfig{

	@Override
	public void configConstant(Constants me) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configRoute(Routes me) {
		me.add("/register", RegisterController.class);
		
	}

	@Override
	// TODO Auto-generated method stub
			//C3P0是一款数据库连接池软件。所谓的池的概念是预加载
			//数据库连接池的产品 C3P0 ， Apache DBCP ， AliBABA Driud
	public void configPlugin(Plugins me) {
		C3p0Plugin c3p0 = new C3p0Plugin("jdbc:mysql://127.0.0.1:3306/icbc?useUnicode=true&characterEncoding=UTF-8", "root", "root");
		c3p0.setMinPoolSize(30);
		//ActiveRecordPlugin是JFINAL对数据库操作的核心类，增删改查都靠他了。
		ActiveRecordPlugin arp = new ActiveRecordPlugin(c3p0);
		me.add(c3p0);
		me.add(arp);
		//增加映射是将实体类或者service与数据库连接起来
		arp.addMapping("t_department" ,  "dept_id" , Department.class);
		arp.addMapping("t_employee", "emp_id" , Employee.class);
	}

	@Override
	public void configInterceptor(Interceptors me) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configHandler(Handlers me) {
		// TODO Auto-generated method stub
		
	}
	
}
