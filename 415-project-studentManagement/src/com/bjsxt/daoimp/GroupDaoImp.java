package com.bjsxt.daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bjsxt.dao.GroupDao;
import com.bjsxt.entry.Sign;
import com.bjsxt.entry.User;
import com.bjsxt.fz.DBUtil;

public class GroupDaoImp implements GroupDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs=null;
	//获取所有组员信息
	@Override
	public ArrayList<User> getGroupInfo(int unumber) {
		
		
		ArrayList<User> list=null;
		try {
			conn = DBUtil.getConnection();
			String sql="select * from user where pnumber=?";
			ps = DBUtil.getPreparedStatement(conn, sql);
			ps.setInt(1, unumber);
			rs = ps.executeQuery();
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
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtil.closeAll(conn, rs, ps);
		return list;
	}
	
	//获取用户签到签退信息
	@Override
	public ArrayList<Sign> getUserSignInfo(String unumber,String page) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		ArrayList<Sign> list=null;
		try {
			conn = DBUtil.getConnection();
			String sql="select * from sign where unumber=? limit ?,5";
			ps = DBUtil.getPreparedStatement(conn, sql);
			ps.setString(1, unumber);
			ps.setInt(2, 5*Integer.parseInt(page)-5);
			rs = ps.executeQuery();
			list=new ArrayList<Sign>();
			Sign sign=null;
			while(rs.next()){
				sign=new Sign();
				sign.setUnumber(rs.getInt("unumber"));
				sign.setSdate(rs.getString("sdate"));
				sign.setSinstatus(rs.getString("sinstatus"));
				sign.setSintime(rs.getString("sintime"));
				sign.setSoutstatus(rs.getString("soutstatus"));
				sign.setSouttime(rs.getString("souttime"));
				list.add(sign);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtil.closeAll(conn, rs, ps);
		return list;
	}
	//获取某个成员的签退签到的信息总数
	@Override
	public int getSignCount(String unumber) {
		int pageCount=0;
		try {
			conn = DBUtil.getConnection();
			String sql="select count(*) from sign where unumber=? ";
			ps = DBUtil.getPreparedStatement(conn, sql);
			ps.setString(1, unumber);
			rs = ps.executeQuery();
			while(rs.next()){
				pageCount=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtil.closeAll(conn, rs, ps);
		return pageCount;
	}
	
	
}
