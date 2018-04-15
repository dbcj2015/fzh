package com.bjsxt.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
public class MybatisUtil {
	private static SqlSessionFactory sessionFactory = null; 
	static{
		try {
			InputStream is=Resources.getResourceAsStream("mybatis.xml");
			sessionFactory = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			//��MybatisUtils����ڲ����쳣��ӡ���
			//e.printStackTrace();
			//RuntimeException��������ʱ�쳣
			//RuntimeException���ĺô����������ٷ���������ʱ��throws
			throw new RuntimeException(e);
		}
	}
	
	public static SqlSessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
