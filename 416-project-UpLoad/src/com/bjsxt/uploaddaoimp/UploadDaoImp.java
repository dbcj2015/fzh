package com.bjsxt.uploaddaoimp;

import com.bjsxt.fz.DBUtil;
import com.bjsxt.uploaddao.UploadDao;

public class UploadDaoImp implements UploadDao{
	//���������ݲ��뵽���ݿ���
	@Override
	public int insertUserLoadInfo(String[] objs) {
		String sql="insert into upload values(default,?,?,?,?,?)";
		return DBUtil.excuteDML(sql, objs);
	}
	
}
