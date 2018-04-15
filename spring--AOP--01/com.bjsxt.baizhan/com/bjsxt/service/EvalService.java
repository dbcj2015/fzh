package com.bjsxt.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class EvalService {
	
	public String startEval(Integer teacherId){
		System.out.println("发起评测");
		return "eval-44354";
	}
	
	public List<Map> obtainEvalResult(String[] evalIds){
		long st=new Date().getTime();
		System.out.println("查询指定的评测结果");
		long et=new Date().getTime();
		System.out.println("obtainEvalResult方法执行了:"+(et-st)+"毫秒");
		return new ArrayList();
	}
	
	public static void main(String[] args) {
		ApplicationContext acx=new ClassPathXmlApplicationContext("classpath:applicateContent.xml");
		EvalService eval = (EvalService)acx.getBean("eval");
		eval.startEval(0);
		eval.obtainEvalResult(new String[]{});
	}
}
