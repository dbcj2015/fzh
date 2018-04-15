package com.bjsxt.loginDao02;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class checkLoginPage extends HttpServlet {
	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
//		String pwd=req.getParameter("pwd");
		String name=req.getParameter("uname");
		String pwd=req.getParameter("pwd");
		req.setAttribute("uname", name);
			int id=0;
			try {
				id = new loginDao().checkLoginInfo(name);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		//�˴�Ӧ����У���û����Լ������Ƿ���󣬲�������cookie
		if(id>0){
			Cookie c=new Cookie("id",id+"");
			c.setMaxAge(3600*24*3);   
			resp.addCookie(c);
			req.getRequestDispatcher("main").forward(req, resp);
		}else{
			req.setAttribute("str", "�û������������");
			req.getRequestDispatcher("lp").forward(req, resp);
		}
	}

	
}
