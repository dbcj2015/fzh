package com.bjsxt.util;

import java.util.List;
import java.util.Map;

public class selectDao implements DAO{

	@Override
	public List<Map> selectAll() {
		boolean flag=false;
		List<Map> list=null;
		try {
			list = DBUtils.list("select * from book");
			flag=true;
		} catch (DBException e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
