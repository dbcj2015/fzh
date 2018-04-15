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

	//将所有的需要的信息都写入到配置文件中，类加载的时候加载
	//加载驱动程序
	static{
		Properties prop = new Properties();
		try {
			//使用DBUtil的类加载器加载配置文件
			prop.load(DBUtil.class.getClassLoader().getResourceAsStream("db.properties"));

			String dbtype = prop.getProperty("dbtype");
			
			url = prop.getProperty(dbtype+"url");
			user = prop.getProperty(dbtype+"name");
			password = prop.getProperty(dbtype+"pwd");
			String driverStr = prop.getProperty(dbtype+"driver");

			//加载驱动
			Class.forName(driverStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	//创建连接的方法
	//	Connection getConnection(){
	//		try {
	//			return DriverManager.getConnection(url, user, password);
	//		} catch (SQLException e) {
	//			// TODO Auto-generated catch block
	//			e.printStackTrace();
	//		}
	//		return null;
	//	}

	//创建连接的方法
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

	//创建发送器
	public static Statement getStatement(Connection conn){
		Statement stmt = null;

		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stmt;
	}

	//创建预编译的发送器
	public static PreparedStatement getPreparedStatement(Connection conn,String sql){
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pstmt;
	}

	//关闭所有资源
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


	//得到主键 UUID
	public static String getUUID(){
		return UUID.randomUUID().toString().replace("-", "");
	}

	//判断num 是否为质数
	public static boolean isPrime(int num){
		boolean isprime=true;
		int len=num/2;//没必要比较到num
		for(int i=2;i<=len;i++){
			if(num%i==0){
				isprime=false;
				break;
			}
		}
		return isprime;
	}
	
	//PreparedStatement 动态绑定参数
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
