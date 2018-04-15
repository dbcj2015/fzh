package com.bjsxt.nw185.dao;

import org.springframework.stereotype.Repository;
import java.util.*;
import com.bjsxt.nw185.entity.*;

public interface DistributionDetailDAO{
	public void insert(DistributionDetail entity);
	public void update(DistributionDetail entity);
	public void delete(Integer ddId);
	public DistributionDetail findById(Integer ddId);
	public List<Map> findByProperty(Map params);
	public Long countByProperty(Map params);
	public List<Map> groupDetailByDistId(Map params);
}
