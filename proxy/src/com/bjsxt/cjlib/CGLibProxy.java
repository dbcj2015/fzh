package com.bjsxt.cjlib;

import java.lang.reflect.Method;
import java.util.Date;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
/**
 * 
 * Spring中,AOP核心的模式是"代理模式"
 * 其中,Spring对自动判断Bean是否实现了接口
 * 如果实现了接口,则Spring AOP自动使用JDK动态代理进行扩展
 * 如果没有实现接口,则自动使用CGLIB 通过 继承生成子类的方式实现扩展.
 * @author iqiyi
 *
 */
public class CGLibProxy implements MethodInterceptor{
	//通过动态生成"子类"的方式类实现对原有代码的扩展
	public Object getInstance(Object target){
		Enhancer enhancer = new Enhancer();//动态的代码生成类,"enhancer(增强)"
		enhancer.setSuperclass(target.getClass());//设置父类
		enhancer.setCallback(this);//设置子类,当前生成的对象
		return enhancer.create();//create()是在运行时动态创建target类的子类
	}
	/**
	 * 对方法的扩展行为进行处理
	 * Object 被代理类的对象(父类)
	 * method 要执行的方法对象
	 * args 方法的参数
	 * proxy 动态生成的子类(代理类)
	 * CGLIB不能对Final修饰的方法进行增强
	 */
	//对方法的扩展行为进行处理
	@Override
	public Object intercept(Object obj, Method method, Object[] args,
			MethodProxy proxy) throws Throwable {
		// TODO Auto-generated method stub
		//method对应的要执行的方法
		System.out.println("准备执行" + method.getName() + "()");
		long st = new Date().getTime();
		Object ret = proxy.invokeSuper(obj, args);//执行被代理类(父类)的方法,相当于super.xxxxx()
		long et = new Date().getTime();
		System.out.println();
		System.out.println( method.getName() + "方法执行时间:" + (et-st) + "ms");
		return ret;
	}
	
	public static void main(String[] args) {
		TestService testService = new TestService();
		TestService sts = (TestService)new CGLibProxy().getInstance(testService);
		sts.saySTH();//执行该方法时被intercept方法拦截,通过roxy.invokeSuper()方法跳转到目标类中执行对应的方法
	}
	
}
