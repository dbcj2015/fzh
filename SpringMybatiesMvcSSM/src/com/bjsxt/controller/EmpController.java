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
	@ResponseBody//������ҳ��ת��
	//ע��:��datagrid���͵����������в����ֱ���page��rows,���Խ��յ�ʱ��Ҳ��������ͬ�Ĳ���
	public String test(Integer page,Integer rows){
		System.out.println(page);
		Map map = st.findAll(page, rows);
		return new Gson().toJson(map);//ֱ����Ӧ���ͻ���
	}
	
	@RequestMapping("/emp/dept")
	@ResponseBody//������ҳ��ת��
	public String test(){
		List findALLDept = st.findALLDept();
		Map result=new HashMap();
		result.put("dname", "��ѡ��");
		result.put("dept_id", -1);
		findALLDept.add(result);
		return new Gson().toJson(findALLDept);//ֱ����Ӧ���ͻ���
	}
	
	@RequestMapping("/emp/create")
	@ResponseBody//������ҳ��ת��
	public String insert(Emp e){
		System.out.println("������ʼִ��");
		System.out.println(e.getName());
		HashMap result=new HashMap<>();
		try{
			st.insertAll(e);
			result.put("result", true);
			result.put("message", "Ա�������ɹ�");
		}catch(Exception ex){
			ex.printStackTrace();
			result.put("result", false);
			result.put("message", "Ա������ʧ��");
		}
		return new Gson().toJson(result);
	}
}
