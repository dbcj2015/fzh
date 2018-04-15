package com.bjsxt.dao;

import org.springframework.stereotype.Repository;
import java.util.*;
import com.bjsxt.entity.*;

public interface GoodsTypeDAO{
	public void insert(GoodsType entity);
	public void update(GoodsType entity);
	public void delete(Integer goodstypeId);
	public Map findById(Integer goodstypeId);
	public List<Map> findByProperty(Map params);
}
