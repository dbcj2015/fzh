package com.bjsxt.homework;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JQueryAjaxLoginDao {

	public String checkUserInfo(String str) throws Exception {
		Connection conn = DBUtil.getConnection();
		String sql="select name from user01 where name=?";
		PreparedStatement pstmt = DBUtil.getPreparedStatement(conn, sql);
		pstmt.setString(1, str);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			return rs.getString("name");
		}
		DBUtil.closeAll(conn, rs, pstmt);
		return null;
	}

}
