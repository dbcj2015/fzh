package com.bjsxt.nw185.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import com.bjsxt.nw185.entity.Fault;
import com.bjsxt.nw185.entity.Takeback;
import com.bjsxt.nw185.entity.Takeout;
import com.bjsxt.nw185.service.AssetService;
import com.bjsxt.nw185.service.exception.BussinessException;
import com.google.gson.Gson;

@Controller("assetController")
@RequestMapping("/asset")
@SuppressWarnings("all")
public class AssetController {
	@Resource(name="assetService")
	private AssetService assetService = null;
	
	
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
		List<Map> list = assetService.findByProperty(params);
		return new Gson().toJson(list);
	}
	
	
	@RequestMapping("/groupStoreAsset")
	@ResponseBody
	public String groupStoreAsset(Integer branchId){
		if(branchId == null){ //没有参数时,默认查询省行
			branchId = 1;
		}
		List<Map> list = assetService.groupStoreAsset(branchId);
		Map result = new HashMap();
		result.put("total", list.size());
		result.put("rows", list);
		return new Gson().toJson(result);
	}
	
	
	/*
	 * 设备派发
	 * */
	@RequestMapping("/distribution")
	@ResponseBody
	public String distribution(Integer productId ,Integer branchId ,Integer num ){
		
		Map result = new LinkedHashMap();
		try{
			assetService.distribution(productId, branchId, num);
			result.put("result" , true);
			result.put("message" , "设备划拨成功");
		}catch(BussinessException e){
			e.printStackTrace();
			result.put("result" , false);
			result.put("message" , e.getMessage());
		}
		return new Gson().toJson(result);
	}
	
	@RequestMapping("/receive")
	@ResponseBody
	public String receive(Integer distId , WebRequest wr ){
		Map result = new LinkedHashMap();
		Map user = (Map)wr.getAttribute("loginuser", WebRequest.SCOPE_SESSION);
		try{
			assetService.receive(distId, (Integer)user.get("emp_id"));
			result.put("result" , true);
			result.put("message" , "设备接收成功");
		}catch(BussinessException e){
			e.printStackTrace();
			result.put("result" , false);
			result.put("message" , e.getMessage());
		}
		return new Gson().toJson(result);
	}
	
	
	@RequestMapping("/takeout")
	@ResponseBody
	public String takeout(Takeout t ,Integer productId , WebRequest wr ){
		Map result = new LinkedHashMap();
		Map loginuser = (Map)wr.getAttribute("loginuser", WebRequest.SCOPE_SESSION);
		try{
			t.setOperator((Integer)loginuser.get("emp_id"));
			t.setOperatorTime(new Date());
			assetService.takeout(t, (Integer)loginuser.get("branch_id") , productId);
			result.put("result" , true);
			result.put("message" , "设备领用登记成功");
		}catch(BussinessException e){
			e.printStackTrace();
			result.put("result" , false);
			result.put("message" , e.getMessage());
		}
		return new Gson().toJson(result);
	}
	
	@RequestMapping("/takeback")
	@ResponseBody
	public String takeback(Takeback t ,Integer empId , WebRequest wr ){
		Map result = new LinkedHashMap();
		Map loginuser = (Map)wr.getAttribute("loginuser", WebRequest.SCOPE_SESSION);
		try{
			t.setOperator((Integer)loginuser.get("emp_id"));
			t.setOperatorTime(new Date());
			t.setUserId(empId);
			assetService.takeback(t);
			result.put("result" , true);
			result.put("message" , "设备回收登记成功");
		}catch(BussinessException e){
			e.printStackTrace();
			result.put("result" , false);
			result.put("message" , e.getMessage());
		}
		return new Gson().toJson(result);
	}
	
	@RequestMapping("/fault")
	@ResponseBody
	public String fault(Fault f , WebRequest wr ){
		Map result = new LinkedHashMap();
		Map loginuser = (Map)wr.getAttribute("loginuser", WebRequest.SCOPE_SESSION);
		try{
			f.setOperator((Integer)loginuser.get("emp_id"));
			f.setOperatorDate(new Date());
			assetService.fault(f);
			result.put("result" , true);
			result.put("message" , "设备报修登记成功");
		}catch(BussinessException e){
			e.printStackTrace();
			result.put("result" , false);
			result.put("message" , e.getMessage());
		}
		return new Gson().toJson(result);
	}
	
	@RequestMapping("/maintenance")
	@ResponseBody
	public String maintenance(Fault f , WebRequest wr ){
		Map result = new LinkedHashMap();
		Map loginuser = (Map)wr.getAttribute("loginuser", WebRequest.SCOPE_SESSION);
		try{
			f.setOperator((Integer)loginuser.get("emp_id"));
			f.setOperatorDate(new Date());
			assetService.maintenance(f);
			result.put("result" , true);
			result.put("message" , "设备维修登记成功");
		}catch(BussinessException e){
			e.printStackTrace();
			result.put("result" , false);
			result.put("message" , e.getMessage());
		}
		return new Gson().toJson(result);
	}
}
