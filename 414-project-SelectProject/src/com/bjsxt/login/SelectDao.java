package com.bjsxt.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SelectDao {

	public ArrayList getAddrInfo(String str) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<Select> list=new ArrayList();
		Select sel=null;
		try {
			conn = DBUtil.getConnection();
			String sql="select * from area where parentid=?";
			pstmt = DBUtil.getPreparedStatement(conn, sql);
			pstmt.setString(1, str);
			rs=pstmt.executeQuery();
			while(rs.next()){
				sel=new Select();
				sel.setAreaid(rs.getInt("areaid"));
				sel.setArealevel(rs.getInt("arealevel"));
				sel.setAreaname(rs.getString("areaname"));
				sel.setParentid(rs.getInt("parentid"));
				sel.setStatus(rs.getInt("status"));
				list.add(sel);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtil.closeAll(conn, rs, pstmt);
		return list;
	}

}
