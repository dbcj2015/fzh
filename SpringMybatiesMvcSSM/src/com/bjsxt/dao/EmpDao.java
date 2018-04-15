package com.bjsxt.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.bjsxt.entity.Emp;

public interface EmpDao {
	//如果参数类型是Map,在传参时@Param,其中st是键名,startPage是键值
	//如果查询的是一条数据，返回类型选择的是实体类型,如果返回的是多条语句存储在List中的Map中
	public List<Map> findPage(@Param("st") Integer startPage,@Param("r")Integer rows);
	public void insertAll(Emp e);
	public int countAll();
}
