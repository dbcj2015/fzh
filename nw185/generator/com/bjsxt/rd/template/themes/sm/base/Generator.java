package com.bjsxt.rd.template.themes.sm.base;

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

public abstract class Generator {
	public File generateFile(String profile , String ftlFile , File outputDir , String outputFileName) throws IOException, TemplateException{
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_22);
		String ftlDir = new URLDecoder().decode(this.getClass().getResource("").getPath() , "UTF-8");
		cfg.setDirectoryForTemplateLoading(new File(ftlDir));
		cfg.setDefaultEncoding("UTF-8");
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
		Template temp = cfg.getTemplate(ftlFile);
		Profile p = ProfileUtils.getProfile(profile);
		if(!outputDir.exists()){
			outputDir.mkdirs();
		}
		File targetFile = new File(outputDir.getPath() + "/" + outputFileName);
		FileWriter out1 = new FileWriter(targetFile);
		temp.process(p.getMetaData(), out1);
		return targetFile;
	}
}
