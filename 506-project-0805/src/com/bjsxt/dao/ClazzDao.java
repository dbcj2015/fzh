package com.bjsxt.dao;

import java.util.ArrayList;

import com.bjsxt.entry.User;

public interface ClazzDao {
	//��ȡ���е�ѧ����Ϣ
	ArrayList<User> getClazzInfo(String rid);

}
