package com.bjsxt.controller;


import java.text.SimpleDateFormat;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

public class WebInitConverter implements WebBindingInitializer{

	@Override
	public void initBinder(WebDataBinder wdb, WebRequest arg1) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		wdb.registerCustomEditor(java.util.Date.class, new CustomDateEditor(sdf, true));
		
	}

}
