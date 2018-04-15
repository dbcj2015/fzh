package com.bjsxt.plugin;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
@Component("logPlugin")//IOC容器加载
@Aspect//告诉Spring,我这个类是一个切面(插件)类
public class LogPlugin {
	
	//定义了一个切点,这个注解用在方法上,其方法的名字就是这个PointCut的ID
	@Pointcut("execution(* com.bjsxt..*.*(..))")
	public void execexp(){
		
	}
	
	//定义切点
	@Around("execexp()")
	public Object log(ProceedingJoinPoint pjp) throws Throwable{
		long st = new Date().getTime();
		Object ret = null;
		try{
			ret = pjp.proceed();
		}catch(Throwable t){
			throw t;
		}finally{
			long et = new Date().getTime();
			System.out.println(pjp.getTarget().getClass().getName() + "." + pjp.getSignature().getName() + "() 鎵ц:" + (et-st) + "ms");
		}
		return ret;
	}
	
	@Before("execexp()")
	public void doBefore(JoinPoint jp){
		//jp.getArgs()代表目标方法的参数
		System.out.println(new Gson().toJson(jp.getArgs()));
	}
}
