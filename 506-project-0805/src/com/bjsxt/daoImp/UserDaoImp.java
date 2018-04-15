package com.bjsxt.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bjsxt.dao.UserDao;
import com.bjsxt.entry.Menu;
import com.bjsxt.entry.User;
import com.bjsxt.fz.SxtJdbcUtil;


public class UserDaoImp implements UserDao{	
	//����jdbc����
	private	Connection conn=null;
	private	PreparedStatement ps=null;
	private	ResultSet rs=null;
	//�û���¼
	@Override
	public User checkLoginInfo(String unumber, String pwd) {
		
			User u=null;
		//������ֵ
			try {
				conn=SxtJdbcUtil.getConnetion();
				//����sql
				String sql="select * from user where unumber=? and upwd=?";
				ps=SxtJdbcUtil.getPreparedStatement(conn, sql);
				//��ռλ����ֵ
				ps.setString(1,unumber);
				ps.setString(2,pwd);
				//��ѯ
				rs=ps.executeQuery();
				//����
				if(rs.next()){
					//��u������и�ֵ
					u=new User();
					u.setUnumber(rs.getInt("unumber"));
					u.setUname(rs.getString("uname"));
					u.setUpwd(rs.getString("upwd"));
					u.setUsex(rs.getString("usex"));
					u.setUage(rs.getInt("uage"));
					u.setUaddress(rs.getString("uaddress"));
					u.setRid(rs.getInt("rid"));
					u.setPnumber(rs.getInt("pnumber"));	
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		
		//�ر���Դ
		return u;
	}
	//��ѯ�û��˵���Ϣ
	@Override
	public ArrayList<Menu> getMenuInfo(int rid) {
		//����list
		ArrayList<Menu> list=null;
		//��jdbc����ֵ
		try {
			conn=SxtJdbcUtil.getConnetion();
			//����sql
			String sql="select m.mid,m.mname,m.murl from rm r,menu m where r.mid=m.mid and rid=?";
			ps=SxtJdbcUtil.getPreparedStatement(conn, sql);
			//��ռλ����ֵ
			ps.setInt(1,rid);
			//��ʼ��ѯ
			rs=ps.executeQuery();
			//��list��ֵ
			list=new ArrayList<Menu>();
			//����
			while(rs.next()){
				//����Menu����
				Menu m=new Menu();
				m.setMid(rs.getInt("mid"));
				m.setMname(rs.getString("mname"));
				m.setMurl(rs.getString("murl"));
				list.add(m);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		//�ر���Դ
		return list;
	}
	//�û�ǩ����Ϣ����
	@Override
	public int insertSignInInfo(String unumber, String inTime, String indate,String inStatus) {
		//����Sql���
		String sql="insert into sign(unumber,sintime,sinstatus,sdate)values(?,?,?,?)";
		//����DML���������ݲ��뵽���ݿ���
		int i=SxtJdbcUtil.excuteDML(sql,unumber,inTime,inStatus,indate);
		return i;
	}
	//��ѯ�û��Ƿ�ǩ��
	@Override
	public boolean checkSignInInfo(String unumber, String indate) {
		//�������
		boolean flag=false;
		//��������ֵ
		try {
			conn=SxtJdbcUtil.getConnetion();
			//����sql
			String sql="select sintime from sign where unumber=? and sdate=?";
			ps=SxtJdbcUtil.getPreparedStatement(conn, sql);
			//��ռλ����ֵ
			ps.setString(1,unumber);
			ps.setString(2,indate);
			//��ʼ��ѯ
			rs=ps.executeQuery();
			//�ж�
			if(rs.next()){
				flag=true;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return flag;
	}
	//����ǩ����Ϣ
	@Override
	public int updateSignOutInfo(String unumber, String outTime, String outdate,String outStatus) {
		//����sql���
		String sql="update sign set souttime=?,soutstatus=? where unumber=? and sdate=?";
		int i=SxtJdbcUtil.excuteDML(sql, outTime,outStatus,unumber,outdate);
		return i;
	}
	//�����û�����
	@Override
	public int updateNewPwdInfo(String newPwd, int unumber) {
		//����sql���
		String sql="update user set upwd=? where unumber=?";
		return SxtJdbcUtil.excuteDML(sql, newPwd,unumber);
	}
	//��ȡ��ɫ��
	@Override
	public String getRnameInfo(String rid) {
			//�������
				String rname=null;
				//��������ֵ
				try {
					conn=SxtJdbcUtil.getConnetion();
					//����sql
					String sql="select rname from role where rid=?";
					ps=SxtJdbcUtil.getPreparedStatement(conn, sql);
					//��ռλ����ֵ
					ps.setString(1,rid);
					//��ʼ��ѯ
					rs=ps.executeQuery();
					//�ж�
					if(rs.next()){
						rname=rs.getString("rname");
					}
					
				} catch (Exception e) {
					// TODO: handle exception
				}
				return rname;
	}
	@Override
	public String getUnameInfo(String pnumber) {
		//�������
		String uname=null;
		//��������ֵ
		try {
			conn=SxtJdbcUtil.getConnetion();
			//����sql
			String sql="select uname from user where unumber=?";
			ps=SxtJdbcUtil.getPreparedStatement(conn, sql);
			//��ռλ����ֵ
			ps.setString(1,pnumber);
			//��ʼ��ѯ
			rs=ps.executeQuery();
			//�ж�
			if(rs.next()){
				uname=rs.getString("uname");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return uname;
	}
}
