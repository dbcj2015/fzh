package com.bjsxt.uploaddaoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bjsxt.entry.User;
import com.bjsxt.fz.DBUtil;
import com.bjsxt.uploadService.DownLoadService;
import com.bjsxt.uploaddao.DownLoadDao;

public class DownLoadDaoImp implements DownLoadDao{

	@Override
	public User selectUserInfo(String uid) {

		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		User user=null;
		try {
			String sql="select * from upload where uid=?";
			conn=DBUtil.getConnection();
			ps=DBUtil.getPreparedStatement(conn, sql);
			ps.setString(1, uid);
			rs=ps.executeQuery();
			while(rs.next()){
				user=new User();
				user.setUid(rs.getInt("uid"));
				user.setName(rs.getString("uname"));
				user.setPwd(rs.getInt("pwd"));
				user.setRealName(rs.getString("realName"));
				user.setPhotoName(rs.getString("photoName"));
				user.setType(rs.getString("type"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		DBUtil.closeAll(conn, rs, ps);
		return user;
	
	}

	
}
