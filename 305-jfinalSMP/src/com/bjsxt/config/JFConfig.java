package com.bjsxt.config;

import com.bjsxt.controller.DepartmentController;
import com.bjsxt.controller.EmployeeController;
import com.bjsxt.controller.IndexController;
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

public class JFConfig extends JFinalConfig{

	@Override
	public void configConstant(Constants me) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configRoute(Routes me) {
		me.add("/emp", EmployeeController.class);
		me.add("/",IndexController.class);
		me.add("/dept",DepartmentController.class);
		
	}

	@Override
	public void configPlugin(Plugins me) {
		C3p0Plugin c3p0=new C3p0Plugin("jdbc:mysql://127.0.0.1:3306/icbc?useUnicode=true&characterEncoding=UTF-8", "root", "root");
		c3p0.setMinPoolSize(30);
		ActiveRecordPlugin arp=new ActiveRecordPlugin(c3p0);
		arp.addMapping("t_department", "dept_id",Department.class);
		arp.addMapping("t_employee", "emp_id",Employee.class);
		me.add(c3p0);
		me.add(arp);
		
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
