package com.bjsxt.service;

import javax.annotation.Resource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;
import com.bjsxt.dao.ProductDAO;

@Service("productService")
@Transactional(rollbackFor=Exception.class)
public class ProductService{
	@Resource(name="productDAO")
	private ProductDAO productDAO = null;
	
	public void test(){
		System.out.println(productDAO.findByProperty(new HashMap()));
		System.out.println("TEST SUCCESS!!!");
	}
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		ProductService bean = (ProductService)ctx.getBean("productService");
		bean.test();
	}
	
}
