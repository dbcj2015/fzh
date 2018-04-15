package com.bjsxt.nw185.dao;

import org.springframework.stereotype.Repository;
import java.util.*;
import com.bjsxt.nw185.entity.*;

public interface TakebackDAO{
	public void insert(Takeback entity);
	public void update(Takeback entity);
	public void delete(Integer takebackId);
	public Takeback findById(Integer takebackId);
	public List<Map> findByProperty(Map params);
	public Long countByProperty(Map params);
}
