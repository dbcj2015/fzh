package com.bjsxt.uploaddaoimp;

import com.bjsxt.fz.DBUtil;
import com.bjsxt.uploaddao.UploadDao;

public class UploadDaoImp implements UploadDao{
	//将请求数据插入到数据库中
	@Override
	public int insertUserLoadInfo(String[] objs) {
		String sql="insert into upload values(default,?,?,?,?,?)";
		return DBUtil.excuteDML(sql, objs);
	}
	
}
