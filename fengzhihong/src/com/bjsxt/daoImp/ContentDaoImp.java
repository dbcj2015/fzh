package com.bjsxt.daoImp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.bjsxt.dao.ContentDao;
import com.bjsxt.entity.Reply;
import com.bjsxt.util.DBException;
import com.bjsxt.util.DBUtils;


public class ContentDaoImp implements ContentDao{
	public List<Map> SelectContent(){
		List<Map> list=null;
		try {
			list = DBUtils.list("select * from t_topic");
		} catch (DBException e) {
			
			e.printStackTrace();
		}
		return list;
	}
	
	

	@Override
	public void insert(Reply r) {
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/icbc?useUnicode=true&characterEncoding=UTF-8";
			conn = DriverManager.getConnection(url, "root", "root");
			String sql="insert into t_reply(topic_id,author,content) values(?,?,?)";
			ps= conn.prepareStatement(sql);
			ps.setInt(1, r.getTopicId());
			ps.setString(2, r.getAuthor());
			ps.setString(3, r.getContnt());
			ps.execute();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	public static void main(String[] args) {
		ContentDaoImp imp=new ContentDaoImp();
		
		imp.updateClick(1);
	}



	@Override
	public Reply selectReply(String name) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/icbc?useUnicode=true&characterEncoding=UTF-8";
			conn = DriverManager.getConnection(url, "root", "root");
			String sql="select * from t_reply where author=?";
			ps= conn.prepareStatement(sql);
			ps.setString(1, name);
			rs=ps.executeQuery();
			Reply r=new Reply();
			while(rs.next()){
				r.setAuthor(rs.getString("author"));
				r.setContnt(rs.getString("content"));
			}
			return r;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}



	@Override
	public List<Map> selectReply(Integer topicIDd) {
		List<Map> list=null;
		try {
			list = DBUtils.list("select * from t_topic where topic_id=?",new Object[]{topicIDd});
		} catch (DBException e) {
			e.printStackTrace();
		}
		return list;
	}



	@Override
	public void updateClick(Integer topicId) {
		try {
			DBUtils.executeUpdate("update t_topic set click_amount=click_amount+1 where topic_id=?", new Object[]{topicId});
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
