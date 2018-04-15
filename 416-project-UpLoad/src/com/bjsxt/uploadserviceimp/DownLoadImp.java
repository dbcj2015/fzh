package com.bjsxt.uploadserviceimp;

import com.bjsxt.entry.User;
import com.bjsxt.uploadService.DownLoadService;
import com.bjsxt.uploaddao.DownLoadDao;
import com.bjsxt.uploaddaoimp.DownLoadDaoImp;

public class DownLoadImp implements DownLoadService{
	DownLoadDao dd=new DownLoadDaoImp();
	@Override
	public User selectUserInfoService(String uid) {
		// TODO Auto-generated method stub
		return dd.selectUserInfo(uid);
	}
		
}
