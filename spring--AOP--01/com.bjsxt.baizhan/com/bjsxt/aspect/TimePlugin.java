package com.bjsxt.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

//����Spring������,Ψһ��Ҫ����:
//��ʵ�ֲ�������ʱ��,�����ĸ�ʽ����Ϊ public Object XXX(ProceedingJoinPoint pjp) throws Throwable{
public class TimePlugin {
	//������һ���������,��ʽΪ public Object ....(ProceedingJoinPoint pjp) throws Throwable{
	//ProceedingJoinPoint pjp��Ϊ���ӵ�,���ڻ�ȡҪִ�е���ķ������������Ϣ
	//���������̶�
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("TimerPlugin�������Ч");
		Object target = pjp.getTarget();//��ȡҪִ�еĶ������Ϣ
		Object obj = pjp.proceed();//ִ��Ŀ�귽��
		return obj;
	}
}
