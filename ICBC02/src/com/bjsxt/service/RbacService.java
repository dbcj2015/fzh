package com.bjsxt.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bjsxt.dao.RbacDao;
@Service("rbacService")
public class RbacService {
	
	@Resource(name="rbacDao")
	private RbacDao rbacDao=null;
	public List findModualsByRole(List<Integer> list){
		return rbacDao.findModuals(list);
	}
	
	public List<Map> findFuncByModuals(Integer moduals){
		return rbacDao.findFuncByModuals(moduals);
	}
}
