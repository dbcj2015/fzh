package com.bjsxt.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//��������м���:localhost:8080/402/page��Ϊ���÷�����ͨ�������ҵ����ļ���ִ�к������˵�¼ҳ�棬��¼ҳ�����ύ�û���Ϣʱ
//ͨ��actionֵ��Ϊ�����ύ��loginServlet����ִ��
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
		    //LoginPage.service(null)--��Ϊ����ִ��loginPageʱ����û���ύ����
		    //�����action��ѡ���Ƿ��������ݰ��Ŵ���servlet����
		    resp.getWriter().write("<form action='login' method='get'>");
		    if (str != null) {
		      resp.getWriter().write(str + "<br />");
		    }
		    resp.getWriter().write("�û�����<input type='text' name='uname' value=''/><br />");
		    resp.getWriter().write("���룺<input type='password' name='pwd' value=''/><br />");
		    resp.getWriter().write("<input type='submit'  value='��¼'/><br />");
		    resp.getWriter().write("</form>");
		    resp.getWriter().write("</body>");
		    resp.getWriter().write("</html>");
	}
}
