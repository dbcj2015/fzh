package com.bjsxt.entry;

import com.bjsxt.fz.DBUtil;

public class Test {
	public static void main(String[] args) {
		for(int i=0;i<20;i++){
			String sql="insert into sign(unumber,sintime,sinstatus,souttime,soutstatus,sdate)values(?,?,?,?,?,?)";
			//变参封装的形式是Object数组
			Object[] objs={2015120173,"9:6:21","1", "18:4:31", "0","2017-07-"+(01+i)};
			DBUtil.excuteDML(sql, objs);
		}
		System.out.println(Math.ceil(21*1.0/4));	
	}
}
