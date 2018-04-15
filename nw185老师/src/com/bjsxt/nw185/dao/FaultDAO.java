package com.bjsxt.nw185.dao;

import org.springframework.stereotype.Repository;
import java.util.*;
import com.bjsxt.nw185.entity.*;

public interface FaultDAO{
	public void insert(Fault entity);
	public void update(Fault entity);
	public void delete(Integer faultId);
	public Fault findById(Integer faultId);
	public List<Map> findByProperty(Map params);
	public Long countByProperty(Map params);
}
