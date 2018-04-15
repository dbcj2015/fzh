package com.bjsxt.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*重定向学习：
* 		作用：实现不用的业务模块之间的相互跳转。
* 		使用：
* 			resp.sendRediect("URL或者URI")
* 		特点:
* 			1、两次请求
* 			2、地址栏信息改变。
* 	原因:当浏览器发送数据请求的时候，服务器在处理数据请求的时候，发现当前系统无法处理该种请求，就跳转到其他系统进行处理
* 		例如:淘宝网选中的商品需要跳转到支付宝系统进行支付
* */
public class testRedirectServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//设置请求编码格式
			req.setCharacterEncoding("utf-8");
		//设置响应编码格式
			resp.setCharacterEncoding("utf-8");
			resp.setContentType("text/http;charset=utf-8");
		//重定向
			//外部资源--URL
//				resp.sendRedirect("http://www.baidu.com");
			//内部资源--URI
				resp.sendRedirect("page");
	}
}
