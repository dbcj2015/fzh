package com.bjsxt.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bjsxt.dao.DeptDao;
import com.bjsxt.dao.EmpDao;
import com.bjsxt.entity.Emp;
import com.google.gson.Gson;
@Service("service")
//�������������ļ���ʱ�������з�����Ĭ�Ͽ���\�ύ\�ع�����,���ڷ����ϵ�ʱ��ֻ�ǵ�ǰ������Ч
//Ĭ����Ϊ��,Spring����ʽ��������RuntimeException�Ż�ع�,��Ϊ�˱���CZB�Ĵ��,�ǵ�д��rollBackFor=Exception.class
@Transactional(rollbackFor=Exception.class)
//rollbackFor=Exception.class�������Զ��κ��쳣�ع�
public class TestService {
	
	@Resource(name="empDao")
	private EmpDao dao=null;
	@Resource(name="deptDao")
	private DeptDao dept=null;
	//����Ҫ��������
	//@Transactional(propagation=Propagation.NOT_SUPPORTED , readOnly=true)
	@Transactional(rollbackFor=Exception.class)
	public Map<String,Object> findAll(Integer startPage,Integer rows){
		Integer startIndex=(startPage-1)*rows;
		List<Map> list = dao.findPage(startIndex, rows);
		//������ҳ��
		int cnt = dao.countAll();
		//datagrid����ֵ��һ��Map�������а���total,rows
		Map result=new HashMap();
		result.put("total", cnt);
		result.put("rows", list);
		return result;
	}
	
	public List findALLDept(){
		List<Map> findDept = dept.findDept();
		return findDept;
	}
	
	public void insertAll(Emp e){
		
			dao.insertAll(e);
		
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
//	public static void main(String[] args) throws Exception {
//		ApplicationContext acx=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
//		ServiceTest service =(ServiceTest) acx.getBean("service");
//		//System.out.println(new Gson().toJson(service.test()));
//		service.batchImport();
//	}
}
