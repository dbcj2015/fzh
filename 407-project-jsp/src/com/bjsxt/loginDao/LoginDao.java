package com.bjsxt.loginDao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginDao extends HttpServlet {

	public ArrayList checkUserInfo() throws Exception {
		Connection conn = DBUtil.getConnection();
		String sql="select * from user01";
		PreparedStatement pstmt = DBUtil.getPreparedStatement(conn, sql);
		ResultSet rs = pstmt.executeQuery();
		ArrayList<User> list=new ArrayList<>();
		User user=null;
		while(rs.next()){
			String id=rs.getString("id");
			String name=rs.getString("name");
			String fav=rs.getString("fav");
			String addr=rs.getString("addr");
			user=new User(id, name, fav, addr);
			list.add(user);
		}
		DBUtil.closeAll(conn, rs, pstmt);
		return list;
	}
	
}
