package com.bjsxt.nw185.dao;

import org.springframework.stereotype.Repository;
import java.util.*;
import com.bjsxt.nw185.entity.*;

public interface ModuleDAO{
	public void insert(Module entity);
	public void update(Module entity);
	public void delete(Integer moduleId);
	public Module findById(Integer moduleId);
	public List<Map> findByProperty(Map params);
	public Long countByProperty(Map params);
}
