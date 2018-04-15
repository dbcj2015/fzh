package com.bjsxt.service;

import java.util.Date;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bjsxt.dao.EmpDao;
import com.bjsxt.entity.Emp;
import com.google.gson.Gson;
@Service("service")
//当把事务放在类的级别时代表所有方法均默认开启\提交\回滚事务,放在方法上的时候只是当前方法有效
//默认行为下,Spring声明式事务遇到RuntimeException才会回滚,而为了避免CZB的大坑,记得写上rollBackFor=Exception.class
@Transactional(rollbackFor=Exception.class)
//rollbackFor=Exception.class参数可以对任何异常回滚
public class ServiceTest {
	
	@Resource(name="empDao")
	private EmpDao dao=null;
	
	//不需要事务的情况
	@Transactional(propagation=Propagation.NOT_SUPPORTED , readOnly=true)
	public List test(){
		return dao.findAll();
	}
	
	
	//@Transactional//该声明的方式只对该方法有效，对exception异常无法实现回滚
	public void batchImport() throws Exception{
		//声明式事务:为了避免中途出现异常的情况下，部分数据已经提交
		//采用声明式事务保证代码出现异常的情况下的数据实现回滚
		for (int i = 0; i < 20; i++) {
			if(i==10){
				throw new Exception("我去,我又断网了");
			}
			Emp e=new Emp();
			e.setComm(0f);
			e.setDeptno(10);
			e.setEname("Qiyi" + (i+1));
			e.setHiredate(new Date());
			e.setJob("叫兽");
			e.setMgr(6666);
			e.setSal(20000f);
			dao.insertAll(e);
		}
	}
	
	//@Transactional//该声明的方式只对该方法有效，并且是RuntimeException异常才回滚
//		public void batchImport(){
//			//声明式事务:为了避免中途出现异常的情况下，部分数据已经提交
//			//采用声明式事务保证代码出现异常的情况下的数据实现回滚
//			for (int i = 0; i < 20; i++) {
//				if(i==10){
//					throw new RuntimeException("哈哈断网");
//				}
//				Emp e=new Emp();
//				e.setComm(0f);
//				e.setDeptno(10);
//				e.setEname("Qiyi" + (i+1));
//				e.setHiredate(new Date());
//				e.setJob("叫兽");
//				e.setMgr(6666);
//				e.setSal(20000f);
//				dao.insertAll(e);
//			}
//		}
	public static void main(String[] args) throws Exception {
		ApplicationContext acx=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		ServiceTest service =(ServiceTest) acx.getBean("service");
		//System.out.println(new Gson().toJson(service.test()));
		service.batchImport();
	}
}
