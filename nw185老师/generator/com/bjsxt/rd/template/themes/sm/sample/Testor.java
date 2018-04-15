package com.bjsxt.rd.template.themes.sm.sample;

import java.io.IOException;

import com.bjsxt.rd.template.themes.sm.controller.ControllerGenerator;
import com.bjsxt.rd.template.themes.sm.entity.EntityGenerator;
import com.bjsxt.rd.template.themes.sm.mapper.MapperGenerator;
import com.bjsxt.rd.template.themes.sm.repository.RepositoryGenerator;
import com.bjsxt.rd.template.themes.sm.service.ServiceGenerator;
import com.bjsxt.rd.template.themes.sm.view.ViewGenerator;

import freemarker.template.TemplateException;

public class Testor {
	public static void main(String[] args) {
		String profile = "project"; //这里写json的文件名就行了
		try {
			// 创建XML
			new MapperGenerator().generateFile(profile);
//			// 创建实体类
			new EntityGenerator().generateFile(profile);
//			//创建DAO
			new RepositoryGenerator().generateFile(profile);
//			//创建Service
			new ServiceGenerator().generateFile(profile);
//			//创建Controller
			new ControllerGenerator().generateFile(profile);
			//创建界面
			new ViewGenerator().generateFile(profile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
