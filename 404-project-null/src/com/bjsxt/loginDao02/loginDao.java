package com.bjsxt.loginDao02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bjsxt.util.DBUtil;
//class��
public class loginDao {
	public static int checkLoginInfo(String str) throws Exception{
		//���ݿ��в�ѯ������:���Զ����ַ���ת��Ϊ��Ӧ��number�����ֶ�
		Connection conn = DBUtil.getConnection();
		String sql="select * from user01 where name=? ";
		PreparedStatement pstmt = DBUtil.getPreparedStatement(conn, sql);
		pstmt.setString(1, str);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			int id=rs.getInt(1);
			return id;
		}
		DBUtil.closeAll(conn, rs, pstmt);
		return -1;
		
	}

	public String checkUserName(String id) throws Exception {
		Connection conn = DBUtil.getConnection();
		String sql="select * from user01 where id=?";
		PreparedStatement pstmt = DBUtil.getPreparedStatement(conn, sql);
		pstmt.setString(1, id);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			String uname=rs.getString("name");
			return uname;
		}
		DBUtil.closeAll(conn, rs, pstmt);
		return null;
	}

}
