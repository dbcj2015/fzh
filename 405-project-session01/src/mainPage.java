import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class mainPage extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		String uname=(String) req.getAttribute("uname");
		
		resp.getWriter().write("<h3>欢迎"+uname+"登陆404峡谷</h3>");
		resp.getWriter().write("<hr />");
		resp.getWriter().write("<form action='show' metion='get'>");
		//如果用户登陆成功，利用用户名查看详细信息
		resp.getWriter().write("<input type='hidden' name='uname' value='"+uname+"' />");
		resp.getWriter().write("<input type='submit' value='个人信息'/>");
		resp.getWriter().write("<hr />");
		resp.getWriter().write("<form />");
		
		
	}
}
