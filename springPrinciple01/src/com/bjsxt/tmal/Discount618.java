package com.bjsxt.tmal;

import java.util.List;

public class Discount618 implements Discount{
	
	Float total=0.0f;
	public Float discount(List<Goods> list){
		for(Goods good:list){
			total=total+good.getPrice()*good.getNum()*0.6f;
		}
		System.out.println("��è618����ѵ��ܻ���Ϊ:"+total);
		return total;
	}
}
