package com.bjsxt.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class loginServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//������������ʽ
			req.setCharacterEncoding("utf-8");
		//������Ӧ�����ʽ
			resp.setCharacterEncoding("utf-8");
			resp.setContentType("text/html;charset=utf-8");
		//��ȡ��Ӧ����
			String uname=req.getParameter("uname");
			String name=null;
			try {
			name=new loginDao().checkUserInfo(uname);
			System.out.println(name);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		//�ж��û���Ϣ
			if(uname.equals(name)){
				resp.getWriter().write("true");
			}else{
				resp.getWriter().write("false");
			}
	}
}
