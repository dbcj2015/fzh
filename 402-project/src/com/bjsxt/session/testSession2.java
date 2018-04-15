package com.bjsxt.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class testSession2 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession hs=req.getSession();
		System.out.println("testSession2.service()"+hs.getId());
			//注意:虽然是两个不同的servlet对象，但是标记id是通过cookies携带的，在访问同一个项目下的两次请求
			//浏览器都会将共享信息以及id赋给cookies对象，并且封装在requenst对象，所以该servlet对象在访问数据
			//库时是从当前项目下服务器中存在的session对象中获取的
		
		//从session对象中获取数据--首先必须存储数据才可以获取数据
			//每次重启服务器后必须先创建对象session对象，才可以访问获取数据的servlet对象
			//在访问session2之前一定要访问session,session2在获取session的数据时，必须在session对象中存储数据
			String str=(String) hs.getAttribute("str");
			System.out.println(str);
	}
}
