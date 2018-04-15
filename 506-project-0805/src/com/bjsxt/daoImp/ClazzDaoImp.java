package com.bjsxt.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bjsxt.dao.ClazzDao;
import com.bjsxt.entry.User;
import com.bjsxt.fz.SxtJdbcUtil;

public class ClazzDaoImp implements ClazzDao{
	//声明jdbc对象
			Connection conn=null;
			PreparedStatement ps=null;
			ResultSet rs=null;
	//获取所有的学生信息
	@Override
	public ArrayList<User> getClazzInfo(String rid) {
		ArrayList<User> list=null;
		//给对象赋值
		try {
			conn=SxtJdbcUtil.getConnetion();
			//创建sql
				if(rid!=null){
					String sql="select u.*,u1.uname 'pname',r.rname from user u, user u1,role r where u.pnumber=u1.unumber and u.rid=r.rid and u.rid=?";
					ps=SxtJdbcUtil.getPreparedStatement(conn, sql);
					ps.setString(1,rid);
				}else{
					String sql="select u.*,u1.uname 'pname',r.rname from user u, user u1,role r where u.pnumber=u1.unumber and u.rid=r.rid";
					ps=SxtJdbcUtil.getPreparedStatement(conn, sql);
				}
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
				u.setPname(rs.getString("pname"));
				u.setRname(rs.getString("rname"));
				list.add(u);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		//关闭资源
		return list;
	}

}
