package com.bjsxt.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bjsxt.vo.User;

public class showInfoServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//设置请求编码格式
			req.setCharacterEncoding("utf-8");
		//设置响应编码格式
			resp.setCharacterEncoding("utf-8");
			resp.setContentType("utf-9");
		//获取请求信息
			HttpSession hs=req.getSession();
			User user=(User)hs.getAttribute("user");
			System.out.println(user+"*********");
			//请求转发
				if(user!=null){
					req.setAttribute("user", user);
					req.getRequestDispatcher("showInfo.jsp").forward(req, resp);
				}
		
	}
}
