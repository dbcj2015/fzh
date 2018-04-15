package com.bjsxt.service;

import java.util.ArrayList;

import com.bjsxt.entry.Menu;
import com.bjsxt.entry.User;

public interface UserService {
	//�û���¼
		User checkUserInfo(String unumber,String upwd);
	//�鿴�û���ɫ��Ϣ
	ArrayList<Menu> getUserMenuInfo(int rid);
	//��ǩ����Ϣ���뵽���ݿ���
	int insertInInfoService(String unumber, String inTime, String inDate, String inStatus);
	//�ж��û��Ƿ��Ѿ�ǩ��
	boolean checkSignInfoService(String unumber, String inDate);
	//��ǩ����Ϣ���뵽���ݿ���
	int insertOutInfoService(String unumber, String inTime, String inDate, String outStatus);
	//��ȡ�û��ϼ������Լ��û���ɫ
	String getRnameInfoService(String rid);
	String getUnameInfoService(String pnumber);
	//�����û�����
	int updateNewPwdInfoService(String newPwd, int unumber);
	
}
