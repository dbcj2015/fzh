package com.bjsxt.dao;

import org.springframework.stereotype.Repository;
import java.util.*;
import com.bjsxt.entity.*;

public interface ContractDAO{
	public void insert(Contract entity);
	public void update(Contract entity);
	public void delete(Integer contractId);
	public Map findById(Integer contractId);
	//public List<Map> findByProperty(Map params);
	public List<Map> findByProperty(Map params);
	public Map countByProperty();
}
