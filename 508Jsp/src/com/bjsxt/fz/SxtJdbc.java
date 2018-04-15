package com.bjsxt.fz;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/*
 * 问题1：
 * 	jdbc的使用链接参数和加载驱动的代码是重复的；
 * 问题2：
 * 	jdbc的链接参数如果需要修改的话，必须修改源码；
 * 考虑封装：其实就是封装自己的工具类 
 * */
public class SxtJdbc {
	
	private static String url="";
	private static String user="";
	private static String pwd="";
	private static String driver="";
	//在类加载的时候给变量进行赋值  使用静态代码块儿
	static{
			//创建Properties类用于读取properties键值对文件
			Properties p=new Properties();
		try {
			//加载properties键值对文件
			p.load(SxtJdbc.class.getClassLoader().getResourceAsStream("jdbc.properties"));
			url=p.getProperty("url");
			user=p.getProperty("user");
			pwd=p.getProperty("pwd");
			driver=p.getProperty("driver");
			//加载驱动
			Class.forName(driver);	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	//封装获取链接对象
	public static Connection getConnection(){
		Connection conn=null;
		try {
		 conn	= DriverManager.getConnection(url,user,pwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;		
	}
	//获取statement对象
	public static Statement getStatement(Connection conn){
		Statement st=null;
		try {
			st = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return st;
	}	
	//获取PreparedStatement对象
	public static PreparedStatement getPreparedStatement(Connection conn,String sql){
		PreparedStatement ps=null;
		try {
			ps = conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ps;
	}
	//关闭资源
	public static void closeAll(Connection conn,Statement st,ResultSet rs){
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}