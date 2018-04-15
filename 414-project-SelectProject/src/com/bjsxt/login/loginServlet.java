package com.bjsxt.login;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class loginServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//设置请求编码格式
			req.setCharacterEncoding("utf-8");
		//设置响应数据格式
			resp.setCharacterEncoding("utf-8");
			resp.setContentType("text/html;charset=utf-8");
		//获取响应数据
			String id=req.getParameter("pid");
			System.out.println(id);
		//查询数据库
			ArrayList list=new SelectDao().getAddrInfo(id);
		//将list中的数据转换给字符串数据响应给客户端
			String str=new Gson().toJson(list);
			System.out.println(str);
			resp.getWriter().write(str);
		
	}
}
