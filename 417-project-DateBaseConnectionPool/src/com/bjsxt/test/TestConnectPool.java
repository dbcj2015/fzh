package com.bjsxt.test;

import java.sql.Connection;

import java.sql.DriverManager;

import com.bjsxt.fz.ConnectPoolFactory;

public class TestConnectPool {

	public static void main(String[] args) throws Exception {
		long start = System.currentTimeMillis();
		for(int i=0; i< 200; i++){
		Connection conn = ConnectPoolFactory.getInstance().getConnect();
		conn.close();
		}
		long end = System.currentTimeMillis();
		
		System.out.println(end-start);

		
		start = System.currentTimeMillis();
		for(int i=0; i<=100; i++){
			Class.forName("oracle.jdbc.OracleDriver");
			Connection conn1 = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "bjsxt", "bjsxt");
			conn1.close();
		}
		end = System.currentTimeMillis();
		
		System.out.println(end-start);
	}

}
