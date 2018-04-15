package com.bjsxt.nw185.dao;

import org.springframework.stereotype.Repository;
import java.util.*;
import com.bjsxt.nw185.entity.*;

public interface ProjectDAO{
	public void insert(Project entity);
	public void update(Project entity);
	public void delete(Integer projectId);
	public Map findById(Integer projectId);
	public List<Map> findByProperty(Map params);
}
