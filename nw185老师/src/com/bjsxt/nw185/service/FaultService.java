package com.bjsxt.nw185.service;

import javax.annotation.Resource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;
import com.bjsxt.nw185.dao.FaultDAO;
import com.bjsxt.nw185.entity.*;

@Service("faultService")
@Transactional(rollbackFor=Exception.class)
@SuppressWarnings("all")
public class FaultService{
	@Resource(name="faultDAO")
	private FaultDAO faultDAO = null;
	
	public void test(){
		System.out.println(faultDAO.findByProperty(new HashMap()));
		System.out.println("TEST SUCCESS!!!");
	}
	
	public void create(Fault entity){
		faultDAO.insert(entity);
	}
	
	public void update(Fault entity){
		faultDAO.update(entity);
	}
	
	public void delete(Integer faultId){
		faultDAO.delete(faultId);
	}
	
	public Fault findById(Integer faultId){
		return faultDAO.findById(faultId);
	}
	
	public List<Map> findByProperty(Map params){
		return faultDAO.findByProperty(params);
	}
	
	public Long countByProperty(Map params){
		return faultDAO.countByProperty(params);
	}
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		FaultService bean = (FaultService)ctx.getBean("faultService");
		bean.test();
	}
	
}
