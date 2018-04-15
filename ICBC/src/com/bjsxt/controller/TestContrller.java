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
		result.put("typename", "请选择");
		findService.add(result);
		return new Gson().toJson(findService);
	}
	
	@ResponseBody
	@RequestMapping("/equip/brand")
	public String findBrand(){
		List<Map> findService = es.brandService();
		HashMap result=new HashMap<>();
		result.put("bid", -1);
		result.put("brandname", "请选择");
		findService.add(result);
		return new Gson().toJson(findService);
	}
	
	@ResponseBody
	@RequestMapping("/equip/add")
	//注意从客户端发送过来的请求name属性是typeId,brandId,model与数据库中字段名无法匹配，所以无法添加进去
	//请求数据会根据实体类e中，字段相同的话，会自动通过setxx()方法自动赋值
	public String editEquip(Equipment e){
		HashMap result=new HashMap<>();
		try{
			es.addService(e);
			result.put("result", true);
			result.put("message", "用户添加成功");
		}catch(Exception ex){
			ex.printStackTrace();
			result.put("result", false);
			result.put("message", "用户添加失败");
		}
		
		return new Gson().toJson(result);
	}
}
