package com.bjsxt.service;

import java.util.ArrayList;

import com.bjsxt.entry.Menu;
import com.bjsxt.entry.User;

public interface UserService {
	//�û���¼
	User checkLoginInfoService(String unumber, String pwd);
	//�鿴�û���Ӧ�Ĳ˵���Ϣ
	ArrayList<Menu> getMenuInfoService(int rid);
	//�����û�ǩ����Ϣ
	int insertSignInInfoService(String unumber, String inTime, String indate, String inStatus);
	//��ѯ�û��Ƿ�ǩ��
	boolean checkSignInInfoService(String unumber, String indate);
	//����ǩ����Ϣ
	int updateSignOutInfoService(String unumber, String outTime, String outdate, String outStatus);
	//�����û�����
	int updateNewPwdInfoService(String newPwd, int unumber);
	//��ȡ��ɫ��
	String getRnameInfoService(String rid);
	//��ȡ�ϼ�����
	String getUnameInfoService(String pnumber);
	
}
