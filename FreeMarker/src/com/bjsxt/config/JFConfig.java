package com.bjsxt.config;

import com.bjsxt.controller.JFController;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.ext.interceptor.SessionInViewInterceptor;
import com.jfinal.render.ViewType;

public class JFConfig extends JFinalConfig{
	//配置JFINAL全局设置的地方
	@Override
	public void configConstant(Constants me) {
			//设置开发者模式
		me.setDevMode(true);
			//设置开发视图类型--JFinal 支持 JSP、FreeMarker、Velocity 三种常用视图
		me.setViewType(ViewType.FREE_MARKER);
			//设置默认的freemarker前缀路径
		me.setBaseViewPath("/WEB-INF/ftl");
		
	}

	@Override
	public void configRoute(Routes me) {
			//add方法中第一个参数是命名空间
		me.add("/reg", JFController.class);
		
		
	}

	@Override
	public void configPlugin(Plugins me) {
		// TODO Auto-generated method stub
		
	}

	@Override
	//配置拦截器
	public void configInterceptor(Interceptors me) {
		//session对象中存储值得时候需要在拦截器中设置
		me.add(new SessionInViewInterceptor());
		
	}
	
	@Override
	public void configHandler(Handlers me) {
	
		
	}

}
