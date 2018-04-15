package com.bjsxt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		Cookie c100=new Cookie("name", "zhangsan");
		resp.addCookie(c100);
		HttpSession hs = req.getSession();
		hs.setAttribute("s", "张三存了200万");
		hs.getAttribute("");
		hs.invalidate();
		resp.getWriter().write("session实现");
	}
}
