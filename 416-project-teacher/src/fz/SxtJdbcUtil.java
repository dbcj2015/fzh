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
    	 //����Properties�����ļ���ȡ����
    	Properties ps = new Properties();
    	 //����Ҫ��ȡ���ļ�
    	try {
			ps.load(SxtJdbcUtil.class.getClassLoader().getResourceAsStream("jdbc.properties"));
		    //��ʼ��JDBC����
			driver=ps.getProperty("driver");
			user=ps.getProperty("user");
			url=ps.getProperty("url");
			password=ps.getProperty("password");
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
     
     //�������Ӷ���
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
     //����statement����
     public static Statement getStatement(Connection conn) throws SQLException{
		
    	 return conn.createStatement(); 
     }
     //����preparStatement����
     public static PreparedStatement getPreparedStatement(Connection conn,String sql ) throws SQLException{
		PreparedStatement p = conn.prepareStatement(sql);
    	 return p;
     }
     //����DML
     public static int excuteDML(String sql,Object...objs){
    	 //���� Connection����
    	 Connection conn = getConnetion();
		//����perparedStatement����
    	 PreparedStatement p =null;
    	 //����������¼ִ�н��
    	 int i=-1;
    	  try {
			 p= getPreparedStatement(conn, sql);
			 //��ռλ����ֵ
			for (int j = 0; j < objs.length; j++) {
				p.setObject(j+1, objs[j]);
			}
			//ִ��sql����
			 i = p.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i; 
     }
}
