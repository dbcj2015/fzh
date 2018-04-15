package com.bjsxt.util;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtils {
	private static SqlSessionFactory sessionFactory = null;
	static{
		try{
			InputStream is = Resources.getResourceAsStream("mybatis.xml");
			sessionFactory = new SqlSessionFactoryBuilder().build(is);
		}catch(Exception e){
			
			throw new RuntimeException(e);
		}
	}
	public static SqlSessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
