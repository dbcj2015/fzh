package com.bjsxt.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//�����ύ��ʽ��service()���������ȼ����
public class loginServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

			
		//�����������ݱ����ʽ:�����get��ʽ�ύ--��Ҫ���÷������Լ�����̨��ӡ�����ʽ
						//�����post�ύ��ʽ--ֻ��Ҫ���ÿ���̨��ӡ�ı����ʽ
			req.setCharacterEncoding("utf-8");
			resp.setCharacterEncoding("utf-8");
			resp.setContentType("text/html;charset=utf-8");
			System.out.println("loginServlet.service(����service����ʽ)");
			String uname=req.getParameter("uname");
			String pwd=req.getParameter("pwd");
			System.out.println(uname+":"+pwd);
			req.setAttribute("str", "�û������������");
			//����û��������붼��ȷ:�ύ�ɹ�����֮:��ӡ--�û��������������
			if(uname.equals("����") && pwd.equals("123")){
				resp.getWriter().write("��¼�ɹ�");
			}else{
				//�����������û������������ڲ�ת������д�򿪵�¼ҳ��
				req.getRequestDispatcher("page").forward(req, resp);
				return;
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("loginServlet.doGet(����get����ʽ)");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//Ϊ����ʾpost�ύ��ʽ������һ��login.html
		System.out.println("loginServlet.doPost(����post����ʽ)");
	}
}
