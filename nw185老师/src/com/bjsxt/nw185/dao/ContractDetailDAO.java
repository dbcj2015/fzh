package com.bjsxt.nw185.dao;

import org.springframework.stereotype.Repository;
import java.util.*;
import com.bjsxt.nw185.entity.*;

public interface ContractDetailDAO{
	public void insert(ContractDetail entity);
	public void update(ContractDetail entity);
	public void delete(Integer cdId);
	public ContractDetail findById(Integer cdId);
	public List<Map> findByProperty(Map params);
	public Long countByProperty(Map params);
}
