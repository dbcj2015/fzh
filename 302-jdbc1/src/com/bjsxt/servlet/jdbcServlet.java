package com.bjsxt.servlet;
import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class jdbcServlet extends HttpServlet {
	
	public jdbcServlet(){
		System.out.println("���ڱ�ʵ����");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("���ڱ���ʼ��");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("���ڴ�������");
		resp.getWriter().write("<b>��Ӧ���</b>");
		
	}
	
	@Override
	public void destroy() {
		System.out.println("���ڱ�����");
	}
}
