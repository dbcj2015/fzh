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
		
		resp.getWriter().write("<h3>��ӭ"+uname+"��½404Ͽ��</h3>");
		resp.getWriter().write("<hr />");
		resp.getWriter().write("<form action='show' metion='get'>");
		//����û���½�ɹ��������û����鿴��ϸ��Ϣ
		resp.getWriter().write("<input type='hidden' name='uname' value='"+uname+"' />");
		resp.getWriter().write("<input type='submit' value='������Ϣ'/>");
		resp.getWriter().write("<hr />");
		resp.getWriter().write("<form />");
		
		
	}
}
