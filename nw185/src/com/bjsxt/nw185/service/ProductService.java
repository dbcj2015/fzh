package com.bjsxt.nw185.service;

import javax.annotation.Resource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;
import com.bjsxt.nw185.dao.ProductDAO;
import com.bjsxt.nw185.entity.*;

@Service("productService")
@Transactional(rollbackFor=Exception.class)
public class ProductService{
	@Resource(name="productDAO")
	private ProductDAO productDAO = null;
	
	public void test(){
		System.out.println(productDAO.findByProperty(new HashMap()));
		System.out.println("TEST SUCCESS!!!");
	}
	
	public void create(Product entity){
		productDAO.insert(entity);
	}
	
	public void update(Product entity){
		productDAO.update(entity);
	}
	
	public void delete(Integer productId){
		productDAO.delete(productId);
	}
	
	public Product findById(Integer productId){
		return productDAO.findById(productId);
	}
	
	public List<Map> findByProperty(Map params){
		return productDAO.findByProperty(params);
	}
	
	public Long countByProperty(Map params){
		return productDAO.countByProperty(params);
	}
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		ProductService bean = (ProductService)ctx.getBean("productService");
		bean.test();
	}
	
}
