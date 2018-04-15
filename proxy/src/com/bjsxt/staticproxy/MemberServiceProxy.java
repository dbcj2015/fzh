package com.bjsxt.staticproxy;

import java.util.Date;
import java.util.List;

public class MemberServiceProxy implements IMemberService{
	
	private IMemberService memberService=null;
	
	public MemberServiceProxy(IMemberService memberService){
		this.memberService=memberService;
	}
	@Override
	public List getOrders() {
		long st = new Date().getTime();
		List list = memberService.getOrders();
		long et = new Date().getTime();
		System.out.println("getOrders方法执行时间:" + (et-st) + "ms");
		return list;
	}

	@Override
	public void createOrder() {
		long st = new Date().getTime();
		memberService.createOrder();
		long et = new Date().getTime();
		System.out.println("createOrder方法执行时间:" + (et-st) + "ms");	
	}
	public static void main(String[] args) {
		IMemberService memberService = new MemberService();//实际消费者
		IMemberService proxy = new MemberServiceProxy(memberService); //增加代理类
		proxy.createOrder();
		proxy.getOrders();
	}
}
