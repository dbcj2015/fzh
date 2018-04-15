package com.bjsxt.interceptor;

import java.util.Date;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
/**
 * 拦截器需要继承自AbstractInterceptor,并实现其中的intercept()方法
 * @author iqiyi
 *
 */
public class LogInterceptor extends AbstractInterceptor{
	
	/**
	 * ActionInvocation ai 最终要执行的Action的实例
	 */
	@Override
	public String intercept(ActionInvocation ai) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(ai.getAction());//获取Action对象
		ai.getResult();//获取Action配置的Result结果
		String method = ai.getProxy().getMethod();//获取方法名
		String clzName = ai.getAction().getClass().getSimpleName();//获取类名
		System.out.println("准备执行:" + clzName + "." + method + "()");
		long st = new Date().getTime();
		String ret = ai.invoke();//执行目标Action的方法
		long et = new Date().getTime();
		System.out.println("方法执行时间:" + (et - st) + "ms");
		
		return ret;
	}

}
