package com.bjsxt.tmal;

import java.util.List;

public class DiscountD11 implements Discount{
	
	public Float discount(List<Goods> list){
		
	System.out.println("��è˫11�,ȫ����װ��5��,��ʳƷ7��,����");
	Float total = 0f;
	for(Goods g : list){
		if(g.getType().equals("��װ")){
			total = total + g.getPrice() * g.getNum() * 0.5f;
		}else if(g.getType().equals("��ʳƷ")){
			total = total + g.getPrice() * g.getNum() * 0.7f;
		}else{
			total = total + g.getPrice() * g.getNum();
		}
	}
	return total;
}
}
