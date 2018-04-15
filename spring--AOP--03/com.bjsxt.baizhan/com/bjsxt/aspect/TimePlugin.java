package com.bjsxt.aspect;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class TimePlugin {
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("TimerPlugin�������Ч");
		Object target = pjp.getTarget();//��ȡҪִ�еĶ������Ϣ
		String methodName = pjp.getSignature().getName();
		System.out.println(methodName);
		Object obj = pjp.proceed();
		System.out.println(obj);
		return obj;
	}
	
	//ǰ��֪ͨ
		public void doBefore(JoinPoint jp){
			System.out.println("ǰ��֪ͨ");
		}
		
		//ǰ��֪ͨ
		public void doAfter(JoinPoint jp){
			System.out.println("����֪ͨ");
		}
		//ͨ��around֪ͨʵ�����й���
		public Object doAroundAdvice(ProceedingJoinPoint pjp) throws Throwable{
			try{
				System.out.println("ǰ��֪ͨ");
				
				Object ret = pjp.proceed();
				
				System.out.println("Ŀ�귽������ֵ:"  + ret);
				return ret;
			}catch(Throwable t){
				System.out.println("�ڲ�������쳣:"  + t.getMessage());
				throw t;
			}finally{
				//����֪ͨ��һ��Ҫִ�е�
				System.out.println("����֪ͨ");
			}
			
		}
}
