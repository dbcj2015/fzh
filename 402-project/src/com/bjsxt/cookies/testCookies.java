package com.bjsxt.cookies;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class testCookies extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//�����������ݱ����ʽ
			req.setCharacterEncoding("utf-8");
		//������Ӧ���ݱ����ʽ
			resp.setCharacterEncoding("utf-8");
		//����������������ݵı����ʽ
			resp.setContentType("text/html;charset=utf-8");
		//��ȡ������Ϣ
//			String uname=req.getParameter("uname");
//			String pwd=req.getParameter("pwd");
			String phone=req.getParameter("phone");
		//����������Ϣ--Cookies��Ϣ�����ڸò����д���
			//�������ݿ�:Cookies��Ϣ��ʵ���ǲ������ݿ�
			System.out.println(phone);
			//����Cookie--��������������ݴ洢����
				//û��д�������ʵ�ʱ����Ҫ����phone
				Cookie c=new Cookie("phone", phone);
		//��Ӧ������
			//ֱ����Ӧ
				//��ӦCookie��Ϣ--֪ͨ����������ݴ洢����
					//����cookie��Ϣ
					resp.addCookie(c);
					resp.getWriter().write("���빺�ﳵ�ɹ�");
				//��ִ������������ͷ��Ϣ�оͻ�Я��������Ϣ
				//֮����ʸ���Ŀ���κε��������󶼻�Я������Ϣ:http://localhost:8080/402/bdusabvj
				//����һ����Ŀ������������ĳ���û����ʾ�����ͬ��Ŀ
			//����cookie����Ч��
					//д���ˣ�ֱ�ӷ���
					Cookie c1=new Cookie("car","113344");
					c1.setMaxAge(3600*24*3);
					resp.addCookie(c1);
					resp.getWriter().write("���빺�ﳵ�ɹ�");
					//�����´�����cookie���󣬵�һ�ν�����������ʱ��������ϰ��ŷ�������������Ϊcookies����Ĵ��������ض���ĳ��servlet������
					//ֻ�е�һ�η�����������ʱ��Ը�servlet���󣬷���������Ӧ������ʱ������Ż�Я��������Ϣ
					//֮����ʸ���Ŀ�µ�����servlet�������������Я������Ϣ����������ת��ҳ��"���빺�ﳵ�ɹ�"
					//ҳ��ͬ����ʾ���󣬵�������ͷ��Ϣ����cookies��Ϣ
					//ע�⣺	
					 	//Ĭ����Ч���Ǳ��λػ����洢����������ڴ��У�������رռ�ʧЧ
					 	//������Ч�ں�洢���ͻ��˵�Ӳ���У�������رղ�ʧЧ��
					Cookie c2=new Cookie("key","334455");
					c2.setMaxAge(3600*24*3);
					resp.addCookie(c2);
			//����Cookie����Ч·��
				Cookie c3=new Cookie("byte","335");
				c3.setMaxAge(3600*24*3);
				c3.setPath("/401/bb");
				resp.addCookie(c3);
				//Ĭ������Ŀ����Ч����Ŀ��Χ�ڵ����󶼻ḽ��
				//��������Ч·����Cookieֻ������Ч·���ķ��ʲŻḽ��--����ʱ����ָ��·��
				
	}
}
