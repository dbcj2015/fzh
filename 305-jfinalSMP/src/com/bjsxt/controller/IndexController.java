package com.bjsxt.controller;

import com.jfinal.core.Controller;

public class IndexController extends Controller{
	//JFinal默认进入页面的是从index.html页面进入所以必须显示重定向
	//默认执行的方法 ，默认就访问/index
	public void index(){
		this.redirect("/index.html");
	}
}
