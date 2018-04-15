package com.bjsxt.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

import com.bjsxt.entity.Poem;
import com.bjsxt.entity.Suite;
import com.jfinal.core.Controller;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class SuiteController extends Controller{
	public void show(){
		Integer id=this.getParaToInt("id");
		Suite s = Suite.dao.findById(id);
		//将生成文件放在服务器本地的位置
		String path = this.getSession().getServletContext().getRealPath("/") + "/suites/" + id + ".html";
			
		try {
			//如果静态文件不存在,则先生成,如果存在则忽略这一步直接输出
			if(new File(path).exists()==false){
			Configuration config=new Configuration();
			//获取到保存在服务器本地的模板文件
			File file=new File(this.getSession().getServletContext().getRealPath("/")+"/WEB-INF/ftl");
			//设置模板目录
			config.setDirectoryForTemplateLoading(file);
			config.setDefaultEncoding("utf-8");
			//加载模板文件
			Template t = config.getTemplate("detail.ftl");
			Map dateModel=new HashMap();
			dateModel.put("suite", s);
			//利用io流将文件写入服务器本地文件中，但是文件数据内容为空
			OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(path),"UTF-8");
			//将dataModel中的数据吸入到poem.ftl模板中,保存到服务器中对应的文件里
			t.process(dateModel, out);
			};
			//请求派发到指定的静态页面
			this.renderJsp("/suites/" + id + ".html");
			} catch (TemplateException e) {
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
	}
	
}

