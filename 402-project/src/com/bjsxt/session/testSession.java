package com.bjsxt.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/*
 * sessionѧϰ:
 * 		��cookie������:session�����Ƿ������Ѿ��õ���������������󣬲�����Ҫ��β������ݿ�
 * 					cookie���������������������������ʱЯ���Ĺ�����Ϣ��session�ڴ�������ʱ
 * 					˵����ʱ������Ϣ�Ѿ�������cookie�����Ĺ�����Ϣ
 * 		session:����������Բ�ͬ�û��ᴴ����ͬ��session�������ʹsession�������û�һһ��Ӧ?
 * 		����:
 * 			��ͬ�������ڴ����ʱ�򣬻�ʹ�õ���ͬ�����ݣ�����ҵ���߼���ͬ������Ҫ�����������ͬһ������
 * 			�����ɲ�ͬ������Ƶ���Ĳ�������������ͬһ������
 * 		ʹ��:��ͬ���û���Ӧ���Ե�session���������洢��Ӧ�û�������
 * 			�������ݵ�һ�η������ݿ�ʱ������session����洢�����������ڷ�������:
 * 				����session����
 * 				����session����
 * 				��session�����д洢����
 * 			�������ݵڶ��η������ݿ�,����Ҫ�������ݿ⣬ֱ�Ӵӷ�������session�����л�ȡ
 * 				��ȡsession����
 * 				��ȡsession�����д洢������
 */
public class testSession extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//���ñ����ʽ
		//������Ӧ�����ʽ
		//��ȡ������Ϣ
		//����������Ϣ
			//�������ݿ�
			//����cookie(���������)
				Cookie c=new Cookie("phone", "123");
				c.setMaxAge(3600*24);
				resp.addCookie(c);
			//����session(���ڷ�����)
					//ע��:���±��ʽ����������˼:
							//1����һ����������������ݿ�ʱ����û�д���session���󣬻�ȡ�����ݺ�
								//������session���󣬲��ҵõ�session���󸳸��ı��
							//2���ڶ�����������������ݿ�ʱ��ƾ����ֱ�ӻ�ȡsession�����е�����
				HttpSession hs=req.getSession();
				//���:id--��Ϊ�����ÿ���������󶼱���Я����������cooKies����һ������ʵ�����ڴ���session
				//����ʱ���Զ���cookiesһ����ǣ�ÿ����������ʱ����Я��id,���Ҹ�id�Ǵ洢���������
				System.out.println(hs.getId());
			//�����ݴ洢��session������
				hs.setAttribute("str", "500");
			//����sessoin����Ч��
				hs.setMaxInactiveInterval(3600);
		//��Ӧ������
			//ֱ����Ӧ
			//����ת��
			//�ض���
	}
}















