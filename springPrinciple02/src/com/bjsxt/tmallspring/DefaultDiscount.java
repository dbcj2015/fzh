package com.bjsxt.tmallspring;

import java.util.List;

public class DefaultDiscount implements Discount {

	@Override
	public Float discount(List<Goods> carts) {
		// TODO Auto-generated method stub
		//默认没有活动时的政策
		System.out.println("默认折扣策略");
		Float total = 0f;
		for(Goods g : carts){
			total = total + g.getPrice() * g.getNum();
		}
		
		if(total < 88f){
			total = total + 10;//邮费
		}
		return total;
	}

}
