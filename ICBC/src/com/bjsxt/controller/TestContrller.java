package com.bjsxt.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bjsxt.entity.Equipment;
import com.bjsxt.service.EquipService;
import com.google.gson.Gson;
@SuppressWarnings("all")
@Controller("controller")
public class TestContrller {
	
	@Resource(name="service")
	private EquipService es=null;
	@ResponseBody
	@RequestMapping("/equip/find")
	public String findEquip(){
		List<Map> findService = es.findService();
		return new Gson().toJson(findService);
	}
	
	@ResponseBody
	@RequestMapping("/equip/type")
	public String findType(){
		List<Map> findService = es.typeService();
		HashMap result=new HashMap<>();
		result.put("tid", -1);
		result.put("typename", "��ѡ��");
		findService.add(result);
		return new Gson().toJson(findService);
	}
	
	@ResponseBody
	@RequestMapping("/equip/brand")
	public String findBrand(){
		List<Map> findService = es.brandService();
		HashMap result=new HashMap<>();
		result.put("bid", -1);
		result.put("brandname", "��ѡ��");
		findService.add(result);
		return new Gson().toJson(findService);
	}
	
	@ResponseBody
	@RequestMapping("/equip/add")
	//ע��ӿͻ��˷��͹���������name������typeId,brandId,model�����ݿ����ֶ����޷�ƥ�䣬�����޷���ӽ�ȥ
	//�������ݻ����ʵ����e�У��ֶ���ͬ�Ļ������Զ�ͨ��setxx()�����Զ���ֵ
	public String editEquip(Equipment e){
		HashMap result=new HashMap<>();
		try{
			es.addService(e);
			result.put("result", true);
			result.put("message", "�û���ӳɹ�");
		}catch(Exception ex){
			ex.printStackTrace();
			result.put("result", false);
			result.put("message", "�û����ʧ��");
		}
		
		return new Gson().toJson(result);
	}
}
