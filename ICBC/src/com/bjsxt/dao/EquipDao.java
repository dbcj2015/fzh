package com.bjsxt.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.bjsxt.entity.Equipment;

public interface EquipDao {
	//�������������Map,�ڴ���ʱ@Param,����st�Ǽ���,startPage�Ǽ�ֵ
	//�����ѯ����һ�����ݣ���������ѡ�����ʵ������,������ص��Ƕ������洢��List�е�Map��
	public List<Map> findAll();
	public void addEquip(Equipment e);
	public List<Map> findType();
	public List<Map> findBrand();
}
