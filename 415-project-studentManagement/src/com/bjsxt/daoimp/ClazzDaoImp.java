package com.bjsxt.daoimp;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bjsxt.dao.ClazzDao;
import com.bjsxt.entry.User;
import com.bjsxt.fz.DBUtil;

public class ClazzDaoImp implements ClazzDao{
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs=null;
	@Override
	public ArrayList<User> getClazzInfo(String rid) {
		ArrayList<User> list=null;
		try {
			conn = DBUtil.getConnection();
			if(rid!=null){
				String sql="select u1.*,r.rname 'rname',u2.uname 'pname' from user u1,user u2,role r where u1.pnumber=u2.unumber and u1.rid=r.rid and r.rid=?";
				ps = DBUtil.getPreparedStatement(conn, sql);
				ps.setString(1, rid);
			}else{
				String sql="select u1.*,r.rname 'rname',u2.uname 'pname' from user u1,user u2,role r where u1.pnumber=u2.unumber and u1.rid=r.rid";
				ps = DBUtil.getPreparedStatement(conn, sql);	
			}
			rs=ps.executeQuery();
			list=new ArrayList<User>();
			User user=null;
			while(rs.next()){
				user=new User();
				user.setUnumber(rs.getInt("unumber"));
				user.setUname(rs.getString("uname"));
				user.setUage(rs.getInt("uage"));
				user.setUsex(rs.getString("usex"));
				user.setUpwd(rs.getString("upwd"));
				user.setUaddress(rs.getString("uaddress"));
				user.setRid(rs.getInt("rid"));
				user.setPnumber(rs.getInt("pnumber"));
				user.setRname(rs.getString("rname"));
				user.setPname(rs.getString("pname"));
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtil.closeAll(conn, rs, ps);
		return list;
	
	}

}
