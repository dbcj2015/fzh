package com.bjsxt.loginDao01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class mainPage extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/http;charset=utf-8");
		resp.getWriter().write("<html>");
	    resp.getWriter().write("<head>");
	    resp.getWriter().write("<meta charset='utf-8'/>");
	    resp.getWriter().write("</head>");
	    resp.getWriter().write("<body>");
	    resp.getWriter().write("<h3>"+"»¶Ó­"+req.getParameter("uname")+"À´µ½401Ï¿¹È</>");
	    resp.getWriter().write("</body>");
	    resp.getWriter().write("</html>");
	}
}
