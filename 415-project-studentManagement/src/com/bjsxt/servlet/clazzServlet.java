package com.bjsxt.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bjsxt.entry.User;
import com.bjsxt.service.ClazzService;
import com.bjsxt.serviceimp.ClazzServiceImp;

public class clazzServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//设置请求编码格式
			req.setCharacterEncoding("utf-8");
		//设置响应编码格式
			resp.setCharacterEncoding("utf-8");
			resp.setContentType("text/html;charset=utf-8");
		String oper=req.getParameter("oper");
		if("clazzInfo".equals(oper)){
			getClazz(req,resp);
		}
	}
	//获取班级所有的信息
	private void getClazz(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//从作用域User对象中获取rid
		String rid=req.getParameter("rid");
		System.out.println("当前角色的rid="+rid);
		ClazzService cs=new ClazzServiceImp();
		ArrayList<User> list=cs.getClazzInfoService(rid);
		System.out.println("全班信息为:"+list);
		
		if(list!=null){
			//将班级信息存储在作用域中
				req.setAttribute("list", list);
				req.setAttribute("rid", rid);
			//请求转发
			req.getRequestDispatcher("clazz/clazzInfo.jsp").forward(req, resp);
		}
	}
}
