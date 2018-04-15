package com.bjsxt.loginDao01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bjsxt.util.DBUtil;
//class¿‡
public class loginDao {
	
	public static int checkLoginInfo(String name,String pwd) throws Exception{
		Connection conn = DBUtil.getConnection();
		String sql="select * from user01 where name=? and pwd=?";
		PreparedStatement pstmt = DBUtil.getPreparedStatement(conn, sql);
		pstmt.setString(1, name);
		pstmt.setString(2, pwd);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()){
			System.out.println(rs.getInt(1));
			return rs.getInt("id");
		}
		DBUtil.closeAll(conn, rs, pstmt);
		return -1;
		
	}

}
