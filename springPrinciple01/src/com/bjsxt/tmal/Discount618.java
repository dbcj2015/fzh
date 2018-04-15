package com.bjsxt.tmal;

import java.util.List;

public class Discount618 implements Discount{
	
	Float total=0.0f;
	public Float discount(List<Goods> list){
		for(Goods good:list){
			total=total+good.getPrice()*good.getNum()*0.6f;
		}
		System.out.println("天猫618活动消费的总花费为:"+total);
		return total;
	}
}
