package com.bjsxt.dao;

import org.springframework.stereotype.Repository;
import java.util.*;
import com.bjsxt.entity.*;

public interface BrandDAO{
	public void insert(Brand entity);
	public void update(Brand entity);
	public void delete(Integer brandId);
	public Map findById(Integer brandId);
	public List<Map> findByProperty(Map params);
}
