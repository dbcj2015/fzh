package com.bjsxt.nw185.service;

import javax.annotation.Resource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;
import com.bjsxt.nw185.dao.BrandDAO;
import com.bjsxt.nw185.entity.*;

@Service("brandService")
@Transactional(rollbackFor=Exception.class)
public class BrandService{
	@Resource(name="brandDAO")
	private BrandDAO brandDAO = null;
	
	public void test(){
		System.out.println(brandDAO.findByProperty(new HashMap()));
		System.out.println("TEST SUCCESS!!!");
	}
	
	public void create(Brand entity){
		brandDAO.insert(entity);
	}
	
	public void update(Brand entity){
		brandDAO.update(entity);
	}
	
	public void delete(Integer brandId){
		brandDAO.delete(brandId);
	}
	
	public Brand findById(Integer brandId){
		return brandDAO.findById(brandId);
	}
	
	public List<Map> findByProperty(Map params){
		return brandDAO.findByProperty(params);
	}
	
	public Long countByProperty(Map params){
		return brandDAO.countByProperty(params);
	}
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		BrandService bean = (BrandService)ctx.getBean("brandService");
		bean.test();
	}
	
}
