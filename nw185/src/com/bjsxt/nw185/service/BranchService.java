package com.bjsxt.nw185.service;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import com.bjsxt.nw185.dao.BranchDAO;
import com.bjsxt.nw185.entity.*;

@Service("branchService")
@Transactional(rollbackFor=Exception.class)
public class BranchService{
	@Resource(name="branchDAO")
	private BranchDAO branchDAO = null;
	
	public void test(){
		System.out.println(branchDAO.findByProperty(new HashMap()));
		System.out.println("TEST SUCCESS!!!");
	}
	
	public void create(Branch entity){
		branchDAO.insert(entity);
	}
	
	public void update(Branch entity){
		branchDAO.update(entity);
	}
	
	public void delete(Integer branchId){
		branchDAO.delete(branchId);
	}
	
	public Branch findById(Integer branchId){
		return branchDAO.findById(branchId);
	}
	
	public List<Map> findByProperty(Map params){
		System.out.println("BranchService.findByProperty()");
		System.out.println(params.get("branchLevel"));
		List<Map> findByProperty = branchDAO.findByProperty(params);
		
		return findByProperty;
	}
	
	public Long countByProperty(Map params){
		
		return branchDAO.countByProperty(params);
	}
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		BranchService bean = (BranchService)ctx.getBean("branchService");
		
	}
	
}
