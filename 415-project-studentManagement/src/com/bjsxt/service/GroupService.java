package com.bjsxt.service;

import java.util.ArrayList;

import com.bjsxt.entry.Sign;
import com.bjsxt.entry.User;

public interface GroupService {
	//��ȡ������Ա��Ϣ
	ArrayList<User> getGroupInfoService(int unumber);
	//��ȡ�û�ǩ��ǩ����Ϣ
	ArrayList<Sign> getUserSignInfoService(String unumber,String page);
	//��ȡĳ����Ա��ǩ��ǩ������Ϣ����
	int getSignCountService(String unumber);


}
