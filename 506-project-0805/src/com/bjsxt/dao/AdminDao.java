package com.bjsxt.dao;

import java.util.ArrayList;

import com.bjsxt.entry.Role;

public interface AdminDao {
	//��ȡ���еĽ�ɫ��Ϣ
	ArrayList<Role> getRoleInfo();
	//�����û���Ϣ
	int updateUserInfo(String unumber, String rid, String pnumber);
	//ɾ���û���Ϣ
	int deleteUserInfo(String unumber);
	//���û����ݲ��뵽���ݿ���
	int insertUserInfo(String[] udata);

}
