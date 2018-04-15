package com.bjsxt.tmallspring;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CashierService {
	public void pay(List<Goods> carts){
	
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		
		
		Discount dis = (Discount)ctx.getBean("objKey");
		System.out.println("Discount实现类为" + dis.toString() + " , HashCode:" + dis.hashCode());
		float total = dis.discount(carts);
		System.out.println("正在向支付宝发起支付请求,本次支付:" + total);	
	}
	
	public static void main(String[] args) {
		List carts = new ArrayList();//carts购物车
		carts.add(new Goods("手机" , "小米" , "小米5X" , 1499f , 1));
		carts.add(new Goods("膨化食品" , "旺旺" , "旺旺雪饼" , 10f , 5));
		carts.add(new Goods("服装" , "阿迪王" , "YMS-752" , 88f , 2));
		
		new CashierService().pay(carts);
	}
}
