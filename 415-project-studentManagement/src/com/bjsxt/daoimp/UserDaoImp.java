package com.bjsxt.daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bjsxt.dao.UserDao;
import com.bjsxt.entry.Menu;
import com.bjsxt.entry.User;
import com.bjsxt.fz.DBUtil;

public class UserDaoImp implements UserDao{

	public User checkUserLoginInfo(String unumber, String upwd) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		User user=null;
		try {
			conn = DBUtil.getConnection();
			String sql="select * from user where unumber=? and upwd=?";
			pstmt = DBUtil.getPreparedStatement(conn, sql);
			pstmt.setString(1, unumber);
			pstmt.setString(2, upwd);
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

	@Override
	public ArrayList getUserMenuInfo(int rid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		Menu menu=null;
		ArrayList<Menu> list=null;
		try {
			conn = DBUtil.getConnection();
			String sql="select m.mid,m.mname,m.murl from menu m,rm r where r.mid=m.mid and r.rid=?";
			pstmt = DBUtil.getPreparedStatement(conn, sql);
			pstmt.setInt(1, rid);
			rs = pstmt.executeQuery();
			list=new ArrayList<>();
			while(rs.next()){
				menu=new Menu();
				menu.setMid(rs.getInt("mid"));
				menu.setMname(rs.getString("mname"));
				menu.setMurl(rs.getString("murl"));
				list.add(menu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
			DBUtil.closeAll(conn, rs, pstmt);
			System.out.println(list);
			return list;
	}
	
	//将签到信息插入到数据库中
	@Override
	public int insertInInfo(String unumber, String inTime, String inDate,String inStatus) {
		String sql="insert into sign(unumber,sinstatus,sintime,sdate) values(?,?,?,?)";
		int i=DBUtil.excuteDML(sql,unumber,inStatus,inTime,inDate);
		System.out.println(i);
		return i;
	}
	//签到之前判断用户是否已经签到
	@Override
	public boolean checkSignInfo(String unumber, String inDate) {
		System.out.println("数据库中的得到的信息为:"+unumber+inDate);
		boolean flag=false;
		Connection conn = null;
		String sql="select sintime from sign where unumber=? and sdate=?";
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		try {
			conn = DBUtil.getConnection();
			pstmt = DBUtil.getPreparedStatement(conn, sql);
			pstmt.setString(1, unumber);
			pstmt.setString(2, inDate);
			rs=pstmt.executeQuery();
			if(rs.next()){
				flag=true;
			}else{
				flag=false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	
	//将签退信息插入到数据库中
	@Override
	public int insertOutInfo(String unumber, String inTime, String inDate,String outStatus) {
		String sql="update sign set souttime=?,soutstatus=? where unumber=? and sdate=?";
		//顺序不可以混乱
		int i = DBUtil.excuteDML(sql, inTime,outStatus,unumber,inDate);
		return i;
	}
	//获取用户上级姓名以及用户角色信息
	@Override
	public String getRnameInfo(String rid) {
		Connection conn = null;
		String sql="select rname from role where rid=?";
		PreparedStatement ps = null;
		ResultSet rs=null;
		String rname=null;
		try {
			conn = DBUtil.getConnection();
			ps = DBUtil.getPreparedStatement(conn, sql);
			ps.setString(1, rid);
			rs = ps.executeQuery();
			while(rs.next()){
				rname=rs.getString("rname");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		DBUtil.closeAll(conn, rs, ps);
		return rname;
	}
	//获取上级姓名信息
	@Override
	public String getUnameInfo(String pnumber) {
		Connection conn = null;
		String sql="select uname from user where unumber=?";
		PreparedStatement ps = null;
		ResultSet rs=null;
		String uname=null;
		try {
			conn = DBUtil.getConnection();
			ps = DBUtil.getPreparedStatement(conn, sql);
			ps.setString(1, pnumber);
			rs = ps.executeQuery();
			while(rs.next()){
				uname=rs.getString("uname");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		DBUtil.closeAll(conn, rs, ps);
		return uname;
	}
	//更新用户密码信息
	@Override
	public int updateNewPwdInfo(String newPwd, int unumber) {
		String sql="update user set upwd=? where unumber=?";
		return DBUtil.excuteDML(sql, newPwd,unumber);
	}

	
	
}
