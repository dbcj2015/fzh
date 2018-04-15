package com.bjsxt.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class loginServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//设置请求编码格式
			req.setCharacterEncoding("utf-8");
		//设置响应编码格式
			resp.setCharacterEncoding("utf-8");
			resp.setContentType("text/html;charset=utf-8");
		//获取响应数据
			String uname=req.getParameter("uname");
			String name=null;
			try {
			name=new loginDao().checkUserInfo(uname);
			System.out.println(name);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		//判断用户信息
			if(uname.equals(name)){
				resp.getWriter().write("true");
			}else{
				resp.getWriter().write("false");
			}
	}
}
