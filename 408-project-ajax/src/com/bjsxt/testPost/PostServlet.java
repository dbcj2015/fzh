package com.bjsxt.testPost;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PostServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String name=req.getParameter("uname");
		System.out.println(name);
		if("�빮".equals(name)){
			resp.getWriter().write("�û�����ע��");
		}else{
			resp.getWriter().write("��ϲע��ɹ�");
		}
	}
}
