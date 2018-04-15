package com.bjsxt.nw185.dao;

import org.springframework.stereotype.Repository;
import java.util.*;
import com.bjsxt.nw185.entity.*;

public interface TakeoutDAO{
	public void insert(Takeout entity);
	public void update(Takeout entity);
	public void delete(Integer takeoutId);
	public Takeout findById(Integer takeoutId);
	public List<Map> findByProperty(Map params);
	public Long countByProperty(Map params);
}
