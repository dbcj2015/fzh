package com.bjsxt.nw185.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.List;
import java.util.LinkedHashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.google.gson.Gson;

import com.bjsxt.nw185.entity.Role;
import com.bjsxt.nw185.service.RoleService;

@Controller("roleController")
@RequestMapping("/role")
public class RoleController {
	@Resource(name="roleService")
	private RoleService roleService = null;
	
	@RequestMapping("/list")
	@ResponseBody
	public String list(Integer page , Integer rows){
		Integer startIndex = (page - 1) * rows;
		Map params = new HashMap();
		params.put("st" , startIndex);
		params.put("r" , rows);
		List<Map> list = roleService.findByProperty(params);
		Long cnt = roleService.countByProperty(params);
		Map result = new HashMap();
		result.put("total" , cnt);
		result.put("rows" , list);
		return new Gson().toJson(result);
	}
	
	@RequestMapping("/findByProperty")
	@ResponseBody
	public String findByProperty(HttpServletRequest request){
		Map params = new HashMap();
		Map<String,String[]> rparam = request.getParameterMap();
		Iterator itr = rparam.entrySet().iterator();
		while(itr.hasNext()){
			Map.Entry<String, String[]> me = (Map.Entry<String, String[]>)itr.next();
			if(me.getValue().length == 1){
				params.put(me.getKey(), me.getValue()[0]);
			}else{
				params.put(me.getKey(), me.getValue());
			}
			
		}
		List<Map> list = roleService.findByProperty(params);
		return new Gson().toJson(list);
	}
	
	@RequestMapping("/findRoleFunction")
	@ResponseBody
	public String findRoleFunction(Integer roleId){
		List<Map> list = roleService.findRoleFunctions(roleId);
		return new Gson().toJson(list);
	}
	
	@RequestMapping("/authFunctions")
	@ResponseBody
	public String authFunctions(Integer roleId , String functionIds){
		
		Integer[] paramIds = null;;
		if(!functionIds.trim().equals("")){
			String[] ids =  functionIds.split(",");
			paramIds = new Integer[ids.length];
			for(int i = 0 ; i < ids.length ; i++){
				paramIds[i] = new Integer(ids[i]);
			}
		}else{
			paramIds = new Integer[0];
		}
		Map result = new LinkedHashMap();
		try{
			roleService.authFunctions(roleId, paramIds);
			result.put("result" , true);
			result.put("message" , "功能授权成功");
		}catch(Exception e){
			e.printStackTrace();
			result.put("result" , false);
			result.put("message" , "功能授权失败,请查看日志");
		}
		return new Gson().toJson(result);
	}
	
	@RequestMapping("/create")
	@ResponseBody
	public String create(Role entity){
		Map result = new LinkedHashMap();
		try{
			roleService.create(entity);
			result.put("result" , true);
			result.put("message" , "数据创建成功");
		}catch(Exception e){
			e.printStackTrace();
			result.put("result" , false);
			result.put("message" , "数据创建失败");
		}
		return new Gson().toJson(result);
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public String update(Role entity){
		Map result = new LinkedHashMap();
		try{
			roleService.update(entity);
			result.put("result" , true);
			result.put("message" , "数据更新成功");
		}catch(Exception e){
			e.printStackTrace();
			result.put("result" , false);
			result.put("message" , "数据更新失败,请查看日志");
		}
		return new Gson().toJson(result);
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(Integer id){
		Map result = new LinkedHashMap();
		try{
			roleService.delete(id);
			result.put("result" , true);
			result.put("message" , "数据删除成功");
		}catch(Exception e){
			e.printStackTrace();
			result.put("result" , false);
			result.put("message" , "数据删除失败,请查看日志");
		}
		return new Gson().toJson(result);
	}
}
