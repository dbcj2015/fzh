package com.bjsxt.nw185.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

import com.bjsxt.nw185.service.RbacService;
import com.bjsxt.nw185.service.UsersService;
import com.bjsxt.nw185.service.exception.UserException;

@Controller
@RequestMapping("/users")
public class UsersController {
	@Resource(name="usersService")
	private UsersService usersService  = null;
	@Resource(name="rbacService")
	private RbacService rbacService = null;
	
	@RequestMapping("/login")
	public String login(String username , String password , WebRequest wr){
		try {
			//当前登录人的信息
			Map user = usersService.checkLogin(username, password);
			//当前用户所拥有的角色
			List<Map> roles = rbacService.findRolesByEmp((Integer)user.get("emp_id"));
			//获取当前登录人拥有的角色编号
			List<Integer> paramRoles = new ArrayList();
			for(Map role : roles){
				paramRoles.add((Integer)role.get("role_id"));
			}
			/*
			List roles = new ArrayList();
			roles.add(2);
			roles.add(3);*/
			//查询指定拥有拥有角色能访问的模块
			List<Map> modules = rbacService.findModules(paramRoles);
			Map functionMP = new LinkedHashMap();
			//查询指定拥有拥有角色能访问的功能
			for(Map m : modules){
				//查询指定模块下的功能
				List<Map> functions = rbacService.findFunctions(paramRoles , (Integer)m.get("module_id"));
				functionMP.put("M" + m.get("module_id"), functions);
			}
			//将当前登录人的信息存放在Session.loginuser属性中
			wr.setAttribute("loginuser", user, WebRequest.SCOPE_SESSION);
			wr.setAttribute("modules", modules, WebRequest.SCOPE_REQUEST);
			wr.setAttribute("functions", functionMP, WebRequest.SCOPE_REQUEST);
			return "/index.jsp";
		} catch (UserException e) {
			// TODO Auto-generated catch block
			//request.setAttribute("error_messager", e.getMessage());
			wr.setAttribute("error_message", e.getMessage(), WebRequest.SCOPE_REQUEST);
			return "/login.jsp";
		}
	}
	
	@RequestMapping("/logout")
	public String login(WebRequest wr , HttpSession session){
		wr.removeAttribute("loginuser", WebRequest.SCOPE_SESSION);
		session.invalidate();
		return "/login.jsp";
	}
}
