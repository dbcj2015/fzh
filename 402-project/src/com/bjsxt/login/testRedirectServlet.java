package com.bjsxt.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*�ض���ѧϰ��
* 		���ã�ʵ�ֲ��õ�ҵ��ģ��֮����໥��ת��
* 		ʹ�ã�
* 			resp.sendRediect("URL����URI")
* 		�ص�:
* 			1����������
* 			2����ַ����Ϣ�ı䡣
* 	ԭ��:��������������������ʱ�򣬷������ڴ������������ʱ�򣬷��ֵ�ǰϵͳ�޷�����������󣬾���ת������ϵͳ���д���
* 		����:�Ա���ѡ�е���Ʒ��Ҫ��ת��֧����ϵͳ����֧��
* */
public class testRedirectServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//������������ʽ
			req.setCharacterEncoding("utf-8");
		//������Ӧ�����ʽ
			resp.setCharacterEncoding("utf-8");
			resp.setContentType("text/http;charset=utf-8");
		//�ض���
			//�ⲿ��Դ--URL
//				resp.sendRedirect("http://www.baidu.com");
			//�ڲ���Դ--URI
				resp.sendRedirect("page");
	}
}
