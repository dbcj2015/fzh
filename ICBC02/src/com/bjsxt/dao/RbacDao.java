package com.bjsxt.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface RbacDao {
	public List<Map> findModuals(@Param("roles") List<Integer> roles);
	public List<Map> findRolesById(Integer empId);
	public List<Map> findFuncByModuals(Integer moduals);
}
