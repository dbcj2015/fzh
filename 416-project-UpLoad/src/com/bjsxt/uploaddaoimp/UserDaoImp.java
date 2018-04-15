package com.bjsxt.uploaddaoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bjsxt.entry.User;
import com.bjsxt.fz.DBUtil;
import com.bjsxt.uploaddao.UserDao;

public class UserDaoImp implements UserDao{

	@Override
	public ArrayList<User> selectUserInfo() {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		ArrayList list=null;
		try {
			String sql="select * from upload";
			conn=DBUtil.getConnection();
			ps=DBUtil.getPreparedStatement(conn, sql);
			rs=ps.executeQuery();
			list=new ArrayList<>();
			User user=null;
			while(rs.next()){
				user=new User();
				user.setUid(rs.getInt("uid"));
				user.setName(rs.getString("uname"));
				user.setPwd(rs.getInt("pwd"));
				user.setRealName(rs.getString("realName"));
				user.setPhotoName(rs.getString("photoName"));
				user.setType(rs.getString("type"));
				list.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		DBUtil.closeAll(conn, rs, ps);
		return list;
	}

}
