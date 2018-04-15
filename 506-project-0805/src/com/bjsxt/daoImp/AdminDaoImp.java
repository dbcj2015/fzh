package com.bjsxt.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bjsxt.dao.AdminDao;
import com.bjsxt.entry.Role;
import com.bjsxt.fz.SxtJdbcUtil;

public class AdminDaoImp implements AdminDao{
	
	
	//获取所有的角色信息
	@Override
	public ArrayList<Role> getRoleInfo() {
		//声明jdbc对象
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		ArrayList<Role> list=null;
		//给对象赋值
		try {
			conn=SxtJdbcUtil.getConnetion();
			//创建sql语句
			String sql="select * from role";
			ps=SxtJdbcUtil.getPreparedStatement(conn, sql);
			//开始查询
			rs=ps.executeQuery();
			//给list赋值
			list=new ArrayList<Role>();
			//遍历
			while(rs.next()){
				//创建role对象
				Role r=new Role();
				r.setRid(rs.getInt("rid"));
				r.setRname(rs.getString("rname"));
				r.setRdesc(rs.getString("rdesc"));
				list.add(r);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	//更新用户信息
	@Override
	public int updateUserInfo(String unumber, String rid, String pnumber) {
		//创建sql语句
		String sql="update user set rid=?,pnumber=? where unumber=?";
		return SxtJdbcUtil.excuteDML(sql, rid,pnumber,unumber);
	}
	//删除用户信息
	@Override
	public int deleteUserInfo(String unumber) {
		//创建sql语句
			String sql="delete from user where unumber=?";
		return SxtJdbcUtil.excuteDML(sql, unumber);
	}
	//将用户数据插入到数据库中
	@Override
	public int insertUserInfo(String[] udata) {
		String  sql="insert into user values(?,?,?,?,?,?,?,?)";
		return SxtJdbcUtil.excuteDML(sql, udata);
	}

}
