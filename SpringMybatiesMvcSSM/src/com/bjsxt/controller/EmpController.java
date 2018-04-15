package com.bjsxt.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bjsxt.entity.Emp;
import com.bjsxt.service.TestService;
import com.google.gson.Gson;

@Controller("empController")
@SuppressWarnings("all")
public class EmpController {
	
	@Resource(name="service")
	private TestService st=null;
	
	@RequestMapping("/emp/list")
	@ResponseBody//不进行页面转发
	//注意:从datagrid发送的数据请求中参数分别是page、rows,所以接收的时候也必须是相同的参数
	public String test(Integer page,Integer rows){
		System.out.println(page);
		Map map = st.findAll(page, rows);
		return new Gson().toJson(map);//直接响应给客户端
	}
	
	@RequestMapping("/emp/dept")
	@ResponseBody//不进行页面转发
	public String test(){
		List findALLDept = st.findALLDept();
		Map result=new HashMap();
		result.put("dname", "请选择");
		result.put("dept_id", -1);
		findALLDept.add(result);
		return new Gson().toJson(findALLDept);//直接响应给客户端
	}
	
	@RequestMapping("/emp/create")
	@ResponseBody//不进行页面转发
	public String insert(Emp e){
		System.out.println("方法开始执行");
		System.out.println(e.getName());
		HashMap result=new HashMap<>();
		try{
			st.insertAll(e);
			result.put("result", true);
			result.put("message", "员工创建成功");
		}catch(Exception ex){
			ex.printStackTrace();
			result.put("result", false);
			result.put("message", "员工创建失败");
		}
		return new Gson().toJson(result);
	}
}
