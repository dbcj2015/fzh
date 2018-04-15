package com.bjsxt.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface EmpDao {
	public List<Map> findAll();
	public Map findById(int a);
	//public List<Map> findPage(Map params);
	//@Param()这个注解的用意就是将设置的参数包装为Map对象传递给mybatis
	//@Param(value="st")Integer start -> map.put("st" , start)
	//@Param(value="r")Integer rows -> map.put("r" , rows)
	public List<Map> findPage(@Param(value="st")Integer start ,@Param(value="r") Integer rows );
}
