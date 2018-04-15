package com.bjsxt.loginDao02;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//三天免登陆--Cookies--三天之内登录直接进入主页
public class loginPage extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
			resp.getWriter().write("<html>");
		    resp.getWriter().write("<head>");
		    resp.getWriter().write("<meta charset='utf-8'/>");
		    resp.getWriter().write("</head>");
		    resp.getWriter().write("<body>");
		    resp.getWriter().write("<form action='check' method='get'>");
		    if(req.getAttribute("str")!=null){
		    	String str=(String) req.getAttribute("str");
		    	resp.getWriter().write(str+"<br /><br />");
		    }
		    resp.getWriter().write("用户名：<input type='text' name='uname' value=''/><br />");
		    resp.getWriter().write("密码：<input type='password' name='pwd' value=''/><br />");
		    resp.getWriter().write("<input type='submit' value='登录'/><br />");
		    resp.getWriter().write("</form>");
		    resp.getWriter().write("</body>");
		    resp.getWriter().write("</html>");
	}
}
