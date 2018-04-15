package com.bjsxt.daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bjsxt.dao.UserDao;
import com.bjsxt.entry.User;
import com.bjsxt.fz.DBUtil;

public class UserDaoImp implements UserDao{

	@Override
	public User insertUserInfo(String uname,String unumber) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		User user=null;
		try {
			conn = DBUtil.getConnection();
			String sql="select * from user where unumber=? ";
			pstmt = DBUtil.getPreparedStatement(conn, sql);
			pstmt.setString(1, unumber);
			rs = pstmt.executeQuery();
			while(rs.next()){
				user=new User();
				user.setUnumber(rs.getInt("unumber"));
				user.setUname(rs.getString("uname"));
				user.setUpwd(rs.getString("upwd"));
				user.setUsex(rs.getString("usex"));
				user.setUage(rs.getInt("uage"));
				user.setUaddress(rs.getString("uaddress"));
				user.setRid(rs.getInt("rid"));
				user.setPnumber(rs.getInt("pnumber"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
			DBUtil.closeAll(conn, rs, pstmt);
			System.out.println(user);
			return user;
	}

}
