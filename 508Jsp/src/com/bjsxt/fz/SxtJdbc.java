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
 * ����1��
 * 	jdbc��ʹ�����Ӳ����ͼ��������Ĵ������ظ��ģ�
 * ����2��
 * 	jdbc�����Ӳ��������Ҫ�޸ĵĻ��������޸�Դ�룻
 * ���Ƿ�װ����ʵ���Ƿ�װ�Լ��Ĺ����� 
 * */
public class SxtJdbc {
	
	private static String url="";
	private static String user="";
	private static String pwd="";
	private static String driver="";
	//������ص�ʱ����������и�ֵ  ʹ�þ�̬������
	static{
			//����Properties�����ڶ�ȡproperties��ֵ���ļ�
			Properties p=new Properties();
		try {
			//����properties��ֵ���ļ�
			p.load(SxtJdbc.class.getClassLoader().getResourceAsStream("jdbc.properties"));
			url=p.getProperty("url");
			user=p.getProperty("user");
			pwd=p.getProperty("pwd");
			driver=p.getProperty("driver");
			//��������
			Class.forName(driver);	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	//��װ��ȡ���Ӷ���
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
	//��ȡstatement����
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
	//��ȡPreparedStatement����
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
	//�ر���Դ
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