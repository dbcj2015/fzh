package com.bjsxt.nw185.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.*;

import com.bjsxt.nw185.entity.*;

public interface RoleDAO{
	public void insert(Role entity);
	public void update(Role entity);
	public void delete(Integer roleId);
	public Role findById(Integer roleId);
	public List<Map> findByProperty(Map params);
	public Long countByProperty(Map params);
	public List<Map> findRoleFunctions(@Param("roleId")Integer roleId);
	
}
