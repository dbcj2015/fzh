package com.bjsxt.nw185.service;

import javax.annotation.Resource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;
import com.bjsxt.nw185.dao.ProjectDAO;
import com.bjsxt.nw185.entity.*;

@Service("projectService")
@Transactional(rollbackFor=Exception.class)
@SuppressWarnings("all")
public class ProjectService{
	@Resource(name="projectDAO")
	private ProjectDAO projectDAO = null;
	
	public void test(){
		System.out.println(projectDAO.findByProperty(new HashMap()));
		System.out.println("TEST SUCCESS!!!");
	}
	
	public void create(Project entity){
		projectDAO.insert(entity);
	}
	
	public void update(Project entity){
		projectDAO.update(entity);
	}
	
	public void delete(Integer projectId){
		projectDAO.delete(projectId);
	}
	
	public Project findById(Integer projectId){
		return projectDAO.findById(projectId);
	}
	
	public List<Map> findByProperty(Map params){
		return projectDAO.findByProperty(params);
	}
	
	public Long countByProperty(Map params){
		return projectDAO.countByProperty(params);
	}
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		ProjectService bean = (ProjectService)ctx.getBean("projectService");
		bean.test();
	}
	
}
