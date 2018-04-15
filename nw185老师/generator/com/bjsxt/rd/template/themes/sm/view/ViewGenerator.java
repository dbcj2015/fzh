package com.bjsxt.rd.template.themes.sm.view;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URLDecoder;

import com.bjsxt.rd.template.themes.sm.profile.Profile;
import com.bjsxt.rd.template.themes.sm.profile.ProfileUtils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

public class ViewGenerator {
	public File generateFile(String profile) throws IOException, TemplateException{
		Profile p = ProfileUtils.getProfile(profile);
		if(p.getStringProperty("view.enable") != null && p.getStringProperty("view.enable").equals("false")){
			return null;
		}
		
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_22);
		String ftlDir = new URLDecoder().decode(this.getClass().getResource("").getPath() , "UTF-8");
		cfg.setDirectoryForTemplateLoading(new File(ftlDir));
		cfg.setDefaultEncoding("UTF-8");
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
		Template temp = cfg.getTemplate("view.ftl");
		File dir = new File(p.getStringProperty("baseDir") + p.getStringProperty("pageDir") + "/");
		if(!dir.exists()){
			dir.mkdirs();
		}
		File targetFile = new File(dir.getPath() + "/" + p.getStringProperty("view.page"));
		FileWriter out1 = new FileWriter(targetFile);
		temp.process(p.getMetaData(), out1);
		return targetFile;
	}
	
	public static void main(String[] args) throws IOException, TemplateException {
		System.out.println(new ViewGenerator().generateFile("emp"));
	}
}
