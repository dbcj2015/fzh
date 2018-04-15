package com.bjsxt.aspect;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class TimePlugin {
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("TimerPlugin插件已生效");
		Object target = pjp.getTarget();//获取要执行的对象的信息
		String methodName = pjp.getSignature().getName();
		System.out.println(methodName);
		Object obj = pjp.proceed();
		System.out.println(obj);
		return obj;
	}
	
	//前置通知
		public void doBefore(JoinPoint jp){
			System.out.println("前置通知");
		}
		
		//前置通知
		public void doAfter(JoinPoint jp){
			System.out.println("后置通知");
		}
		//通过around通知实现所有功能
		public Object doAroundAdvice(ProceedingJoinPoint pjp) throws Throwable{
			try{
				System.out.println("前置通知");
				
				Object ret = pjp.proceed();
				
				System.out.println("目标方法返回值:"  + ret);
				return ret;
			}catch(Throwable t){
				System.out.println("内部类产生异常:"  + t.getMessage());
				throw t;
			}finally{
				//后置通知是一定要执行的
				System.out.println("后置通知");
			}
			
		}
}
