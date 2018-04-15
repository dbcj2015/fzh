package com.bjsxt.servlet;
import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class jdbcServlet extends HttpServlet {
	
	public jdbcServlet(){
		System.out.println("正在被实例化");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("正在被初始化");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("正在处理请求");
		resp.getWriter().write("<b>响应结果</b>");
		
	}
	
	@Override
	public void destroy() {
		System.out.println("正在被销毁");
	}
}
