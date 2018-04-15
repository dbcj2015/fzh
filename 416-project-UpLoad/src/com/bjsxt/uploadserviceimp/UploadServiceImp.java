package com.bjsxt.uploadserviceimp;

import com.bjsxt.uploadService.UploadService;
import com.bjsxt.uploaddao.UploadDao;
import com.bjsxt.uploaddaoimp.UploadDaoImp;

public class UploadServiceImp implements UploadService{
	UploadDao ud=new UploadDaoImp();
	//将请求数据插入数据库
	@Override
	public int insertUserLoadInfoService(String[] objs) {
		// TODO Auto-generated method stub
		return ud.insertUserLoadInfo(objs);
	}
	
	
}
