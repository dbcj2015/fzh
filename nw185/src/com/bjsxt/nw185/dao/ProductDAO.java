package com.bjsxt.nw185.dao;

import org.springframework.stereotype.Repository;
import java.util.*;
import com.bjsxt.nw185.entity.*;

public interface ProductDAO{
	public void insert(Product entity);
	public void update(Product entity);
	public void delete(Integer productId);
	public Product findById(Integer productId);
	public List<Map> findByProperty(Map params);
	public Long countByProperty(Map params);
}
