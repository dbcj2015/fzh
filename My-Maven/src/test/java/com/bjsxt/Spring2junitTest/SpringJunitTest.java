package com.bjsxt.Spring2junitTest;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bjsxt.maven.DBUtils;
//junit������Ȩ����spring-testģ�鴦��,��Junit��ʼ����ʱ��,�Զ����IOC�����ļ���
@RunWith(SpringJUnit4ClassRunner.class)
//Junit��������������ʱ��,�Զ���ȡxml�ļ�
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class SpringJunitTest {
	
	@Resource(name="du")
	private DBUtils dbUtils=null;
	
	@Test
	public void test(){
		dbUtils.testDBUtilBySprintTest("������");
	}
}
