package com.bjsxt.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bjsxt.dao.GroupDao;
import com.bjsxt.entry.Sign;
import com.bjsxt.entry.User;
import com.bjsxt.fz.SxtJdbcUtil;

public class GroupDaoImp implements GroupDao{
	//声明jdbc对象
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
	@Override
	public ArrayList<User> getGroupInfo(int unumber) {
	
		ArrayList<User> list=null;
		//给对象赋值
		try {
			conn=SxtJdbcUtil.getConnetion();
			//创建sql
			String sql="select * from user where pnumber=?";
			ps=SxtJdbcUtil.getPreparedStatement(conn, sql);
			//给占位符赋值
			ps.setInt(1,unumber);
			//开始查询
			rs=ps.executeQuery();
			list=new ArrayList<User>();
			//遍历
			while(rs.next()){
				//创建User对象
				User u=new User();
				u.setUnumber(rs.getInt("unumber"));
				u.setUname(rs.getString("uname"));
				u.setUpwd(rs.getString("upwd"));
				u.setUsex(rs.getString("usex"));
				u.setUage(rs.getInt("uage"));
				u.setUaddress(rs.getString("uaddress"));
				u.setRid(rs.getInt("rid"));
				u.setPnumber(rs.getInt("pnumber"));	
				list.add(u);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		//关闭资源
		return list;
	}
	//获取签到签退信息
	@Override
	public ArrayList<Sign> getSignInfo(String unumber,String page) {
		
		ArrayList<Sign> list=null;
		//给对象赋值
		try {
			conn=SxtJdbcUtil.getConnetion();
			//创建sql
			String sql="select * from sign where unumber=? order by sdate desc limit ?,5";
			ps=SxtJdbcUtil.getPreparedStatement(conn, sql);
			//给占位符赋值
			ps.setString(1,unumber);
			ps.setInt(2, 5*Integer.parseInt(page)-5);
			//开始查询
			rs=ps.executeQuery();
			list=new ArrayList<Sign>();
			//遍历
			while(rs.next()){
				//创建User对象
				Sign s=new Sign();
				s.setSid(rs.getInt("sid"));
				s.setUnumber(rs.getInt("unumber"));
				s.setSintime(rs.getString("sintime"));
				s.setSinstatus(rs.getString("sinstatus"));
				s.setSouttime(rs.getString("souttime"));
				s.setSoutstatus(rs.getString("soutstatus"));
				s.setSdate(rs.getString("sdate"));
				list.add(s);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		//关闭资源
		return list;
	}
	//获取用户签到签退总条数
	@Override
	public int getCountInfo(String unumber) {
		try {
			conn=SxtJdbcUtil.getConnetion();
			String sql="select count(*) from sign where unumber=?";
			ps=SxtJdbcUtil.getPreparedStatement(conn, sql);
			ps.setString(1,unumber);
			rs=ps.executeQuery();
			if(rs.next()){
				return rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return -1;
	}

}
