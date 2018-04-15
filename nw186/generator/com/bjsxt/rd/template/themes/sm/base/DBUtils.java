package com.bjsxt.rd.template.themes.sm.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	public static Connection getConnection(){
		Connection conn = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/nw185?useUnicode=true&characterEncoding=UTF-8" , "root" , "root");
			conn.setAutoCommit(false);
		}catch(Exception e){
			//运行时异常RuntimeException与Exception最大的区别是不需要强行throws抛出
			throw new RuntimeException(e);
		}
		return conn;
	}
	
	public static void closeConnection(Connection conn){
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
}
