package com.bjsxt.cjlib;

import java.util.Date;

public class SubTestService extends TestService{
	
	@Override
	public void saySTH() {
		super.saySTH();
		System.out.println("我是对父类代码的扩展");
	}

//	@Override
//	public void saySTH() {
//		// TODO Auto-generated method stub
//		System.out.println("准备执行 saySTH()");
//		long st = new Date().getTime();
//		super.saySTH();
//		long et = new Date().getTime();
//		System.out.println();
//		System.out.println( "saySTH()方法执行时间:" + (et-st) + "ms");
//	}
	
	public static void main(String[] args) {
		//这就是通过子类继承父类的方式，实现父类中代码的扩展，但是存在一个问题，当有多个父类时，子类中扩展父类代码时
		//同样需要继承多个方法进行扩展，比较麻烦，CGlib很好的解决了这个问题
		SubTestService service=new SubTestService();
		service.saySTH();
	}
}
