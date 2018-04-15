package com.bjsxt.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.entry.Role;
import com.bjsxt.service.AdminService;
import com.bjsxt.serviceimp.AdminServiceImp;
import com.google.gson.Gson;

public class AdminServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String oper=req.getParameter("oper");
		System.out.println("***************************************");
		System.out.println(oper);
		if("role".equals(oper)){
			selectAllRole(req,resp);
		}
	}
	//获取角色信息
	private void selectAllRole(HttpServletRequest req, HttpServletResponse resp) {
		AdminService as=new AdminServiceImp();
		ArrayList<Role> list=as.selectRoleInfoService();
		System.out.println("角色信息为:"+list);
		if(list!=null){
			req.setAttribute("list", list);
			String str=new Gson().toJson(list);
				try {
					resp.getWriter().write(str);
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
}
