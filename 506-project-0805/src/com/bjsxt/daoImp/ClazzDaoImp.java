package com.bjsxt.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bjsxt.dao.ClazzDao;
import com.bjsxt.entry.User;
import com.bjsxt.fz.SxtJdbcUtil;

public class ClazzDaoImp implements ClazzDao{
	//����jdbc����
			Connection conn=null;
			PreparedStatement ps=null;
			ResultSet rs=null;
	//��ȡ���е�ѧ����Ϣ
	@Override
	public ArrayList<User> getClazzInfo(String rid) {
		ArrayList<User> list=null;
		//������ֵ
		try {
			conn=SxtJdbcUtil.getConnetion();
			//����sql
				if(rid!=null){
					String sql="select u.*,u1.uname 'pname',r.rname from user u, user u1,role r where u.pnumber=u1.unumber and u.rid=r.rid and u.rid=?";
					ps=SxtJdbcUtil.getPreparedStatement(conn, sql);
					ps.setString(1,rid);
				}else{
					String sql="select u.*,u1.uname 'pname',r.rname from user u, user u1,role r where u.pnumber=u1.unumber and u.rid=r.rid";
					ps=SxtJdbcUtil.getPreparedStatement(conn, sql);
				}
			//��ʼ��ѯ
			rs=ps.executeQuery();
			list=new ArrayList<User>();
			//����
			while(rs.next()){
				//����User����
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
		
		//�ر���Դ
		return list;
	}

}
