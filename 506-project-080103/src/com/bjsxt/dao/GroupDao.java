package com.bjsxt.dao;

import java.util.ArrayList;

import com.bjsxt.entry.Sign;
import com.bjsxt.entry.User;

public interface GroupDao {
	//��ȡС����Ϣ
	ArrayList<User> getGroupInfo(int unumber);
	//��ȡ��Աǩ��ǩ����Ϣ
	ArrayList<Sign> getSignInfo(String unumber, String page);
	//��ȡ�û�ǩ��ǩ��������
	int getCountInfo(String unumber);

}
