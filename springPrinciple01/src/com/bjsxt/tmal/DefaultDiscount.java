package com.bjsxt.tmal;

import java.util.List;

public class DefaultDiscount implements Discount{
	
	Float total=0.0f;
	public Float discount(List<Goods> list){
		
		for(Goods good:list){
			total=total+good.getPrice()*good.getNum();
		}
		System.out.println("没有活动情况下的总花费为:"+total);
		return total;
	}
}
