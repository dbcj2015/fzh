package com.bjsxt.nw185.service;

import javax.annotation.Resource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;
import com.bjsxt.nw185.dao.VenderDAO;
import com.bjsxt.nw185.entity.*;

@Service("venderService")
@Transactional(rollbackFor=Exception.class)
@SuppressWarnings("all")
public class VenderService{
	@Resource(name="venderDAO")
	private VenderDAO venderDAO = null;
	
	public void test(){
		System.out.println(venderDAO.findByProperty(new HashMap()));
		System.out.println("TEST SUCCESS!!!");
	}
	
	public void create(Vender entity){
		venderDAO.insert(entity);
	}
	
	public void update(Vender entity){
		venderDAO.update(entity);
	}
	
	public void delete(Integer venderId){
		venderDAO.delete(venderId);
	}
	
	public Vender findById(Integer venderId){
		return venderDAO.findById(venderId);
	}
	
	public List<Map> findByProperty(Map params){
		return venderDAO.findByProperty(params);
	}
	
	public Long countByProperty(Map params){
		return venderDAO.countByProperty(params);
	}
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		VenderService bean = (VenderService)ctx.getBean("venderService");
		bean.test();
	}
	
}
