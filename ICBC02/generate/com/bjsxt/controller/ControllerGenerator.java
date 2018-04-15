package com.bjsxt.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URLDecoder;

import com.bjsxt.profile.Profile;
import com.bjsxt.profile.ProfileUtils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;



public class ControllerGenerator {
	public File generateFile(String profile) throws IOException, TemplateException{
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_22);
		String ftlDir = new URLDecoder().decode(this.getClass().getResource("").getPath() , "UTF-8");
		cfg.setDirectoryForTemplateLoading(new File(ftlDir));
		cfg.setDefaultEncoding("UTF-8");
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
		Template temp = cfg.getTemplate("controller.ftl");
		Profile p = ProfileUtils.getProfile(profile);
		File dir = new File(p.getStringProperty("baseDir") +p.getStringProperty("sourceDir") + "/" + (p.getStringProperty("basePackage") + "." + p.getStringProperty("controller.package")).replace(".", "/"));
		if(!dir.exists()){
			dir.mkdirs();
		}
		File targetFile = new File(dir.getPath() + "/" + p.getStringProperty("controller.class") + ".java");
		FileWriter out1 = new FileWriter(targetFile);
		temp.process(p.getMetaData(), out1);
		return targetFile;
	}
	
	public static void main(String[] args) throws IOException, TemplateException {
		System.out.println(new ControllerGenerator().generateFile("goodstype"));
	}
}
