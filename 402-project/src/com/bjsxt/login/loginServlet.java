package com.bjsxt.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//三种提交方式，service()方法的优先级最高
public class loginServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

			
		//设置请求数据编码格式:如果是get方式提交--需要设置服务器以及控制台打印编码格式
						//如果是post提交方式--只需要设置控制台打印的编码格式
			req.setCharacterEncoding("utf-8");
			resp.setCharacterEncoding("utf-8");
			resp.setContentType("text/html;charset=utf-8");
			System.out.println("loginServlet.service(我是service请求方式)");
			String uname=req.getParameter("uname");
			String pwd=req.getParameter("pwd");
			System.out.println(uname+":"+pwd);
			req.setAttribute("str", "用户名或密码错误");
			//如果用户名和密码都正确:提交成功；反之:打印--用户名或者密码错误
			if(uname.equals("张三") && pwd.equals("123")){
				resp.getWriter().write("登录成功");
			}else{
				//如果密码或者用户名错误，请求内部转发，重写打开登录页面
				req.getRequestDispatcher("page").forward(req, resp);
				return;
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("loginServlet.doGet(我是get请求方式)");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//为了演示post提交方式，创建一个login.html
		System.out.println("loginServlet.doPost(我是post请求方式)");
	}
}
