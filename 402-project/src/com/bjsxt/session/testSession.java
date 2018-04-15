package com.bjsxt.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/*
 * session学习:
 * 		与cookie的区别:session对象是服务器已经得到浏览器的数据请求，并且需要多次操作数据库
 * 					cookie是浏览器给服务器发送数据请求时携带的共享信息，session在处理数据时
 * 					说明此时数据信息已经包含了cookie创建的共享信息
 * 		session:服务器中针对不同用户会创建不同的session对象，如何使session对象与用户一一对应?
 * 		问题:
 * 			不同的请求在处理的时候，会使用到相同的数据，尽管业务逻辑不同，但是要处理的数据是同一份数据
 * 			这就造成不同的请求频繁的操作数据来操作同一份数据
 * 		使用:不同的用户对应各自的session对象，用来存储对应用户的数据
 * 			请求数据第一次访问数据库时，利用session对象存储起来，保存在服务器中:
 * 				创建session对象
 * 				设置session对象
 * 				在session对象中存储数据
 * 			请求数据第二次访问数据库,不需要访问数据库，直接从服务器中session对象中获取
 * 				获取session对象
 * 				获取session对象中存储的数据
 */
public class testSession extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//设置编码格式
		//设置响应编码格式
		//获取请求信息
		//处理请求信息
			//操作数据库
			//创建cookie(存在浏览器)
				Cookie c=new Cookie("phone", "123");
				c.setMaxAge(3600*24);
				resp.addCookie(c);
			//创建session(存在服务器)
					//注意:以下表达式包含两层意思:
							//1、第一次数据请求访问数据库时，并没有创建session对象，获取完数据后
								//并创建session对象，并且得到session对象赋给的标记
							//2、第二次数据请求访问数据库时，凭借标记直接获取session对象中的数据
				HttpSession hs=req.getSession();
				//标记:id--因为标记是每次数据请求都必须携带，所以与cooKies作用一样，其实就是在创建session
				//对象时，自动给cookies一个标记，每次数据请求时都会携带id,并且该id是存储在浏览器中
				System.out.println(hs.getId());
			//将数据存储到session对象中
				hs.setAttribute("str", "500");
			//设置sessoin的有效期
				hs.setMaxInactiveInterval(3600);
		//响应处理结果
			//直接响应
			//请求转发
			//重定向
	}
}















