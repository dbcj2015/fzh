package com.bjsxt.daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bjsxt.dao.AdminDao;
import com.bjsxt.entry.Role;
import com.bjsxt.fz.DBUtil;

public class AdminDaoImp implements AdminDao{
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	ArrayList<Role> list=null;

	@Override
	public ArrayList<Role> selectRoleInfo() {
		try {
			conn = DBUtil.getConnection();
			String sql="select * from role";
			ps = DBUtil.getPreparedStatement(conn, sql);
			rs=ps.executeQuery();
			Role r=null;
			list=new ArrayList<>();
			while(rs.next()){
				r=new Role();
				r.setRid(rs.getInt("rid"));
				r.setRname(rs.getString("rname"));
				list.add(r);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		DBUtil.closeAll(conn, rs, ps);
		return list;
	}

}
