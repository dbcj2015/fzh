package com.bjsxt.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


import com.bjsxt.model.Department;
import com.jfinal.core.Controller;

public class DepartmentController extends Controller{
	public void create(){
		Department dept=new Department();
		List<Department> list = dept.find("select * from t_department");
		Department option=new Department();
		//数据库中插入数据
		option.set("dept_id", -1);
		option.set("dname", "请选择");
		list.add(0,option);
		this.renderJson(list);
		
	}
}
