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
//�������������ļ���ʱ�������з�����Ĭ�Ͽ���\�ύ\�ع�����,���ڷ����ϵ�ʱ��ֻ�ǵ�ǰ������Ч
//Ĭ����Ϊ��,Spring����ʽ��������RuntimeException�Ż�ع�,��Ϊ�˱���CZB�Ĵ��,�ǵ�д��rollBackFor=Exception.class
@Transactional(rollbackFor=Exception.class)
//rollbackFor=Exception.class�������Զ��κ��쳣�ع�
public class ServiceTest {
	
	@Resource(name="empDao")
	private EmpDao dao=null;
	
	//����Ҫ��������
	@Transactional(propagation=Propagation.NOT_SUPPORTED , readOnly=true)
	public List test(){
		return dao.findAll();
	}
	
	
	//@Transactional//�������ķ�ʽֻ�Ը÷�����Ч����exception�쳣�޷�ʵ�ֻع�
	public void batchImport() throws Exception{
		//����ʽ����:Ϊ�˱�����;�����쳣������£����������Ѿ��ύ
		//��������ʽ����֤��������쳣������µ�����ʵ�ֻع�
		for (int i = 0; i < 20; i++) {
			if(i==10){
				throw new Exception("��ȥ,���ֶ�����");
			}
			Emp e=new Emp();
			e.setComm(0f);
			e.setDeptno(10);
			e.setEname("Qiyi" + (i+1));
			e.setHiredate(new Date());
			e.setJob("����");
			e.setMgr(6666);
			e.setSal(20000f);
			dao.insertAll(e);
		}
	}
	
	//@Transactional//�������ķ�ʽֻ�Ը÷�����Ч��������RuntimeException�쳣�Żع�
//		public void batchImport(){
//			//����ʽ����:Ϊ�˱�����;�����쳣������£����������Ѿ��ύ
//			//��������ʽ����֤��������쳣������µ�����ʵ�ֻع�
//			for (int i = 0; i < 20; i++) {
//				if(i==10){
//					throw new RuntimeException("��������");
//				}
//				Emp e=new Emp();
//				e.setComm(0f);
//				e.setDeptno(10);
//				e.setEname("Qiyi" + (i+1));
//				e.setHiredate(new Date());
//				e.setJob("����");
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
