package com.bjsxt.dao;

import org.springframework.stereotype.Repository;
import java.util.*;
import com.bjsxt.entity.*;

public interface ProductDAO{
	public void insert(Product entity);
	public void update(Product entity);
	public void delete(Integer productId);
	public Map findById(Integer productId);
	public List<Map> findByProperty(Map params);
}
