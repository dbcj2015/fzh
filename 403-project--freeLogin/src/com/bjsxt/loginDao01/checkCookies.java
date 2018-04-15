package com.bjsxt.loginDao01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//从该servlet处登录
public class checkCookies extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Cookie[] id = req.getCookies();
		System.out.println("********"+id);
		if(id!=null){
			//请求转发
				req.getRequestDispatcher("main").forward(req, resp);
		}else{
				req.getRequestDispatcher("lp").forward(req, resp);
		}
	}
}
