package com.bjsxt.nw185.service;

import javax.annotation.Resource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;
import com.bjsxt.nw185.dao.ProjectDAO;

@Service("projectService")
@Transactional(rollbackFor=Exception.class)
public class ProjectService{
	@Resource(name="projectDAO")
	private ProjectDAO projectDAO = null;
	
	public List<Map> findByProperty(){
		return projectDAO.findByProperty(new HashMap());
	}
	
	public void test(){
		System.out.println(projectDAO.findByProperty(new HashMap()));
		System.out.println("TEST SUCCESS!!!");
	}
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		ProjectService bean = (ProjectService)ctx.getBean("projectService");
		bean.test();
	}
	
}
