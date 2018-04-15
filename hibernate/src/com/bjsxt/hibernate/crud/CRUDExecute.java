package com.bjsxt.hibernate.crud;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.transform.Transformers;
import org.junit.Test;

import com.bjsxt.hibernate.entity.Category;
import com.bjsxt.hibernate.entity.Goods;
import com.bjsxt.hibernate.entity.Member;
@SuppressWarnings("all")
public class CRUDExecute {
	public SessionFactory getSessionFactory(){
		Configuration configure = new Configuration().configure();
		//Configuration conf=new AnnotationConfiguration();
		return configure.buildSessionFactory();
	}
	
	@Test
	public void testBasic(){
		Session openSession = this.getSessionFactory().openSession();
		List<Goods> list = openSession.createQuery("from Goods where goodsId>1000").list();
		for(Goods good:list){
			System.out.println(good.getTitle());
		}
	}
	
	@Test
	public void testParamQuery(){
		Session openSession = this.getSessionFactory().openSession();
		Query query = openSession.createQuery("from Goods where goodsId> :id and current_price> :price");
		query.setInteger("id", 1000);
		query.setFloat("price", 100);
		List<Goods> goods = query.list();
		for(Goods good:goods){
			System.out.println(good.getTitle());
		}
	}
	
	//分页查询
	@Test
	public void paginationQuery(){
		Session openSession = this.getSessionFactory().openSession();
		Query query = openSession.createQuery("from Goods where goodsId> :id and currentPrice> :price");
		query.setInteger("id", 1000);
		query.setFloat("price", 100);
		query.setFirstResult(10);
		query.setMaxResults(5);
		List<Goods> goods = query.list();
		for(Goods good:goods){
			System.out.println(good.getTitle());
		}
	}
	
	//关联查询
	@Test
	public void testJoinQuery(){
		Session openSession = this.getSessionFactory().openSession();
		Query query = openSession.createQuery("from Goods g,Category c where g.categoryId=c.categoryId and g.goodsId> :id and g.currentPrice> :price ");
		query.setInteger("id", 1000);
		query.setFloat("price", 100);
		query.setFirstResult(10);
		query.setMaxResults(5);
		List<Object[]> goods = query.list();
		for(Object[] objs : goods){
			Goods g = (Goods)objs[0];
			Category c = (Category)objs[1];
			System.out.println(c.getCategoryName() + ":" + g.getTitle());
		}
		openSession.close();
	}
	@Test
	//原生SQL--弥补hibernate中无法使用左连接以及右连接的短处
	public void testSQLQuery(){
		Session session = this.getSessionFactory().openSession();
		SQLQuery q = session.createSQLQuery("select * from t_goods g , t_category c where g.category_id = c.category_id and g.goods_id > :gi");
		q.setFirstResult(10);
		q.setMaxResults(5);
		//将结果从Object数组转为Map对象
		q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		q.setInteger("gi", 1000);
		List list = q.list();
		session.close();
	}
	
	@Test
	public void create(){
		Category c = new Category(); //1. 临时
		Session session = this.getSessionFactory().openSession();
		//打开事务
		Transaction tx = session.beginTransaction();
		
		c.setCategoryLevel(2);
		c.setCategoryName("内存条");
		c.setCategoryOrder(321);
		c.setParentId(4);
		session.save(c);//保存 2. 持久化状态
		tx.commit();
		session.close();
		System.out.println(c.getCategoryName()); //3.游离状态
	}
	
	@Test
	public void update(){
		Session session = this.getSessionFactory().openSession();
		//按id获取
		Category c59 = (Category)session.get(Category.class, 59);
		//打开事务
		Transaction tx = session.beginTransaction();
		c59.setCategoryName("硬盘");
		session.update(c59);//保存
		tx.commit();
	}
	
	@Test
	public void deleteById(){
		Session session = this.getSessionFactory().openSession();
		//按id获取
		Category c59 = (Category)session.get(Category.class, 59);
		//打开事务
		Transaction tx = session.beginTransaction();
		
		session.delete(c59);//保存
		tx.commit();
	}
	
	@Test
	//批量删除
	public void batchDelete(){
		Session session = this.getSessionFactory().openSession();
		
		Transaction tx = session.beginTransaction();
		Query q = session.createQuery("DELETE FROM Category where categoryId > 55");
		int cnt = q.executeUpdate();//list返回的是结果集,.executeUpdate则代表数据更新,返回更新数据的数量
		tx.commit();
		System.out.println("本次删除 " + cnt + "条数据");
	}
	//测试注解形式的hibernate
	@Test
	public void testAnnotation(){
		Session session = this.getSessionFactory().openSession();
		Member m = (Member)session.get(Member.class, 11);
		System.out.println(m.getNickname());
	}
	
	@Test
	public void testCache(){
		//所谓1级缓存是Session级别的缓存
		//二级缓存则是SessionFactory(数据源全局)的缓存
		Session session = this.getSessionFactory().openSession();
		Member m1 = (Member)session.get(Member.class, 11);
		//session.clear();
		Member m2 = (Member)session.get(Member.class, 11);
		session.close();
		Session session1 = this.getSessionFactory().openSession();
		Member m3 = (Member)session1.get(Member.class, 11);
		session1.close();
		
	}
	
	//事务隔离级别
	//乐观锁
	@Test
	public void testIsolation(){
		Session session=this.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		Category category=(Category)session.get(Category.class, 7);
		category.setCategoryName("面部护理");
		session.update(category);
		System.out.println(category);
		tx.commit();
		session.close();
	}
	
	//悲观锁
		@Test
		public void testPessimismLock(){
			Session session=this.getSessionFactory().openSession();
			//增加写锁
			Transaction tx = session.beginTransaction();
			Category category=(Category)session.get(Category.class, 9, LockMode.UPGRADE);
			category.setCategoryName("面部护理");
			session.update(category);
			System.out.println(category);
			tx.commit();
			session.close();
		}
}
