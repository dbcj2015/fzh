package com.bjsxt.homework;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class testLife extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("testLife.service(我被执行了)");
		resp.getWriter().write("ok");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("testLife.init(我被初始化了)");
	}
	
	@Override
	public void destroy() {
		System.out.println("testLife.destroy(我被销毁了)");
	}
}
