package com.bjsxt.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.entry.User;
import com.bjsxt.uploadService.UserService;
import com.bjsxt.uploadserviceimp.UserServiceImp;

public class UserServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//设置编码格式
			req.setCharacterEncoding("utf-8");
		//设置响应编码格式
			resp.setCharacterEncoding("utf-8");
			resp.setContentType("text/html;charset=utf-8");
		//获取用户信息
			UserService us=new UserServiceImp();
			ArrayList<User> list=us.selectUserInfoService();
			System.out.println(list);
			if(list!=null){
				//将用户信息存储到作用域中
				req.setAttribute("list", list);
				//请求转发
					req.getRequestDispatcher("showInfo.jsp").forward(req, resp);
			}
	}
}
