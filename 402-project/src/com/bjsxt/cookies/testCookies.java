package com.bjsxt.cookies;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class testCookies extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//设置请求数据编码格式
			req.setCharacterEncoding("utf-8");
		//设置响应数据编码格式
			resp.setCharacterEncoding("utf-8");
		//设置浏览器解析数据的编码格式
			resp.setContentType("text/html;charset=utf-8");
		//获取请求信息
//			String uname=req.getParameter("uname");
//			String pwd=req.getParameter("pwd");
			String phone=req.getParameter("phone");
		//处理请求信息--Cookies信息就是在该步进行处理
			//操作数据库:Cookies信息其实就是操作数据库
			System.out.println(phone);
			//创建Cookie--告诉浏览器将数据存储起来
				//没有写死，访问的时候需要输入phone
				Cookie c=new Cookie("phone", phone);
		//响应处理结果
			//直接响应
				//响应Cookie信息--通知浏览器将数据存储起来
					//发送cookie信息
					resp.addCookie(c);
					resp.getWriter().write("加入购物车成功");
				//在执行完程序后，请求头信息中就会携带共享信息
				//之后访问该项目的任何的数据请求都会携带该信息:http://localhost:8080/402/bdusabvj
				//访问一个项目，就是类似于某个用户访问京东不同项目
			//设置cookie的有效期
					//写死了，直接访问
					Cookie c1=new Cookie("car","113344");
					c1.setMaxAge(3600*24*3);
					resp.addCookie(c1);
					resp.getWriter().write("加入购物车成功");
					//对于新创建的cookie对象，第一次进行数据请求时，必须加上暗号发送数据请求，因为cookies对象的创建是在特定的某个servlet对象中
					//只有第一次发送数据请求时针对该servlet对象，服务器在响应处理结果时浏览器才会携带共享信息
					//之后访问该项目下的任意servlet对象浏览器都会携带该信息，并不是跳转到页面"加入购物车成功"
					//页面同样显示错误，但是请求头信息中有cookies信息
					//注意：	
					 	//默认有效期是本次回话，存储在浏览器的内存中，浏览器关闭即失效
					 	//设置有效期后存储到客户端的硬盘中，浏览器关闭不失效。
					Cookie c2=new Cookie("key","334455");
					c2.setMaxAge(3600*24*3);
					resp.addCookie(c2);
			//设置Cookie的有效路径
				Cookie c3=new Cookie("byte","335");
				c3.setMaxAge(3600*24*3);
				c3.setPath("/401/bb");
				resp.addCookie(c3);
				//默认是项目内有效，项目范围内的请求都会附带
				//设置了有效路径的Cookie只有在有效路径的访问才会附带--访问时必须指定路径
				
	}
}
