package com.bjsxt.tmal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.bjsxt.utils.ApplicateDiscount;
public class CashierService {
	public void pay(List<Goods> carts) throws InstantiationException, ClassNotFoundException, IllegalAccessException, IOException{
		//面向接口编程,我们在使用类的时候,对象的类型应是一个接口,而不是具体的实现类
				//23种设计模式中:策略模式的用法
				//说人话:将相似的业务代码进行抽象,形成一个接口,不同的业务计算方式用一个一个实现类的保存
				//这种做法就是"策略模式"
				
				//这段代码是否符合OCP(开闭)原则
				//为了满足OCP原则,我们让创建对象的工作放在业务代码之外完成
				
				
				//为了让程序实现解耦(OCP)原则,要做一下事情
				//1. 实现类应放在配置文件中
				//2. 利用程序外的第三者对象(ApplicateDiscount)来实现创建类的工作,ApplicateDiscount它是一个容器,将创建好的类存放在名为ioc的Map容器中
				//3. 在具体业务类使用的时候不在 new XXXXX(),而是改为从ApplicateDiscount.getBean()将以创建好的对象拿出来就行了
		
		//通过工具类创建对应类的对象
		ApplicateDiscount ctx = new ApplicateDiscount();
		//获取到对应类的对象DiscountD11
		Discount dis = (Discount)ctx.getBean("discountObj");
		//根据多态执行实现类的discount方法
		float total = dis.discount(carts);
		
		System.out.println("正在向支付宝发起支付请求,本次支付:" + total);
		
	}
	
	public static void main(String[] args) throws InstantiationException, ClassNotFoundException, IllegalAccessException, IOException {
		List carts = new ArrayList();//carts购物车
		carts.add(new Goods("手机" , "小米" , "小米5X" , 1499f , 1));
		carts.add(new Goods("膨化食品" , "旺旺" , "旺旺雪饼" , 10f , 5));
		carts.add(new Goods("服装" , "阿迪王" , "YMS-752" , 88f , 2));
		
		new CashierService().pay(carts);
	}
}
