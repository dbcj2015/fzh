package com.bjsxt.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface EmpDao {
	public List<Map> findAll();
	public Map findById(int a);
	//public List<Map> findPage(Map params);
	//@Param()���ע���������ǽ����õĲ�����װΪMap���󴫵ݸ�mybatis
	//@Param(value="st")Integer start -> map.put("st" , start)
	//@Param(value="r")Integer rows -> map.put("r" , rows)
	public List<Map> findPage(@Param(value="st")Integer start ,@Param(value="r") Integer rows );
}
