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

import com.bjsxt.nw185.entity.Product;
import com.bjsxt.nw185.service.ProductService;

@Controller("productController")
@RequestMapping("/product")
public class ProductController {
	@Resource(name="productService")
	private ProductService productService = null;
	
	@RequestMapping("/list")
	@ResponseBody
	public String list(Integer page , Integer rows){
		Integer startIndex = (page - 1) * rows;
		Map params = new HashMap();
		params.put("st" , startIndex);
		params.put("r" , rows);
		List<Map> list = productService.findByProperty(params);
		Long cnt = productService.countByProperty(params);
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
		List<Map> list = productService.findByProperty(params);
		return new Gson().toJson(list);
	}
	
	@RequestMapping("/create")
	@ResponseBody
	public String create(Product entity){
		Map result = new LinkedHashMap();
		try{
			productService.create(entity);
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
	public String update(Product entity){
		Map result = new LinkedHashMap();
		try{
			productService.update(entity);
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
			productService.delete(id);
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
