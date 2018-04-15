package com.bjsxt.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import com.bjsxt.exception.TestException;
import com.bjsxt.service.EmpService;
import com.bjsxt.service.RbacService;

@SuppressWarnings(value="all")
@Controller("empController")
public class EmpController {
	
	@Resource(name="empService")
	private EmpService empService=null;
	@Resource(name="rbacService")
	private RbacService rbacService=null;
	@RequestMapping("/icbc/register")
	
	public String login(String username,String password,WebRequest wr){
		//System.out.println("�ҿ��Ը�session����洢�û���Ϣ��");
		try{
			Map userInfo = empService.findService(username, password);
			System.out.println("emp_id="+userInfo.get("emp_id"));
			//ͨ��id��ȡ��ɫ��Ϣ
			List<Map> roles=empService.findRolesByIdService((Integer)userInfo.get("emp_id"));
			//ͨ����ɫ��Ϣ��ȡԱ��ģ��
			ArrayList<Integer> parasRoles=new ArrayList<>();
			for (Map role : roles) {
				parasRoles.add((Integer)role.get("role_id"));
			}
			List<Map> Moduals=rbacService.findModualsByRole(parasRoles);
			//ͨ��ָ��ģ���ѯӵ�еĹ���
			ArrayList<Integer> moduals=new ArrayList<>();
			for (Map modual : Moduals) {
				moduals.add((Integer)modual.get("modual_id"));
			}
			Map functionsMP=new LinkedHashMap<>();
			for (Integer modualId : moduals) {
				List<Map> functions = rbacService.findFuncByModuals(modualId);
				functionsMP.put("M"+modualId,functions );
			}
			
			wr.setAttribute("username", userInfo, WebRequest.SCOPE_SESSION);
			wr.setAttribute("moduals", Moduals, WebRequest.SCOPE_REQUEST);
			wr.setAttribute("functions", functionsMP, WebRequest.SCOPE_REQUEST);
			return "/index";
		}catch(TestException e){
			e.printStackTrace();
			wr.setAttribute("message", e.getMessage().toString(),WebRequest.SCOPE_REQUEST);
			System.out.println(e.getMessage());
			return "/login";
		}
		
	}
}

