package com.bjsxt.plugin;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;

public class LogPlugin {
	public Object doAcound(ProceedingJoinPoint pjp) throws Throwable{
		String method = pjp.getSignature().getName();//获取方法名
		String clzName = pjp.getTarget().getClass().getName();//获取类名
		System.out.println("准备执行:" + clzName + "." + method + "()");
		long st = new Date().getTime();
		Object obj = pjp.proceed();//执行目标方法
		long et = new Date().getTime();
		System.out.println("方法执行时间:" + (et - st) + "ms");
		return obj;
	}
}
