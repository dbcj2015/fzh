package com.bjsxt.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//在浏览器中加载:localhost:8080/402/page是为了让服务器通过暗号找到该文件，执行后生成了登录页面，登录页面在提交用户信息时
//通过action值作为暗号提交给loginServlet对象执行
public class loginPage extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
			req.setCharacterEncoding("utf-8");
			resp.setCharacterEncoding("utf-8");
			resp.setContentType("text/html;charset=utf-8");
		

		    String str = (String)req.getAttribute("str");
		    System.out.println("LoginPage.service(" + str + ")");

		    resp.getWriter().write("<html>");
		    resp.getWriter().write("<head>");
		    resp.getWriter().write("</head>");
		    resp.getWriter().write("<body>");
		    //LoginPage.service(null)--因为首先执行loginPage时，并没有提交数据
		    //下面的action的选项是服务器根据暗号创建servlet对象
		    resp.getWriter().write("<form action='login' method='get'>");
		    if (str != null) {
		      resp.getWriter().write(str + "<br />");
		    }
		    resp.getWriter().write("用户名：<input type='text' name='uname' value=''/><br />");
		    resp.getWriter().write("密码：<input type='password' name='pwd' value=''/><br />");
		    resp.getWriter().write("<input type='submit'  value='登录'/><br />");
		    resp.getWriter().write("</form>");
		    resp.getWriter().write("</body>");
		    resp.getWriter().write("</html>");
	}
}
