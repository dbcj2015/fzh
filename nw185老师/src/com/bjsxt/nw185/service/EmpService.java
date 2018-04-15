package com.bjsxt.nw185.service;

import javax.annotation.Resource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;
import com.bjsxt.nw185.dao.EmpDAO;
import com.bjsxt.nw185.entity.*;

@Service("empService")
@Transactional(rollbackFor=Exception.class)
public class EmpService{
	@Resource(name="empDAO")
	private EmpDAO empDAO = null;
	
	public void test(){
		System.out.println(empDAO.findByProperty(new HashMap()));
		System.out.println("TEST SUCCESS!!!");
	}
	
	public void create(Emp entity){
		empDAO.insert(entity);
	}
	
	public void update(Emp entity){
		empDAO.update(entity);
	}
	
	public void delete(Integer empId){
		empDAO.delete(empId);
	}
	
	public Emp findById(Integer empId){
		return empDAO.findById(empId);
	}
	
	public List<Map> findByProperty(Map params){
		if(params.containsKey("vagueText")){
			params.put("vagueText" , "%" + params.get("vagueText").toString() + "%"); //模糊查询支持
		}
		return empDAO.findByProperty(params);
	}
	
	public Long countByProperty(Map params){
		return empDAO.countByProperty(params);
	}
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		EmpService bean = (EmpService)ctx.getBean("empService");
		bean.test();
	}
	
}
