package com.bjsxt.fz;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.Properties;


public class SxtJdbcUtil {
     static String driver="";
     static String user="";
     static String url="";
     static String password="";
     
     static{
    	 //创建Properties配置文件读取对象
    	Properties ps = new Properties();
    	 //加载要读取的文件
    	try {
			ps.load(SxtJdbcUtil.class.getClassLoader().getResourceAsStream("jdbc.properties"));
		    //初始化JDBC参数
			driver=ps.getProperty("driver");
			user=ps.getProperty("user");
			url=ps.getProperty("url");
			password=ps.getProperty("password");
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
     
     //创建链接对象
     public static Connection getConnetion() {
    	 Connection conn = null;
    	 try {
			 conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 
		return conn;
     }
     //创建statement对象
     public static Statement getStatement(Connection conn) throws SQLException{
		
    	 return conn.createStatement(); 
     }
     //创建preparStatement对象
     public static PreparedStatement getPreparedStatement(Connection conn,String sql ) throws SQLException{
		PreparedStatement p = conn.prepareStatement(sql);
    	 return p;
     }
     //创建DML
     public static int excuteDML(String sql,Object...objs){
    	 //创建 Connection对象
    	 Connection conn = getConnetion();
		//创建perparedStatement对象
    	 PreparedStatement p =null;
    	 //声明变量记录执行结果
    	 int i=-1;
    	  try {
			 p= getPreparedStatement(conn, sql);
			 //给占位符赋值
			for (int j = 0; j < objs.length; j++) {
				p.setObject(j+1, objs[j]);
			}
			//执行sql命令
			 i = p.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i; 
     }
}
