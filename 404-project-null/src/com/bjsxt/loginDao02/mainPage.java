package com.bjsxt.loginDao02;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class mainPage extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String uname = (String) req.getAttribute("uname");
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		resp.getWriter().write("<html>");
	    resp.getWriter().write("<head>");
	    resp.getWriter().write("<meta charset='utf-8'/>");
	    resp.getWriter().write("</head>");
	    resp.getWriter().write("<body>");
	    //�涨ʱ���ڷ���ʱ��������Ϣֻ��id��û���û���
	    resp.getWriter().write("<h3>"+"��ӭ"+uname+"����401Ͽ��</>");
	    resp.getWriter().write("</body>");
	    resp.getWriter().write("</html>");
	}
}
