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
	//声明jdbc对象
	private	Connection conn=null;
	private	PreparedStatement ps=null;
	private	ResultSet rs=null;
	//用户登录
	@Override
	public User checkLoginInfo(String unumber, String pwd) {
		
			User u=null;
		//给对象赋值
			try {
				conn=SxtJdbcUtil.getConnetion();
				//创建sql
				String sql="select * from user where unumber=? and upwd=?";
				ps=SxtJdbcUtil.getPreparedStatement(conn, sql);
				//给占位符赋值
				ps.setString(1,unumber);
				ps.setString(2,pwd);
				//查询
				rs=ps.executeQuery();
				//遍历
				if(rs.next()){
					//给u对象进行赋值
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
		
		//关闭资源
		return u;
	}
	//查询用户菜单信息
	@Override
	public ArrayList<Menu> getMenuInfo(int rid) {
		//声明list
		ArrayList<Menu> list=null;
		//给jdbc对象赋值
		try {
			conn=SxtJdbcUtil.getConnetion();
			//创建sql
			String sql="select m.mid,m.mname,m.murl from rm r,menu m where r.mid=m.mid and rid=?";
			ps=SxtJdbcUtil.getPreparedStatement(conn, sql);
			//给占位符赋值
			ps.setInt(1,rid);
			//开始查询
			rs=ps.executeQuery();
			//给list赋值
			list=new ArrayList<Menu>();
			//遍历
			while(rs.next()){
				//创建Menu对象
				Menu m=new Menu();
				m.setMid(rs.getInt("mid"));
				m.setMname(rs.getString("mname"));
				m.setMurl(rs.getString("murl"));
				list.add(m);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		//关闭资源
		return list;
	}
	//用户签到信息插入
	@Override
	public int insertSignInInfo(String unumber, String inTime, String indate,String inStatus) {
		//创建Sql语句
		String sql="insert into sign(unumber,sintime,sinstatus,sdate)values(?,?,?,?)";
		//调用DML方法将数据插入到数据库中
		int i=SxtJdbcUtil.excuteDML(sql,unumber,inTime,inStatus,indate);
		return i;
	}
	//查询用户是否签到
	@Override
	public boolean checkSignInInfo(String unumber, String indate) {
		//声明标记
		boolean flag=false;
		//给变量赋值
		try {
			conn=SxtJdbcUtil.getConnetion();
			//创建sql
			String sql="select sintime from sign where unumber=? and sdate=?";
			ps=SxtJdbcUtil.getPreparedStatement(conn, sql);
			//给占位符赋值
			ps.setString(1,unumber);
			ps.setString(2,indate);
			//开始查询
			rs=ps.executeQuery();
			//判断
			if(rs.next()){
				flag=true;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return flag;
	}
	//更新签退信息
	@Override
	public int updateSignOutInfo(String unumber, String outTime, String outdate,String outStatus) {
		//创建sql语句
		String sql="update sign set souttime=?,soutstatus=? where unumber=? and sdate=?";
		int i=SxtJdbcUtil.excuteDML(sql, outTime,outStatus,unumber,outdate);
		return i;
	}
	//更新用户密码
	@Override
	public int updateNewPwdInfo(String newPwd, int unumber) {
		//创建sql语句
		String sql="update user set upwd=? where unumber=?";
		return SxtJdbcUtil.excuteDML(sql, newPwd,unumber);
	}
	//获取角色名
	@Override
	public String getRnameInfo(String rid) {
			//声明标记
				String rname=null;
				//给变量赋值
				try {
					conn=SxtJdbcUtil.getConnetion();
					//创建sql
					String sql="select rname from role where rid=?";
					ps=SxtJdbcUtil.getPreparedStatement(conn, sql);
					//给占位符赋值
					ps.setString(1,rid);
					//开始查询
					rs=ps.executeQuery();
					//判断
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
		//声明标记
		String uname=null;
		//给变量赋值
		try {
			conn=SxtJdbcUtil.getConnetion();
			//创建sql
			String sql="select uname from user where unumber=?";
			ps=SxtJdbcUtil.getPreparedStatement(conn, sql);
			//给占位符赋值
			ps.setString(1,pnumber);
			//开始查询
			rs=ps.executeQuery();
			//判断
			if(rs.next()){
				uname=rs.getString("uname");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return uname;
	}
}
