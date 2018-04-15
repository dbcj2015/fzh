package com.bjsxt.pool;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.fz.ConnectPoolFactory;
/*
 * 1、浏览器访问服务器本质是请求资源,比如请求资源，浏览器为了支持HTTP协议，发送的数据
 * 		必须符合HTTP协议数据的格式；这些请求信息浏览器利用socket，通过网络IO流发送服务器
 * 2、对于一个复杂的数据库应用，情况就完全不同了。频繁的建立、关闭连接，会极大的减低系统的性能，
 * 		因为对于连接的使用成了系统性能的瓶颈。
 * 3、连接复用:通过建立一个数据库连接池以及一套连接使用管理策略，使得一个数据库连接可以得到高效、安全
 * 		的复用，避免了数据库连接频繁建立、关闭的开销。
 * 4、共享资源:有一个很著名的设计模式：资源池。该模式正是为了解决资源频繁分配、释放所造成的问题的。
 * 	   把该模式应用到数据库连接管理领域，就是建立一个数据库连接池，提供一套高效的连接分配、使用策略，
 * 		最终目标是实现连接的高效、安全的复用。
 * 5、数据库连接池的基本原理是在内部对象池中维护一定数量的数据库连接，并对外暴露数据库连接获取和返回方法。
 * 		如：外部使用者可通过getConnection 方法获取连接，使用完毕后再通过releaseConnection 方法将
 * 			连接返回，注意此时连接并没有关闭，而是由连接池管理器回收，并为下一次使用做好准备。
 * 6、由于数据库连接得到重用，避免了频繁创建、释放连接引起的大量性能开销;数据库连接池在初始化过程中，往往已经创建
 *    了若干数据库连接置于池中备用。此时连接的初始化工作均已完成。对于业务请求处理而言，直接利用现有可用连接，
 *    避免了数据库连接初始化和释放过程的时间开销，从而缩减了系统整体响应时间

 * */
public class PoolServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Connection conn=null;
		String sql="select * from role";
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
		 conn=ConnectPoolFactory.getInstance().getConnect();
		 ps = conn.prepareStatement(sql);
		 rs=ps.executeQuery();
		 while(rs.next()){
			 System.out.println(rs.getString("rname"));
		 }
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(ps!=null){
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
		
		
	}
}
