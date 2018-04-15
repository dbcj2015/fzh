package com.bjsxt.nw185.dao;

import org.springframework.stereotype.Repository;
import java.util.*;
import com.bjsxt.nw185.entity.*;

public interface RoleEmpDAO{
	public void insert(RoleEmp entity);
	public void update(RoleEmp entity);
	public void delete(Integer ruId);
	public RoleEmp findById(Integer ruId);
	public List<Map> findByProperty(Map params);
	public Long countByProperty(Map params);
}
