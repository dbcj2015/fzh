package com.bjsxt.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DBUtils {
	//...浠ｈ〃鍙�鍙傛暟锛岃繖涓弬鏁板彲浠ユ槸涓�釜鏁扮粍涔熷彲浠ユ槸涓�釜鍗曚釜瀵硅薄锛岀敋鑷冲彲浠ヨ蹇界暐
	public static List<Map> list(String sql , Object... params) throws DBException{
		Connection conn = null;
		List result = null;
		try{
			//JDBC浣跨敤姝ラ
			//1. Class.forName鍔犺浇JDBC椹卞姩绫�
			Class.forName("com.mysql.jdbc.Driver");
			//2. 鍒╃敤DriverManager璁惧绠＄悊鍣ㄦ潵鎵撳紑鏁版嵁搴撹繛鎺�
			String url = "jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=UTF-8";
			conn = DriverManager.getConnection(url, "root", "root");
			
			PreparedStatement pstmt = conn.prepareStatement(sql); //蹇樻帀createStatement鍚э紝鍥犱负瀹冧笉鏀寔鍙傛暟
			
			if(params!= null && params.length>0){
				for(int i=1 ; i <= params.length ; i++){
					pstmt.setObject(i, params[i-1]);
				}
			}
			
			//4. 鑾峰彇鏌ヨ缁撴灉ResultSet锛岃幏鍙栨煡璇㈢粨鏋�
			ResultSet rs = pstmt.executeQuery();
			//閬嶅巻缁撴灉闆嗕腑鎵�湁鍒楀悕锛屾敞鎰忎笅鏍囦粠1寮�
			List<String> columns = new ArrayList();
			for(int i = 1 ; i <= rs.getMetaData().getColumnCount() ; i++){
				columns.add(rs.getMetaData().getColumnName(i));
			}
			result = new ArrayList();//瀹炰緥鍖栫粨鏋滈泦
			while(rs.next()){
				Map rec = new LinkedHashMap();//閾捐〃褰㈠紡鐨凥ashMap锛屼繚璇佽鍙栧嚭鏉ョ殑椤哄簭涓庡瓨鏀炬椂涓�嚧
				for(String colname : columns){
					Object val = rs.getObject(colname);
					rec.put(colname, val);
				}
				result.add(rec);
			}
		}catch(Exception e){
			throw new DBException(e);
		}finally{
			//5.鍏抽棴鏁版嵁搴撹繛鎺�
			try {
				if(conn != null && !conn.isClosed()){
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
			}
		}
		return result;
	}
	
	
	
	public static void executeUpdate(String sql , Object... params) throws DBException{
		Connection conn = null;
		try{

			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/ptcal?useUnicode=true&characterEncoding=UTF-8";
			conn = DriverManager.getConnection(url, "root", "");
			PreparedStatement pstmt = conn.prepareStatement(sql); //蹇樻帀createStatement鍚э紝鍥犱负瀹冧笉鏀寔鍙傛暟
			if(params!= null && params.length>0){
				for(int i=1 ; i <= params.length ; i++){
					pstmt.setObject(i, params[i-1]);
				}
			}
			pstmt.executeUpdate();
		}catch(Exception e){
			throw new DBException(e);
		}finally{
			//5.鍏抽棴鏁版嵁搴撹繛鎺�
			try {
				if(conn != null && !conn.isClosed()){
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
			}
		}
	}
	
	
	
	
	
	public static void main(String[] args) {
		//绂荤嚎缁撴灉闆嗭紝涓嶄緷璧栦簬Connection鐨勭粨鏋滈泦閫傜敤浜庡皬鏁版嵁閲忕殑璁块棶锛屽ぇ鏁版嵁閲忎笅杩樻槸闇�while(rs.next())杩涜澶勭悊锛屽鐞嗗悗绔嬪嵆閲婃斁
		
		List<Map> list = null;
		try {
			list = DBUtils.list("select * from t_card_op_log where op_id = ?" , new Object[]{21});
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(list);
	}
}

