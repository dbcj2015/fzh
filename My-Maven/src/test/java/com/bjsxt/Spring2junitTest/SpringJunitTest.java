package com.bjsxt.Spring2junitTest;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bjsxt.maven.DBUtils;
//junit将控制权交给spring-test模块处理,在Junit初始化的时候,自动完成IOC容器的加载
@RunWith(SpringJUnit4ClassRunner.class)
//Junit启动测试用例的时候,自动读取xml文件
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class SpringJunitTest {
	
	@Resource(name="du")
	private DBUtils dbUtils=null;
	
	@Test
	public void test(){
		dbUtils.testDBUtilBySprintTest("王钲言");
	}
}
