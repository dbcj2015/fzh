package com.bjsxt.nw185.dao;

import org.springframework.stereotype.Repository;
import java.util.*;
import com.bjsxt.nw185.entity.*;

public interface FunctionDAO{
	public void insert(Function entity);
	public void update(Function entity);
	public void delete(Integer functionId);
	public Function findById(Integer functionId);
	public List<Map> findByProperty(Map params);
	public Long countByProperty(Map params);
}
