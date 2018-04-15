package com.bjsxt.nw185.dao;

import org.springframework.stereotype.Repository;
import java.util.*;
import com.bjsxt.nw185.entity.*;
@SuppressWarnings("all")
public interface VenderDAO{
	public void insert(Vender entity);
	public void update(Vender entity);
	public void delete(Integer venderId);
	public Vender findById(Integer venderId);
	public List<Map> findByProperty(Map params);
	public Long countByProperty(Map params);
}
