package com.bjsxt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import org.springframework.stereotype.Repository;
import com.bjsxt.plugin.TransactionPlugin;

@Repository("job")
public class JobInfoDAO {
	private TransactionPlugin tp=null;
	public void Insert(String id,String company) {
		Connection conn=null;
		try{
		conn=tp.getConnection();
		System.out.println("JobInfoDAO:"+conn);
		PreparedStatement ps = conn.prepareStatement("insert into jobinfo(id,company) values(?,?)");
		ps.setString(1, id);
		ps.setString(2, company);
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
