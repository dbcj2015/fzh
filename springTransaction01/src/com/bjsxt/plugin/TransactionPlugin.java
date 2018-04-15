package com.bjsxt.plugin;

import java.sql.Connection;
import java.sql.DriverManager;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;
@Component
public class TransactionPlugin {
	//线程本地变量，用于存储连接对象
	private ThreadLocal<Connection> tl=new ThreadLocal<Connection>();
	public Connection getConnection(){
		Connection conn=null;
		if(tl.get()==null){
			try{
			Class.forName("com.mysql.jdbc.Driver");
			// 2. 利用DriverManager设备管理器来打开数据库连接
			String url = "jdbc:mysql://127.0.0.1:3306/springtransaction?useUnicode=true&characterEncoding=UTF-8";
			conn = DriverManager.getConnection(url, "root", "root");
			conn.setAutoCommit(false);
			tl.set(conn);//将对象存放到当前的线程中
			}catch(Exception e){
				throw new RuntimeException(e);
			}
		}else{
			conn=tl.get();
		}
		//返回的是线程中存储的Connection对象
		return conn;
	}
	
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("插件已经生效");
		Object ret = null;
		Connection conn = null;
		try{
			conn = this.getConnection();//方法执行前打开数据库连接
			System.out.println("插件中conn:"+conn);
			ret = pjp.proceed();//执行目标方法
			conn.commit();//方法执行成功则提交
			System.out.println(conn + "连接事务提交成功");
		}catch(Throwable t){
			conn.rollback();//方法执行成功则回滚
			System.out.println(conn + "连接事务提交以回滚");
			throw t;
		}finally{
			System.out.println(conn + "连接以关闭");
			if(conn != null && !conn.isClosed()){
				conn.close();
				tl.remove();//将当前线程中的Connection对象干掉.
			}
			
		}
		return ret;
	}
}
