package com.bjsxt.jfinal;

import com.bjsxt.jfinal.controller.HelloController;
import com.bjsxt.jfinal.entity.Emp;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.ext.interceptor.SessionInViewInterceptor;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.render.ViewType;

public class Config extends JFinalConfig{
	//配置JFINAL全局设置的地方
	@Override
	public void configConstant(Constants me) {
		// TODO Auto-generated method stub
		me.setDevMode(true);//打开开发者模式,在控制台中拥有更多调试信息
		me.setViewType(ViewType.FREE_MARKER);
		me.setBaseViewPath("/WEB-INF/ftl");//这是默认的freemarker前缀路径
		me.setBaseUploadPath("c:/uploaded");//设置临时上传目录
	}
	
	//配置Controller的地方
	@Override
	public void configRoute(Routes me) {
		// TODO Auto-generated method stub
		//将hello映射到/h的路径上
		//访问规则是 /h/方法名
		me.add("/h", HelloController.class);
	}
	//配置数据库的地方
	@Override
	public void configPlugin(Plugins me) {
		// TODO Auto-generated method stub
		//配置JFINAL默认的数据源C3P0
		C3p0Plugin c3p0 = new C3p0Plugin("jdbc:mysql://localhost:3306/easyui?useUnicode=true&characterEncoding=UTF-8", "root", "");
		//开启ActiveRecord 数据库模式
		ActiveRecordPlugin arp = new ActiveRecordPlugin(c3p0);
		//将这两个插件通知JFINAL 加载
		me.add(c3p0);
		me.add(arp);
		//将Model与表绑定
		//参数顺序: 表名,主键字段名,模型类
		arp.addMapping("emp","empno" , Emp.class);
		
	}
	//配置拦截器
	@Override
	public void configInterceptor(Interceptors me) {
		// TODO Auto-generated method stub
		me.add(new SessionInViewInterceptor());
	}
	//其他
	@Override
	public void configHandler(Handlers me) {
		// TODO Auto-generated method stub
		
	}

}
