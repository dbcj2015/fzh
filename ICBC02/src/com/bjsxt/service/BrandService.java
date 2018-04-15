package com.bjsxt.service;

import javax.annotation.Resource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;
import com.bjsxt.dao.BrandDAO;

@Service("brandService")
@Transactional(rollbackFor=Exception.class)
public class BrandService{
	@Resource(name="brandDAO")
	private BrandDAO brandDAO = null;
	
	public void test(){
		System.out.println(brandDAO.findByProperty(new HashMap()));
		System.out.println("TEST SUCCESS!!!");
	}
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		BrandService bean = (BrandService)ctx.getBean("brandService");
		bean.test();
	}
	
}
