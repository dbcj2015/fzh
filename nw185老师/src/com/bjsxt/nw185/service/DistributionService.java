package com.bjsxt.nw185.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bjsxt.nw185.dao.DistributionDAO;
import com.bjsxt.nw185.dao.DistributionDetailDAO;
import com.bjsxt.nw185.entity.Distribution;

@Service("distributionService")
@Transactional(rollbackFor=Exception.class)
public class DistributionService{
	@Resource(name="distributionDAO")
	private DistributionDAO distributionDAO = null;
	
	@Resource
	private DistributionDetailDAO distributionDetailDAO = null;
	
	public void test(){
		System.out.println(distributionDAO.findByProperty(new HashMap()));
		System.out.println("TEST SUCCESS!!!");
	}
	
	public void create(Distribution entity){
		distributionDAO.insert(entity);
	}
	
	public void update(Distribution entity){
		distributionDAO.update(entity);
	}
	
	public void delete(Integer distributionId){
		distributionDAO.delete(distributionId);
	}
	
	public Distribution findById(Integer distributionId){
		return distributionDAO.findById(distributionId);
	}
	
	public List<Map> findByProperty(Map params){
		return distributionDAO.findByProperty(params);
	}
	
	public Long countByProperty(Map params){
		return distributionDAO.countByProperty(params);
	}
	
	public List<Map> groupDetailByDistId(Map params){
		return distributionDetailDAO.groupDetailByDistId(params);
	}
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		DistributionService bean = (DistributionService)ctx.getBean("distributionService");
		bean.test();
	}
	
}
