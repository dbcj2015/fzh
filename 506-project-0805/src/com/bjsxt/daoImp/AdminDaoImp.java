package com.bjsxt.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bjsxt.dao.AdminDao;
import com.bjsxt.entry.Role;
import com.bjsxt.fz.SxtJdbcUtil;

public class AdminDaoImp implements AdminDao{
	
	
	//��ȡ���еĽ�ɫ��Ϣ
	@Override
	public ArrayList<Role> getRoleInfo() {
		//����jdbc����
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		ArrayList<Role> list=null;
		//������ֵ
		try {
			conn=SxtJdbcUtil.getConnetion();
			//����sql���
			String sql="select * from role";
			ps=SxtJdbcUtil.getPreparedStatement(conn, sql);
			//��ʼ��ѯ
			rs=ps.executeQuery();
			//��list��ֵ
			list=new ArrayList<Role>();
			//����
			while(rs.next()){
				//����role����
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
	//�����û���Ϣ
	@Override
	public int updateUserInfo(String unumber, String rid, String pnumber) {
		//����sql���
		String sql="update user set rid=?,pnumber=? where unumber=?";
		return SxtJdbcUtil.excuteDML(sql, rid,pnumber,unumber);
	}
	//ɾ���û���Ϣ
	@Override
	public int deleteUserInfo(String unumber) {
		//����sql���
			String sql="delete from user where unumber=?";
		return SxtJdbcUtil.excuteDML(sql, unumber);
	}
	//���û����ݲ��뵽���ݿ���
	@Override
	public int insertUserInfo(String[] udata) {
		String  sql="insert into user values(?,?,?,?,?,?,?,?)";
		return SxtJdbcUtil.excuteDML(sql, udata);
	}

}
