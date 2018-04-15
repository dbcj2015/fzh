package com.bjsxt.nw185.dao;

import org.springframework.stereotype.Repository;
import java.util.*;
import com.bjsxt.nw185.entity.*;

public interface BrandDAO{
	public void insert(Brand entity);
	public void update(Brand entity);
	public void delete(Integer brandId);
	public Brand findById(Integer brandId);
	public List<Map> findByProperty(Map params);
	public Long countByProperty(Map params);
}
