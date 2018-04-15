package com.bjsxt.aspect;

import java.util.Date;

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
		String methodName = pjp.getSignature().getName();//getSignature()获取要执行的方法,getName获取方法的名称
		//getSimpleName()可以获取到执行的对象名
		System.out.println("正在执行" + target.getClass().getSimpleName() +"."+ methodName +"的方法");
		System.out.println("正在执行" + target.getClass().getSimpleName()+"的方法");
		//以上代码可以获取到要执行的类，以及实现类的方法等信息
		//执行目标方法,Proceed方法的返回值代表目标方法执行后的Object
			long startTime = new Date().getTime();
		Object obj = pjp.proceed();//执行对应对象中的方法--可以控制对象中对应方法的执行，插件中如果没有proceed()方法，对应的类中的方法不会执行
			long endTime = new Date().getTime();
			//获取对象中某个方法执行需要的时间
			System.out.println(target.getClass().getSimpleName() +"."+ methodName + "执行时间为:" + (endTime-startTime) + "ms");
		//如果处理方法的声明是void的时候,则obj为null
		System.out.println("目标方法返回值:" + obj);//代表目标方法的返回值,通常我们将目标方法直接返回即可
		return obj;//插件方法中,一般情况下将目标方法的返回值直接return即可
		
	}
}
