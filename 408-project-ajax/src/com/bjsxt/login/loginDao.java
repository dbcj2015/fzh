package com.bjsxt.login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;


public class loginDao extends HttpServlet {

	public String checkUserInfo(String uname) throws Exception {
		Connection conn = DBUtil.getConnection();
		String sql="select name from user01 where name=?";
		PreparedStatement pstmt = DBUtil.getPreparedStatement(conn, sql);
		pstmt.setString(1, uname);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			return rs.getString("name");
		}
		DBUtil.closeAll(conn, rs, pstmt);
		return null;
	}
	
}
