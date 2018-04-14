package crawler;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.template.Engine;
//JFinalConfig配置类
public class JFConfig extends JFinalConfig{
	//这是配置系统常量与默认参数的地方
	@Override
	public void configConstant(Constants me) {
		// TODO Auto-generated method stub
		//将上传文件保存到lol目录下
		me.setBaseUploadPath("lol");
		me.setDevMode(true);//启动开发者模式
		
	}
	//这是配置Controller
	@Override
	public void configRoute(Routes me) {
		// TODO Auto-generated method stub
		//注册Controller ,将Controller映射到/test命名空间上
		
	}
	
	//这是配置数据库的地方
	@Override
	public void configPlugin(Plugins me) {
		// TODO Auto-generated method stub
		//初始化连接池参数
		C3p0Plugin c3p0 = new C3p0Plugin("jdbc:mysql://localhost:3306/zhaopin?useUnicode=true&characterEncoding=UTF-8", "root", "");
		//ActiveRecordPlugin就是JFINAL操作数据库的核心类,它以Plugin(插件)的形式出现
		ActiveRecordPlugin arp= new ActiveRecordPlugin(c3p0);
		me.add(c3p0);//将插件注册到JFINAL中
		me.add(arp);

	}
	//这是配置拦截器的地方(基本不用)
	@Override
	public void configInterceptor(Interceptors me) {
		// TODO Auto-generated method stub
		
	}
	//这是配置扩展组件的地方(忘了他吧)
	@Override
	public void configHandler(Handlers me) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void configEngine(Engine me) {
		// TODO Auto-generated method stub
		
	}
}
