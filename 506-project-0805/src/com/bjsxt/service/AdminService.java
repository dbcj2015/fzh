package com.bjsxt.service;

import java.util.ArrayList;

import com.bjsxt.entry.Role;

public interface AdminService {
	//��ȡ���еĽ�ɫ��Ϣ
	ArrayList<Role> getRoleInfoService();
	//�����û���Ϣ
	int updateUserInfoService(String unumber, String rid, String pnumber);
	//ɾ���û���Ϣ
	int deleteUserInfoService(String unumber);
	//���û����ݲ��뵽���ݿ���
	int insertUserInfoService(String[] udata);

}
