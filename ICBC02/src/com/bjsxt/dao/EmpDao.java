package com.bjsxt.dao;

import java.util.List;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface EmpDao {
	//�������������Map,�ڴ���ʱ@Param,����st�Ǽ���,startPage�Ǽ�ֵ
	//�����ѯ����һ�����ݣ���������ѡ�����ʵ������,������ص��Ƕ������洢��List�е�Map��
	//���������һ��ͬ��������Map��ʽ��ȡֵ������ֻ��һ�����ݼȿ�����һ������Ҳ������ʵ�������map����
	public List<Map> find(@Param("username") String username);
	
}
