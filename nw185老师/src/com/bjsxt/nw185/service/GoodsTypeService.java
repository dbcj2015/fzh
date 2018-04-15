package com.bjsxt.nw185.service;

import javax.annotation.Resource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;
import com.bjsxt.nw185.dao.GoodsTypeDAO;
import com.bjsxt.nw185.entity.*;

@Service("goodsTypeService")
@Transactional(rollbackFor=Exception.class)
public class GoodsTypeService{
	@Resource(name="goodsTypeDAO")
	private GoodsTypeDAO goodsTypeDAO = null;
	
	public void test(){
		System.out.println(goodsTypeDAO.findByProperty(new HashMap()));
		System.out.println("TEST SUCCESS!!!");
	}
	
	public void create(GoodsType entity){
		goodsTypeDAO.insert(entity);
	}
	
	public void update(GoodsType entity){
		goodsTypeDAO.update(entity);
	}
	
	public void delete(Integer goodstypeId){
		goodsTypeDAO.delete(goodstypeId);
	}
	
	public GoodsType findById(Integer goodstypeId){
		return goodsTypeDAO.findById(goodstypeId);
	}
	
	public List<Map> findByProperty(Map params){
		return goodsTypeDAO.findByProperty(params);
	}
	
	public Long countByProperty(Map params){
		return goodsTypeDAO.countByProperty(params);
	}
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		GoodsTypeService bean = (GoodsTypeService)ctx.getBean("goodsTypeService");
		bean.test();
	}
	
}
