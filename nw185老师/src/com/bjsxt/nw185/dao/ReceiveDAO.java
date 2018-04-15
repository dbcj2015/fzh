package com.bjsxt.nw185.dao;

import org.springframework.stereotype.Repository;
import java.util.*;
import com.bjsxt.nw185.entity.*;

public interface ReceiveDAO{
	public void insert(Receive entity);
	public void update(Receive entity);
	public void delete(Integer receiveId);
	public Receive findById(Integer receiveId);
	public List<Map> findByProperty(Map params);
	public Long countByProperty(Map params);
}
