package com.bjsxt.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class testSession2 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession hs=req.getSession();
		System.out.println("testSession2.service()"+hs.getId());
			//ע��:��Ȼ��������ͬ��servlet���󣬵��Ǳ��id��ͨ��cookiesЯ���ģ��ڷ���ͬһ����Ŀ�µ���������
			//��������Ὣ������Ϣ�Լ�id����cookies���󣬲��ҷ�װ��requenst�������Ը�servlet�����ڷ�������
			//��ʱ�Ǵӵ�ǰ��Ŀ�·������д��ڵ�session�����л�ȡ��
		
		//��session�����л�ȡ����--���ȱ���洢���ݲſ��Ի�ȡ����
			//ÿ������������������ȴ�������session���󣬲ſ��Է��ʻ�ȡ���ݵ�servlet����
			//�ڷ���session2֮ǰһ��Ҫ����session,session2�ڻ�ȡsession������ʱ��������session�����д洢����
			String str=(String) hs.getAttribute("str");
			System.out.println(str);
	}
}
