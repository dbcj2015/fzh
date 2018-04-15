package com.bjsxt.rd.template.themes.sm.profile;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import com.bjsxt.rd.template.themes.sm.base.DBUtils;
import com.bjsxt.rd.template.themes.sm.base.StringUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import ognl.Ognl;

public class Profile {
	
	private File profile = null;
	private Map metaData = null;
	public Profile(File profile) throws IOException{
		this.profile = profile;
		String content = FileUtils.readFileToString(profile);
		this.metaData = new Gson().fromJson(content,new TypeToken<Map<String,Object>>(){}.getType());
		
		List properties = new ArrayList();
		Connection conn = DBUtils.getConnection();
		String tableName = this.getStringProperty("model.tableName");
		
		try {
			ResultSet rs = conn.prepareStatement("select * from " + tableName).executeQuery();
			for(int i = 1 ; i <= rs.getMetaData().getColumnCount() ; i++){
				String column = rs.getMetaData().getColumnName(i);
				//解决驼峰命名
				String cname = StringUtils.underline2Camel(column, true);
				
				int btype = rs.getMetaData().getColumnType(i);
				String strType ="";
				switch(btype) {
				case Types.INTEGER :
					strType = "Integer";
					break;
				case Types.VARCHAR : 
					strType = "String";
					break;
				case Types.FLOAT : 
					strType = "Float";
					break;
				case Types.DATE : 
					strType = "Date";
					break;
				case Types.TIME : 
					strType = "Date";
					break;
				case Types.TIMESTAMP : 
					strType = "Date";
					break;
				default:
					strType = "Object";
					break;
				}
				Map f = new LinkedHashMap();
				f.put("name", cname);
				f.put("type", strType);
				f.put("column", column);
				properties.add(f);
				Map metaData = this.getMetaData();
				Map model = (Map)metaData.get("model");
				model.put("properties", properties);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}finally{
			DBUtils.closeConnection(conn);
		}
	}
	
	public String getStringProperty(String ognl ){
		String result = null;
		try{
			result = (String)Ognl.getValue(ognl, metaData);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return result;
	}
	
	public List<Map> getListProperty(String ognl ){
		List<Map> list = null;
		try{
			list = (List)Ognl.getValue(ognl, metaData);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return list;
	}
	
	public Map getMetaData(){
		return this.metaData;
	}
}
