package com.bjsxt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.springframework.stereotype.Repository;

import com.bjsxt.plugin.TransactionPlugin;
@Repository("basic")
public class BasicInfoDAO {
	
	private TransactionPlugin tp=null;
	public void Insert(String id,String name) {
		Connection conn=null;
		try{
			
		conn=tp.getConnection();
		System.out.println(conn);
		PreparedStatement ps = conn.prepareStatement("insert into basicinfo(id,name) values(?,?)");
		ps.setString(1, id);
		ps.setString(2, name);
		int executeUpdate = ps.executeUpdate();
		System.out.println(executeUpdate);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	public TransactionPlugin getTp() {
		return tp;
	}
	public void setTp(TransactionPlugin tp) {
		this.tp = tp;
	}
}
