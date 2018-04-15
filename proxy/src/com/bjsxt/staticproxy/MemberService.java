package com.bjsxt.staticproxy;

import java.util.ArrayList;
import java.util.List;

public class MemberService implements IMemberService{
	
	public List getOrders(){
		System.out.println("接收一个会员订单");
		return new ArrayList<>();
	}
	
	public void createOrder(){
		System.out.println("创建一个会员订单");
	}
}
