package com.bjsxt.hibernate.config;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bjsxt.hibernate.entity.Goods;

public class SessionFactoryConfig {
	public static void main(String[] args) {
		//读取默认的hibernate.cfg.xml文件
				//配置类
				Configuration config = new Configuration().configure();
				//SessionFactory 对象用于创建管理数据库连接
				SessionFactory sf = config.buildSessionFactory();//创建SessionFactory(会话工厂,初始化数据源)
				System.out.println("Hiberante初始化成功");
				//ORM框架最重要的工作就是配置实体类和数据表之间的对应关系
				Session session = sf.openSession();//创建Session,和Mybatis的Session类似,它提供了增删改查的方法,同时每一个Session都有对应的数据库连接
				//from Goods是Hibernate中的查询语句格式,叫做HQL Hiberante Query Language
				//select * from t_goods;
				//HQL->SQL的转换: 1. 去掉select *　2. 使用到的所有字段名改为属性名  3.使用到的所有表名改成实体类名
				Query query = session.createQuery("from Goods");
				query.setFirstResult(5);
				query.setMaxResults(10);
				List<Goods> list = query.list();//得到查询结果	
				for(Goods g : list){
					System.out.println(g.getGoodsId() + ":" + g.getTitle());
				}
	}
}
