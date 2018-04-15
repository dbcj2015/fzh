package com.bjsxt.dao;

import java.util.List;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface EmpDao {
	//如果参数类型是Map,在传参时@Param,其中st是键名,startPage是键值
	//如果查询的是一条数据，返回类型选择的是实体类型,如果返回的是多条语句存储在List中的Map中
	//如果参数是一个同样可以以Map形式获取值，返回只有一条数据既可以是一个数组也可以是实体类或者map对象
	public List<Map> find(@Param("username") String username);
	
}
