package com.bjsxt.rd.template.themes.sm.mapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URLDecoder;

import com.bjsxt.rd.template.themes.sm.base.Generator;
import com.bjsxt.rd.template.themes.sm.profile.Profile;
import com.bjsxt.rd.template.themes.sm.profile.ProfileUtils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

public class MapperGenerator extends Generator{
	public File generateFile(String profile) throws IOException, TemplateException{
		Profile p = ProfileUtils.getProfile(profile);
		File outputDir = new File(p.getStringProperty("baseDir") + "/" +p.getStringProperty("mapperDir"));
		String outputFileName = p.getStringProperty("model.mapperName");
		return this.generateFile(profile, "mapper.ftl", outputDir, outputFileName);
	}
	
	public static void main(String[] args) throws IOException, TemplateException {
		System.out.println(new MapperGenerator().generateFile("goodstype"));
	}
}
