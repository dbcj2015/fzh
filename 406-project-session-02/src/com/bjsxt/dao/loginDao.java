package com.bjsxt.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;

import com.bjsxt.fz.DBUtil;
import com.bjsxt.vo.User;


public class loginDao extends HttpServlet {

//	public int checkUserInfo(String uname) throws Exception {
//		Connection conn = DBUtil.getConnection();
//		String sql="select id from user01 where name=?";
//		PreparedStatement pstmt = DBUtil.getPreparedStatement(conn, sql);
//		pstmt.setString(1, uname);
//		ResultSet rs = pstmt.executeQuery();
//		while(rs.next()){
//			return rs.getInt("id");
//		}
//		DBUtil.closeAll(conn, rs, pstmt);
//		return -1;
//	}
	public User getUserInfo(String str) throws Exception {
		Connection conn = DBUtil.getConnection();
		String sql="select * from user01 where name=?";
		PreparedStatement pstmt = DBUtil.getPreparedStatement(conn, sql);
		pstmt.setString(1, str);
		ResultSet rs = pstmt.executeQuery();
		User user=null;
		while(rs.next()){
			user=new User(rs.getString("id"), rs.getString("name"), rs.getString("fav"), rs.getString("addr"));
			return user;
		}
		DBUtil.closeAll(conn, rs, pstmt);
		return null;
	}
	
	public User checkUserInfo(String id) throws Exception {
		Connection conn = DBUtil.getConnection();
		String sql="select * from user01 where id=?";
		PreparedStatement pstmt = DBUtil.getPreparedStatement(conn, sql);
		pstmt.setString(1, id);
		ResultSet rs = pstmt.executeQuery();
		User user=null;
		while(rs.next()){
			user=new User(rs.getString("id"), rs.getString("name"), rs.getString("fav"), rs.getString("addr"));
			return user;
		}
		DBUtil.closeAll(conn, rs, pstmt);
		return null;
	}
}
