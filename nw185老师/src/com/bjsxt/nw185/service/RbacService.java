package com.bjsxt.nw185.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.bjsxt.nw185.dao.RbacDAO;

@Service
public class RbacService {
	@Resource(name="rbacDAO")
	private RbacDAO rbacDAO = null;
	public List<Map> findModules(List<Integer> roles){
		return rbacDAO.findModules(roles);
	}
	
	public List<Map> findFunctions(List<Integer> roles , Integer moduleId){
		return rbacDAO.findFunctions(roles , moduleId);
	}
	
	public List<Map> findRolesByEmp(Integer empId){
		return rbacDAO.findRolesByEmp(empId);
	}
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		RbacService rbac = (RbacService)ctx.getBean("rbacService");
		System.out.println(rbac.findRolesByEmp(1));
	}
}
