package com.bjsxt.nw185.service;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import com.bjsxt.nw185.dao.RoleDAO;
import com.bjsxt.nw185.dao.RoleFunctionDAO;
import com.bjsxt.nw185.entity.*;

@Service("roleService")
@Transactional(rollbackFor=Exception.class)
public class RoleService{
	@Resource(name="roleDAO")
	private RoleDAO roleDAO = null;
	
	@Resource(name="roleFunctionDAO")
	private RoleFunctionDAO roleFunctionDAO = null;
	
	public void test(){
		System.out.println(roleDAO.findByProperty(new HashMap()));
		System.out.println("TEST SUCCESS!!!");
	}
	
	public void create(Role entity){
		roleDAO.insert(entity);
	}
	
	public void update(Role entity){
		roleDAO.update(entity);
	}
	
	public void delete(Integer roleId){
		roleDAO.delete(roleId);
	}
	
	public Role findById(Integer roleId){
		return roleDAO.findById(roleId);
	}
	
	public List<Map> findByProperty(Map params){
		return roleDAO.findByProperty(params);
	}
	
	public Long countByProperty(Map params){
		return roleDAO.countByProperty(params);
	}
	
	public List<Map> findRoleFunctions(Integer roleId){
		return roleDAO.findRoleFunctions(roleId);
	}
	
	public void authFunctions(Integer roleId , Integer[] functionId){
		Map param = new HashMap();
		param.put("roleId", roleId);
		roleFunctionDAO.deleteByProperty(param);//清楚之前关联对象
		for(Integer fid : functionId){
			RoleFunction rf = new RoleFunction();
			rf.setFunctionId(fid);
			rf.setRoleId(roleId);
			roleFunctionDAO.insert(rf);
		}
	}
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		RoleService bean = (RoleService)ctx.getBean("roleService");
		bean.test();
	}
	
}
