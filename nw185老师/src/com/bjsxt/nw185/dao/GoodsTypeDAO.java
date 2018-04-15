package com.bjsxt.nw185.dao;

import org.springframework.stereotype.Repository;
import java.util.*;
import com.bjsxt.nw185.entity.*;

public interface GoodsTypeDAO{
	public void insert(GoodsType entity);
	public void update(GoodsType entity);
	public void delete(Integer goodstypeId);
	public GoodsType findById(Integer goodstypeId);
	public List<Map> findByProperty(Map params);
	public Long countByProperty(Map params);
}
