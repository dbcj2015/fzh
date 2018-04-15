package com.bjsxt.nw185.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bjsxt.nw185.service.AssetService;
import com.bjsxt.nw185.service.BranchService;
import com.bjsxt.nw185.service.exception.AssetException;
import com.google.gson.Gson;

@Controller("assetController")
@RequestMapping("/asset")
public class AssetController {
	
	@Resource(name="assetService")
	private AssetService assetService = null;
	
	@RequestMapping("/findProperty")
	@ResponseBody
	public String groupStoreAsset(){
		
		List<Map> groupStoreAsset = assetService.groupStoreAsset();
		return new Gson().toJson(groupStoreAsset);
	}
	
	@RequestMapping("/distribution")
	@ResponseBody
	public String distribution(Integer productId,Integer branchId,Integer num){
		Map result=new LinkedHashMap();
		try {
			assetService.distribution(productId, branchId, num);
			result.put("result", true);
			result.put("message", "设备划拨成功");
		} catch (AssetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result.put("result", false);
			result.put("message", e.getMessage());
		}
		return new Gson().toJson(result);
	}
}
