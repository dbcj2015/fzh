package com.bjsxt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

import com.bjsxt.fz.SxtJdbc;

public class SelDao {

	public ArrayList<String> getCityName() {
		Connection conn=SxtJdbc.getConnection();
		String sql="select cname from city";
		PreparedStatement ps=SxtJdbc.getPreparedStatement(conn, sql);
		ArrayList<String> list=null;
		try {
			ResultSet rs=ps.executeQuery();
			list=new ArrayList<String>();
			while(rs.next()){
				list.add(rs.getString("cname"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
