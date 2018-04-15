package com.bjsxt.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcClazz {
	public static void main(String[] args) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://127.0.0.1:3306/icbc?useUnicode=true&characterEncoding=UTF-8";
			conn = DriverManager.getConnection(url,"root","root");
			String sql="select * from t_card_op_log limit 0,10";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				System.out.println(rs.getInt("op_id")+":"+rs.getString("card_no")+":"+rs.getInt("oper_no")+":"+rs.getInt("amt")+":"+rs.getString("op_date"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
	}
}
