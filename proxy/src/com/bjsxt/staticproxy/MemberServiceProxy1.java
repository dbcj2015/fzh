package com.bjsxt.staticproxy;

import java.util.Date;
import java.util.List;

/**
 * 代理类
 * @author iqiyi
 * 代理模式的特点:
 * 1. 代理类与消费类实现相同的接口
 * 2. 代理类在内部持有消费类的对象
 * 3. 在执行方法的时候,对消费类里面的方法行为进行扩展
 */
//1. 代理类与消费类实现相同的接口
public class MemberServiceProxy1 implements IMemberService{
	// 2. 代理类在内部持有消费类的对象
	private IMemberService memberService= null;
	public MemberServiceProxy1(IMemberService memberService){
		this.memberService = memberService;
	}
	
	@Override
	public List getOrders() {
		// TODO Auto-generated method stub
		System.out.println("我是Proxy1");
		List list = memberService.getOrders();
		return list;
	}

	@Override
	public void createOrder() {
		// TODO Auto-generated method stub
		System.out.println("我是Proxy1");
		memberService.createOrder();
		
	}
	
	public static void main(String[] args) {
		new MemberServiceProxy1(new MemberServiceProxy(new MemberService())).createOrder();
	}
}
