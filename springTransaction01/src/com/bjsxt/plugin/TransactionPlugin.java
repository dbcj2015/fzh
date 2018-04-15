package com.bjsxt.plugin;

import java.sql.Connection;
import java.sql.DriverManager;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;
@Component
public class TransactionPlugin {
	//�̱߳��ر��������ڴ洢���Ӷ���
	private ThreadLocal<Connection> tl=new ThreadLocal<Connection>();
	public Connection getConnection(){
		Connection conn=null;
		if(tl.get()==null){
			try{
			Class.forName("com.mysql.jdbc.Driver");
			// 2. ����DriverManager�豸�������������ݿ�����
			String url = "jdbc:mysql://127.0.0.1:3306/springtransaction?useUnicode=true&characterEncoding=UTF-8";
			conn = DriverManager.getConnection(url, "root", "root");
			conn.setAutoCommit(false);
			tl.set(conn);//�������ŵ���ǰ���߳���
			}catch(Exception e){
				throw new RuntimeException(e);
			}
		}else{
			conn=tl.get();
		}
		//���ص����߳��д洢��Connection����
		return conn;
	}
	
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("����Ѿ���Ч");
		Object ret = null;
		Connection conn = null;
		try{
			conn = this.getConnection();//����ִ��ǰ�����ݿ�����
			System.out.println("�����conn:"+conn);
			ret = pjp.proceed();//ִ��Ŀ�귽��
			conn.commit();//����ִ�гɹ����ύ
			System.out.println(conn + "���������ύ�ɹ�");
		}catch(Throwable t){
			conn.rollback();//����ִ�гɹ���ع�
			System.out.println(conn + "���������ύ�Իع�");
			throw t;
		}finally{
			System.out.println(conn + "�����Թر�");
			if(conn != null && !conn.isClosed()){
				conn.close();
				tl.remove();//����ǰ�߳��е�Connection����ɵ�.
			}
			
		}
		return ret;
	}
}
