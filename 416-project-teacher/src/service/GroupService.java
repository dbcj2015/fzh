package com.bjsxt.service;

import java.util.ArrayList;

import com.bjsxt.entry.Sign;
import com.bjsxt.entry.User;

public interface GroupService {
	//��ȡС����Ϣ
	ArrayList<User> getGroupInfoService(int unumber);
	//��ȡ��Աǩ��ǩ����Ϣ
	ArrayList<Sign> getSignInfoService(String unumber, String page);
	//��ȡ�û�ǩ��ǩ��������
	int getCountInfoService(String unumber);

}
