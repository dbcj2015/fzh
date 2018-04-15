package com.bjsxt.nw185.dao;

import org.springframework.stereotype.Repository;
import java.util.*;
import com.bjsxt.nw185.entity.*;

public interface EmpDAO{
	public void insert(Emp entity);
	public void update(Emp entity);
	public void delete(Integer empId);
	public Emp findById(Integer empId);
	public List<Map> findByProperty(Map params);
	public Long countByProperty(Map params);
}
