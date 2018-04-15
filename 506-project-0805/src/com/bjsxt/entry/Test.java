package com.bjsxt.entry;

import com.bjsxt.fz.SxtJdbcUtil;

public class Test {
	public static void main(String[] args) {
		String sql="insert into sign(unumber,sintime,sinstatus,souttime,soutstatus,sdate)values(?,?,?,?,?,?)";
		for(int i=0;i<20;i++){
			Object[] objs={20170731,"9:6:21","1", "18:4:31", "0","2017-07-"+(01+i)};
			SxtJdbcUtil.excuteDML(sql, objs);	
		}
		
	}
}
