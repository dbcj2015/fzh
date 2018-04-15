package com.bjsxt.homework;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.UUID;

public final class DBUtil {
	private DBUtil(){}
	private static String url;
	private static String user;
	private static String password;

	//�����е���Ҫ����Ϣ��д�뵽�����ļ��У�����ص�ʱ�����
	//������������
	static{
		Properties prop = new Properties();
		try {
			//ʹ��DBUtil������������������ļ�
			prop.load(DBUtil.class.getClassLoader().getResourceAsStream("db.properties"));

			String dbtype = prop.getProperty("dbtype");
			
			url = prop.getProperty(dbtype+"url");
			user = prop.getProperty(dbtype+"name");
			password = prop.getProperty(dbtype+"pwd");
			String driverStr = prop.getProperty(dbtype+"driver");

			//��������
			Class.forName(driverStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	//�������ӵķ���
	//	Connection getConnection(){
	//		try {
	//			return DriverManager.getConnection(url, user, password);
	//		} catch (SQLException e) {
	//			// TODO Auto-generated catch block
	//			e.printStackTrace();
	//		}
	//		return null;
	//	}

	//�������ӵķ���
	public static Connection getConnection(){
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	//����������
	public static Statement getStatement(Connection conn){
		Statement stmt = null;

		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stmt;
	}

	//����Ԥ����ķ�����
	public static PreparedStatement getPreparedStatement(Connection conn,String sql){
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pstmt;
	}

	//�ر�������Դ
	public static void closeAll(Connection conn , ResultSet rs , Statement stmt){
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if(stmt != null){
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}


	//�õ����� UUID
	public static String getUUID(){
		return UUID.randomUUID().toString().replace("-", "");
	}

	//�ж�num �Ƿ�Ϊ����
	public static boolean isPrime(int num){
		boolean isprime=true;
		int len=num/2;//û��Ҫ�Ƚϵ�num
		for(int i=2;i<=len;i++){
			if(num%i==0){
				isprime=false;
				break;
			}
		}
		return isprime;
	}
	
	//PreparedStatement ��̬�󶨲���
	public static void bindParams(PreparedStatement pstmt,Object ... args){
		try {
			for(int i=0;i<args.length;i++){
				pstmt.setObject(i+1, args[i]);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("DBUtil.bindParams()");
		}
		
	}
}
