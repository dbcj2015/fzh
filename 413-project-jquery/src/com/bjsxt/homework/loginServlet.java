package com.bjsxt.homework;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class loginServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String name=req.getParameter("uname");
		System.out.println(name);
		String uname=null;
		try {
			uname=new JQueryAjaxLoginDao().checkUserInfo(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(name.equals(uname)){
			System.out.println("true");
			resp.getWriter().write("true");
		}else{
			resp.getWriter().write("false");
		}
	}
}
