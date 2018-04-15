package com.bjsxt.nw185.dao;

import org.springframework.stereotype.Repository;
import java.util.*;
import com.bjsxt.nw185.entity.*;

public interface BranchDAO{
	public void insert(Branch entity);
	public void update(Branch entity);
	public void delete(Integer branchId);
	public Branch findById(Integer branchId);
	public List<Map> findByProperty(Map params);
	public Long countByProperty(Map params);
}
