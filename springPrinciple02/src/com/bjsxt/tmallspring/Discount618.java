package com.bjsxt.tmallspring;

import java.util.List;




public class Discount618 implements Discount {
	public Discount618(){
		System.out.println("正在创建Discount618对象,hashcode:" + this.hashCode());
	}
	@Override
	public Float discount(List<Goods> carts) {
		// TODO Auto-generated method stub
		System.out.println("天猫618活动,全场4折,包邮");
		Float total = 0f;
		for(Goods g : carts){
			total = total + g.getPrice() * g.getNum() * 0.4f;
		}
		return total;
	}

}
