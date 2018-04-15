package com.bjsxt.tmallspring;

import java.util.List;

public class DiscountD11 implements Discount {

	@Override
	public Float discount(List<Goods> carts) {
		// TODO Auto-generated method stub
		System.out.println("天猫双11活动,全场服装类5折,膨化食品7折,包邮");
		Float total = 0f;
		for(Goods g : carts){
			if(g.getType().equals("服装")){
				total = total + g.getPrice() * g.getNum() * 0.5f;
			}else if(g.getType().equals("膨化食品")){
				total = total + g.getPrice() * g.getNum() * 0.7f;
			}else{
				total = total + g.getPrice() * g.getNum();
			}
		}
		return total;
	}

}
