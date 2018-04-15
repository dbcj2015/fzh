package com.bjsxt.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.bjsxt.dao.EmpDao;
import com.bjsxt.util.MybatisUtil;
import com.google.gson.Gson;

public class TestDynamicQuery {

	@Test
	public void testFindByName() {
		SqlSessionFactory sessionFactory = MybatisUtil.getSessionFactory();
		SqlSession openSession = sessionFactory.openSession();
		EmpDao dao=openSession.getMapper(EmpDao.class);
		Map map=new HashMap<>();
		map.put("param", "%ALL%");
		List<Map> list = dao.findByCondition(map);
		System.out.println(new Gson().toJson(list));
	}
	
	@Test
	public void testFindBySal() {
		SqlSessionFactory sessionFactory = MybatisUtil.getSessionFactory();
		SqlSession openSession = sessionFactory.openSession();
		EmpDao dao=openSession.getMapper(EmpDao.class);
		Map map=new HashMap<>();
		List jobs=new ArrayList<>();
		jobs.add("CLERK");
		jobs.add("MANAGER");
		jobs.add("SALESMAN");
		map.put("jobs", jobs);
		List<Map> list = dao.findByCondition(map);
		System.out.println(new Gson().toJson(list));
	}
	
	
}
