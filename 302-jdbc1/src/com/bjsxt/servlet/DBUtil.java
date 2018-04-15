package com.bjsxt.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DBUtil {
	//...�����ѡ�������������������һ������Ҳ������һ�����������������Ա�����
	public static List<Map> DBUtilTest(String sql,Object ... params){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Map> result=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://127.0.0.1:3306/icbc?useUnicode=true&characterEncoding=UTF-8";
			conn = DriverManager.getConnection(url,"root","root");
			ps = conn.prepareStatement(sql);
			
			//�����鲻��nullֵ;//����в��������ò���
			if(params!=null && params.length>0){
				//��������Object
				for(int i=0;i<params.length;i++){
					ps.setObject(i+1,params[i]);
				}
			}
			
			rs = ps.executeQuery();
			//�õ��������е��ֶ�
			ArrayList<String> columns=new ArrayList<>();
			for(int i=0;i<rs.getMetaData().getColumnCount();i++){
				columns.add(rs.getMetaData().getColumnName(i));
			}
			result = new ArrayList();
			while(rs.next()){
				Map rec=new LinkedHashMap();
				for (String columName : columns) {
					Object value=rs.getObject(columName);
					rec.put(columName, value);
				}
				result.add(rec);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
		return result;
	}
}


