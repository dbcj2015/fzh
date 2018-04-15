package com.bjsxt.nw185.service;

import javax.annotation.Resource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;
import com.bjsxt.nw185.dao.FunctionDAO;
import com.bjsxt.nw185.entity.*;

@Service("functionService")
@Transactional(rollbackFor=Exception.class)
public class FunctionService{
	@Resource(name="functionDAO")
	private FunctionDAO functionDAO = null;
	
	public void test(){
		System.out.println(functionDAO.findByProperty(new HashMap()));
		System.out.println("TEST SUCCESS!!!");
	}
	
	public void create(Function entity){
		functionDAO.insert(entity);
	}
	
	public void update(Function entity){
		functionDAO.update(entity);
	}
	
	public void delete(Integer functionId){
		functionDAO.delete(functionId);
	}
	
	public Function findById(Integer functionId){
		return functionDAO.findById(functionId);
	}
	
	public List<Map> findByProperty(Map params){
		return functionDAO.findByProperty(params);
	}
	
	public Long countByProperty(Map params){
		return functionDAO.countByProperty(params);
	}
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		FunctionService bean = (FunctionService)ctx.getBean("functionService");
		bean.test();
	}
	
}
