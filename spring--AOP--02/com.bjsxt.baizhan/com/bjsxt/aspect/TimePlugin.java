package com.bjsxt.aspect;

import java.util.Date;

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
		String methodName = pjp.getSignature().getName();//getSignature()��ȡҪִ�еķ���,getName��ȡ����������
		//getSimpleName()���Ի�ȡ��ִ�еĶ�����
		System.out.println("����ִ��" + target.getClass().getSimpleName() +"."+ methodName +"�ķ���");
		System.out.println("����ִ��" + target.getClass().getSimpleName()+"�ķ���");
		//���ϴ�����Ի�ȡ��Ҫִ�е��࣬�Լ�ʵ����ķ�������Ϣ
		//ִ��Ŀ�귽��,Proceed�����ķ���ֵ����Ŀ�귽��ִ�к��Object
			long startTime = new Date().getTime();
		Object obj = pjp.proceed();//ִ�ж�Ӧ�����еķ���--���Կ��ƶ����ж�Ӧ������ִ�У���������û��proceed()��������Ӧ�����еķ�������ִ��
			long endTime = new Date().getTime();
			//��ȡ������ĳ������ִ����Ҫ��ʱ��
			System.out.println(target.getClass().getSimpleName() +"."+ methodName + "ִ��ʱ��Ϊ:" + (endTime-startTime) + "ms");
		//�����������������void��ʱ��,��objΪnull
		System.out.println("Ŀ�귽������ֵ:" + obj);//����Ŀ�귽���ķ���ֵ,ͨ�����ǽ�Ŀ�귽��ֱ�ӷ��ؼ���
		return obj;//���������,һ������½�Ŀ�귽���ķ���ֱֵ��return����
		
	}
}
