package com.bjsxt.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface EmpDao {
	public List<Map> findByCondition(Map param);
}
