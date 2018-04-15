package com.bjsxt.dynaticproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Date;
import java.util.List;

public class JDKDynamicProxy implements InvocationHandler{
	
	private Object target=null;//被代理的类
	
	//创建消费类对象
	public Object getProxy(Object target){
		this.target=target;
		Object proxy=Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
		System.out.println("消费类对象创建完毕");
		return proxy;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		//method是指执行的目标方法
		System.out.println("准备执行"+method.getName());
		long st=new Date().getTime();
		Object ret = method.invoke(target, args);
		long et=new Date().getTime();
		System.out.println(method.getName()+"执行的时间为:"+(et-st));
		return ret;
	}
	public static void main(String[] args) {
		JDKDynamicProxy jdk=new JDKDynamicProxy();
		IMemberService iMemberService=(IMemberService)jdk.getProxy(new MemberService());
		iMemberService.createOrder();
	}
}
