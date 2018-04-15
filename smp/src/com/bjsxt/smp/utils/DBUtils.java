package com.bjsxt.smp.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DBUtils {
	//...代表可选参数，这个参数可以是一个数组也可以是一个单个对象，甚至可以被忽略
	public static List<Map> list(String sql , Object... params) throws DBException{
		Connection conn = null;
		List result = null;
		try{
			//JDBC使用步骤
			//1. Class.forName加载JDBC驱动类
			Class.forName("com.mysql.jdbc.Driver");
			//2. 利用DriverManager设备管理器来打开数据库连接
			String url = "jdbc:mysql://127.0.0.1:3306/ptcal?useUnicode=true&characterEncoding=UTF-8";
			conn = DriverManager.getConnection(url, "root", "");
			//3.利用PreparedStatement来预加载SQL语句，PreparedStatement支持参数化查询
			//limit 0,100 从第一行开始，向后取100行
			//SQL注入:SELECT * FROM t_card_op_log where card_no = '' or 1=1  or '' limit 0,100
			PreparedStatement pstmt = conn.prepareStatement(sql); //忘掉createStatement吧，因为它不支持参数
			//如果有参数则设置参数
			if(params!= null && params.length>0){
				for(int i=1 ; i <= params.length ; i++){
					pstmt.setObject(i, params[i-1]);
				}
			}
			
			//4. 获取查询结果ResultSet，获取查询结果
			ResultSet rs = pstmt.executeQuery();
			//遍历结果集中所有列名，注意下标从1开始
			List<String> columns = new ArrayList();
			for(int i = 1 ; i <= rs.getMetaData().getColumnCount() ; i++){
				columns.add(rs.getMetaData().getColumnName(i));
			}
			result = new ArrayList();//实例化结果集
			while(rs.next()){
				Map rec = new LinkedHashMap();//链表形式的HashMap，保证读取出来的顺序与存放时一致
				for(String colname : columns){
					Object val = rs.getObject(colname);
					rec.put(colname, val);
				}
				result.add(rec);
			}
		}catch(Exception e){
			throw new DBException(e);
		}finally{
			//5.关闭数据库连接
			try {
				if(conn != null && !conn.isClosed()){
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
			}
		}
		return result;
	}
	
	
	
	public static void executeUpdate(String sql , Object... params) throws DBException{
		Connection conn = null;
		try{

			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/ptcal?useUnicode=true&characterEncoding=UTF-8";
			conn = DriverManager.getConnection(url, "root", "");
			PreparedStatement pstmt = conn.prepareStatement(sql); //忘掉createStatement吧，因为它不支持参数
			if(params!= null && params.length>0){
				for(int i=1 ; i <= params.length ; i++){
					pstmt.setObject(i, params[i-1]);
				}
			}
			pstmt.executeUpdate();
		}catch(Exception e){
			throw new DBException(e);
		}finally{
			//5.关闭数据库连接
			try {
				if(conn != null && !conn.isClosed()){
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
			}
		}
	}
	
	
	
	
	
	public static void main(String[] args) {
		//离线结果集，不依赖于Connection的结果集适用于小数据量的访问，大数据量下还是需要while(rs.next())进行处理，处理后立即释放
		
		List<Map> list = null;
		try {
			list = DBUtils.list("select * from t_card_op_log where op_id = ?" , new Object[]{21});
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(list);
	}
}

