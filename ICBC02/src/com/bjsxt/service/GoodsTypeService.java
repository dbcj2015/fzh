package com.bjsxt.service;

import javax.annotation.Resource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;
import com.bjsxt.dao.GoodsTypeDAO;

@Service("goodsTypeService")
@Transactional(rollbackFor=Exception.class)
public class GoodsTypeService{
	@Resource(name="goodsTypeDAO")
	private GoodsTypeDAO goodsTypeDAO = null;
	
	public void test(){
		System.out.println(goodsTypeDAO.findByProperty(new HashMap()));
		System.out.println("TEST SUCCESS!!!");
	}
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		GoodsTypeService bean = (GoodsTypeService)ctx.getBean("goodsTypeService");
		bean.test();
	}
	
}
