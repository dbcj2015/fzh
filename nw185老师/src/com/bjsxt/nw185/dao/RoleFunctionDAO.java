package com.bjsxt.nw185.dao;

import org.springframework.stereotype.Repository;
import java.util.*;
import com.bjsxt.nw185.entity.*;

public interface RoleFunctionDAO{
	public void insert(RoleFunction entity);
	public void update(RoleFunction entity);
	public void delete(Integer rfId);
	public void deleteByProperty(Map params);
	public RoleFunction findById(Integer rfId);
	public List<Map> findByProperty(Map params);
	public Long countByProperty(Map params);
}
