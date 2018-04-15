package com.bjsxt.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

//对于Spring切面类,唯一的要求是:
//在实现插件代码的时候,方法的格式必须为 public Object XXX(ProceedingJoinPoint pjp) throws Throwable{
public class TimePlugin {
	//定义了一个插件方法,格式为 public Object ....(ProceedingJoinPoint pjp) throws Throwable{
	//ProceedingJoinPoint pjp称为连接点,用于获取要执行的类的方法及对象的信息
	//方法名不固定
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("TimerPlugin插件已生效");
		Object target = pjp.getTarget();//获取要执行的对象的信息
		Object obj = pjp.proceed();//执行目标方法
		return obj;
	}
}
