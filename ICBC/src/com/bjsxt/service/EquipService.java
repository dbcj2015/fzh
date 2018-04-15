package com.bjsxt.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bjsxt.dao.EquipDao;
import com.bjsxt.entity.Equipment;
@Service("service")
@Transactional(rollbackFor=Exception.class)
public class EquipService {
	@Resource(name="equipDao")
	private EquipDao dao=null;
	
	public List<Map> findService(){
		List<Map> findAll = dao.findAll();
		return findAll;
	}
	
	public void addService(Equipment e){
		dao.addEquip(e);
	}
	
	public List<Map> typeService(){
		List<Map> findType = dao.findType();
		return findType;
	}
	
	public List<Map> brandService(){
		List<Map> findType = dao.findBrand();
		return findType;
	}
}
