package com.bjsxt.dao;

import java.util.ArrayList;

import com.bjsxt.entry.Sign;
import com.bjsxt.entry.User;

public interface GroupDao {

	//��ȡ������Ա��Ϣ
	ArrayList<User> getGroupInfo(int unumber);
	//��ȡ��Աǩ��ǩ����Ϣ
	ArrayList<Sign> getUserSignInfo(String unumber, String page);
	int getSignCount(String unumber);


}
