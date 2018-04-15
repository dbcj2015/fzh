package com.bjsxt.dao;

import java.util.List;
import java.util.Map;

import com.bjsxt.entity.Emp;

public interface EmpDao {
	public List<Map> findAll();
	public void insertAll(Emp e);
}
