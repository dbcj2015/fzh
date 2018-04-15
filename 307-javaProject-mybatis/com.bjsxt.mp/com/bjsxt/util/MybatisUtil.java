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
			//在MybatisUtils类的内部将异常打印输出
			//e.printStackTrace();
			//RuntimeException代表运行时异常
			//RuntimeException最大的好处就是无需再方法声明的时候throws
			throw new RuntimeException(e);
		}
	}
	
	public static SqlSessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
