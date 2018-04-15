package com.bjsxt.cjlib;

import java.util.Date;

public class CGlibSubTestService extends TestService{
	
	
	@Override
	public void saySTH() {
		// TODO Auto-generated method stub
		System.out.println("准备执行 saySTH()");
		long st = new Date().getTime();
		super.saySTH();
		long et = new Date().getTime();
		System.out.println();
		System.out.println( "saySTH()方法执行时间:" + (et-st) + "ms");
	}
	
	
}
