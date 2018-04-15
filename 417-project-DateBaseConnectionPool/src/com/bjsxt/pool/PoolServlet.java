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
 * 1����������ʷ�����������������Դ,����������Դ�������Ϊ��֧��HTTPЭ�飬���͵�����
 * 		�������HTTPЭ�����ݵĸ�ʽ����Щ������Ϣ���������socket��ͨ������IO�����ͷ�����
 * 2������һ�����ӵ����ݿ�Ӧ�ã��������ȫ��ͬ�ˡ�Ƶ���Ľ������ر����ӣ��Ἣ��ļ���ϵͳ�����ܣ�
 * 		��Ϊ�������ӵ�ʹ�ó���ϵͳ���ܵ�ƿ����
 * 3�����Ӹ���:ͨ������һ�����ݿ����ӳ��Լ�һ������ʹ�ù�����ԣ�ʹ��һ�����ݿ����ӿ��Եõ���Ч����ȫ
 * 		�ĸ��ã����������ݿ�����Ƶ���������رյĿ�����
 * 4��������Դ:��һ�������������ģʽ����Դ�ء���ģʽ����Ϊ�˽����ԴƵ�����䡢�ͷ�����ɵ�����ġ�
 * 	   �Ѹ�ģʽӦ�õ����ݿ����ӹ������򣬾��ǽ���һ�����ݿ����ӳأ��ṩһ�׸�Ч�����ӷ��䡢ʹ�ò��ԣ�
 * 		����Ŀ����ʵ�����ӵĸ�Ч����ȫ�ĸ��á�
 * 5�����ݿ����ӳصĻ���ԭ�������ڲ��������ά��һ�����������ݿ����ӣ������Ⱪ¶���ݿ����ӻ�ȡ�ͷ��ط�����
 * 		�磺�ⲿʹ���߿�ͨ��getConnection ������ȡ���ӣ�ʹ����Ϻ���ͨ��releaseConnection ������
 * 			���ӷ��أ�ע���ʱ���Ӳ�û�йرգ����������ӳع��������գ���Ϊ��һ��ʹ������׼����
 * 6���������ݿ����ӵõ����ã�������Ƶ���������ͷ���������Ĵ������ܿ���;���ݿ����ӳ��ڳ�ʼ�������У������Ѿ�����
 *    ���������ݿ��������ڳ��б��á���ʱ���ӵĳ�ʼ������������ɡ�����ҵ����������ԣ�ֱ���������п������ӣ�
 *    ���������ݿ����ӳ�ʼ�����ͷŹ��̵�ʱ�俪�����Ӷ�������ϵͳ������Ӧʱ��

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
