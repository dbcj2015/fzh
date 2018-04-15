package com.bjsxt.homework;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class testRequestResponce extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String user=req.getParameter("user");
		System.out.println(user);
		String pwd=req.getParameter("pwd");
		if(user.equals("zhangsan") && pwd.equals("123456")){
			resp.setCharacterEncoding("utf-8");
//			resp.setHeader("Content-Type", "text/html;charset=utf-8");
			resp.setContentType("text/html;charset=utf-8");
			resp.getWriter().write("µÇÂ¼³É¹¦");
		}else{
			resp.setCharacterEncoding("utf-8");
			resp.setHeader("Content-Type", "text/html;charset=utf-8");
			resp.getWriter().write("µÇÂ¼Ê§°Ü");
		}
	}
}
