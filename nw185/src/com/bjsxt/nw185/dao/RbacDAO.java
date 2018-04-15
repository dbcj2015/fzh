package com.bjsxt.nw185.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface RbacDAO {
	public List<Map> findModules(@Param("roles") List<Integer> roles);
	public List<Map> findFunctions(@Param("roles") List<Integer> roles , @Param("moduleId") Integer moduleId);
	public List<Map> findRolesByEmp(Integer empId);
}
