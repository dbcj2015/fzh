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

import com.bjsxt.nw185.entity.Fault;
import com.bjsxt.nw185.service.FaultService;

@Controller("faultController")
@RequestMapping("/fault")
@SuppressWarnings("all")
public class FaultController {
	@Resource(name="faultService")
	private FaultService faultService = null;

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
		List<Map> list = faultService.findByProperty(params);
		return new Gson().toJson(list);
	}

}
