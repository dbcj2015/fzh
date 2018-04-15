package com.bjsxt.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ExamService {
	
	public void commitExam(){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("发起的交卷请求");
	}
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicateContent.xml");
		ExamService exam = (ExamService)ctx.getBean("exam");
		exam.commitExam();
		EvalService eval = (EvalService)ctx.getBean("eval");
		eval.startEval(0);
	}
}
