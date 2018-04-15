package com.bjsxt.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class EvalService {
	
	public String startEval(Integer teacherId){
		System.out.println("��������");
		return "eval-44354";
	}
	
	public List<Map> obtainEvalResult(String[] evalIds){
		long st=new Date().getTime();
		System.out.println("��ѯָ����������");
		long et=new Date().getTime();
		System.out.println("obtainEvalResult����ִ����:"+(et-st)+"����");
		return new ArrayList();
	}
	
	public static void main(String[] args) {
		ApplicationContext acx=new ClassPathXmlApplicationContext("classpath:applicateContent.xml");
		EvalService eval = (EvalService)acx.getBean("eval");
		eval.startEval(0);
		eval.obtainEvalResult(new String[]{});
	}
}
