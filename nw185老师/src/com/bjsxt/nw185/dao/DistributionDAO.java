package com.bjsxt.nw185.dao;

import org.springframework.stereotype.Repository;
import java.util.*;
import com.bjsxt.nw185.entity.*;

public interface DistributionDAO{
	public void insert(Distribution entity);
	public void update(Distribution entity);
	public void delete(Integer distId);
	public Distribution findById(Integer distId);
	public List<Map> findByProperty(Map params);
	public Long countByProperty(Map params);
}
