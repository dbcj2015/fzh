package com.bjsxt.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bjsxt.dao.loginDao;
import com.bjsxt.vo.User;

public class CheckLoginPage extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//设置请求编码格式
			req.setCharacterEncoding("utf-8");
		//设置响应编码格式
			resp.setCharacterEncoding("utf-8");
			resp.setContentType("text/html;charset=utf-8");
		//获取响应数据
			String name=req.getParameter("uname");
			System.out.println("name="+name);
			String pwd=req.getParameter("pwd");
		//处理响应数据
			//校验登录信息
				User user=null;
				try {
					user=new loginDao().getUserInfo(name);
					System.out.println(user.getName());
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				if(user!=null){
					//创建cookie信息
						Cookie cookie=new Cookie("uid",user.getId()+"");
						cookie.setMaxAge(3600*24);
						resp.addCookie(cookie);
					//创建session对象
						HttpSession hs=req.getSession();
						hs.setAttribute("user", user);
					//请求转发
						req.setAttribute("uname", user.getName());
						req.getRequestDispatcher("mainPage.jsp").forward(req, resp);
				}else{
					String str="用户名或者密码错误";
					req.setAttribute("str", str);
					req.getRequestDispatcher("LoginPage.jsp").forward(req, resp);
				}
	}	
}
