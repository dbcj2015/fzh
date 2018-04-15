package com.bjsxt.nw185.service;

import javax.annotation.Resource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;
import com.bjsxt.nw185.dao.ModuleDAO;
import com.bjsxt.nw185.entity.*;

@Service("moduleService")
@Transactional(rollbackFor=Exception.class)
public class ModuleService{
	@Resource(name="moduleDAO")
	private ModuleDAO moduleDAO = null;
	
	public void test(){
		System.out.println(moduleDAO.findByProperty(new HashMap()));
		System.out.println("TEST SUCCESS!!!");
	}
	
	public void create(Module entity){
		moduleDAO.insert(entity);
	}
	
	public void update(Module entity){
		moduleDAO.update(entity);
	}
	
	public void delete(Integer moduleId){
		moduleDAO.delete(moduleId);
	}
	
	public Module findById(Integer moduleId){
		return moduleDAO.findById(moduleId);
	}
	
	public List<Map> findByProperty(Map params){
		return moduleDAO.findByProperty(params);
	}
	
	public Long countByProperty(Map params){
		return moduleDAO.countByProperty(params);
	}
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		ModuleService bean = (ModuleService)ctx.getBean("moduleService");
		bean.test();
	}
	
}
