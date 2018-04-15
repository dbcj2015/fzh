package com.bjsxt.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.entry.User;
import com.bjsxt.service.ClazzService;
import com.bjsxt.serviceImp.ClazzServiceImp;

public class ClazzServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//设置请求编码格式
			req.setCharacterEncoding("utf-8");
		//设置响应编码格式
			resp.setCharacterEncoding("utf-8");
			resp.setContentType("text/html;charset=utf-8");
		//获取操作符
			String oper=req.getParameter("oper");
		//判断
			if("clazzInfo".equals(oper)){
				getClazzInfo(req,resp);

			}
	}
	//获取所有的学生信息
	private void getClazzInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取角色id
			String rid=req.getParameter("rid");
		//调用service层获取所有的学生信息
			ClazzService cs=new ClazzServiceImp();
			ArrayList<User> list=cs.getClazzInfoService(rid);
			System.out.println("所有的学生信息为:"+list);
		//响应处理结果
			if(list!=null){
				//将学生信息存储到request作用域中
				req.setAttribute("list",list);
				//请求转发
				req.getRequestDispatcher("clazz/clazzList.jsp").forward(req, resp);
			}
			
		
	}
}
