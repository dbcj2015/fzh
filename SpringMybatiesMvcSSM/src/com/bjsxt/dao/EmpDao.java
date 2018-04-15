package com.bjsxt.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.bjsxt.entity.Emp;

public interface EmpDao {
	//�������������Map,�ڴ���ʱ@Param,����st�Ǽ���,startPage�Ǽ�ֵ
	//�����ѯ����һ�����ݣ���������ѡ�����ʵ������,������ص��Ƕ������洢��List�е�Map��
	public List<Map> findPage(@Param("st") Integer startPage,@Param("r")Integer rows);
	public void insertAll(Emp e);
	public int countAll();
}
