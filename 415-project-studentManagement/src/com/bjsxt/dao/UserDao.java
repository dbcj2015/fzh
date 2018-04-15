package com.bjsxt.dao;

import java.util.ArrayList;

import com.bjsxt.entry.Menu;
import com.bjsxt.entry.User;

public interface UserDao {
	User checkUserLoginInfo(String unumber,String upwd);

	ArrayList<Menu> getUserMenuInfo(int rid);
	//��ǩ����Ϣ���뵽���ݿ���
	int insertInInfo(String unumber, String inTime, String inDate, String inStatus);
	//�ж��û��Ƿ��Ѿ�ǩ��
	boolean checkSignInfo(String unumber, String inDate);

	int insertOutInfo(String unumber, String inTime, String inDate, String outStatus);
	//��ȡ�û��ϼ������Լ��û���ɫ��Ϣ
	String getRnameInfo(String rid);
	//��ȡ�ϼ�������Ϣ
	String getUnameInfo(String pnumber);

	int updateNewPwdInfo(String newPwd, int unumber);
}
