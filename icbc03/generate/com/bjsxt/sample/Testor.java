package com.bjsxt.sample;

import java.io.IOException;


import com.bjsxt.controller.ControllerGenerator;
import com.bjsxt.entity.EntityGenerator;
import com.bjsxt.mapper.MapperGenerator;
import com.bjsxt.repository.RepositoryGenerator;
import com.bjsxt.service.ServiceGenerator;
import com.bjsxt.view.ViewGenerator;

import freemarker.template.TemplateException;

public class Testor {
	public static void main(String[] args) {
		String profile = "contract"; //这里写json的文件名就行了
		try {
			// 创建XML
			new MapperGenerator().generateFile(profile);
			// 创建实体类
			new EntityGenerator().generateFile(profile);
			//创建DAO
			new RepositoryGenerator().generateFile(profile);
			//创建Service
			new ServiceGenerator().generateFile(profile);
			//创建Controller
			new ControllerGenerator().generateFile(profile);
			//创建界面
			//new ViewGenerator().generateFile(profile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
