package com.bjsxt.dao;

import java.util.ArrayList;

import com.bjsxt.entry.Menu;
import com.bjsxt.entry.User;

public interface UserDao {

	User checkLoginInfo(String unumber, String pwd);
	//��ѯ�û��˵���Ϣ
	ArrayList<Menu> getMenuInfo(int rid);
	//�����û�ǩ����Ϣ
	int insertSignInInfo(String unumber, String inTime, String indate, String inStatus);
	//��ѯ�û��Ƿ�ǩ��
	boolean checkSignInInfo(String unumber, String indate);
	//����ǩ����Ϣ
	int updateSignOutInfo(String unumber, String outTime, String outdate, String outStatus);
	//�����û�����
	int updateNewPwdInfo(String newPwd, int unumber);
	//��ȡ��ɫ��
	String getRnameInfo(String rid);
	//��ȡ�ϼ�����
	String getUnameInfo(String pnumber);

}
