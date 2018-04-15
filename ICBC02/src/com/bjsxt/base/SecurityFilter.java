package com.bjsxt.base;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SecurityFilter implements Filter{
	
	private String[] exlist = null;
	//�ڳ�ʼ��web.xmlʱִ��
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		//���ַ�ʽ��������������ʱ��ͻ�ִ��
		//�����ļ��ĳ�ʼ����������������ʱ��ִ��
		System.out.println("���ǳ�ʼ������");
		String exs = filterConfig.getInitParameter("exclude");//��ȡ������web.xml�е�exclude����
		System.out.println(exs+"*****************");
		exlist = exs.split(",");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)resp;
		String uri = request.getRequestURI();
		//System.out.println(uri);
		//����̬��Դ��login��¼��صĵ�ַ�ų�����
		if(uri.indexOf("/resources/")!=-1){
			//System.out.println("���Ǿ�̬��Դ");
			chain.doFilter(req, resp);//ֱ����Ӧ�������,������Ὣ�þ�̬��Դ�����ڻ�����,�ٴη��ʸõ�¼ҳ��Ͳ��ᷢ������
			return;
		}
		
		//��exclue�ų��б��е�uri������¼У��
				for(String ex : exlist){
					if(uri.endsWith(ex) == true){
						chain.doFilter(req, resp);
						return;
					}
				}
		//�������¼��,��̬��Դ�������·��ͣ����¼�������໥������
		//session�����������ÿ��������ʱ���Զ�����,��̨�н��û���Ϣ�洢��������ж�Ӧ��session������
		HttpSession session=request.getSession();
		Object userInfo = session.getAttribute("username");
		if(userInfo!=null){
			//System.out.println("��¼�ɹ�");
			chain.doFilter(req, resp);
		}else{
			//System.out.println("�����µ�¼");
			request.setAttribute("message", "���µ�¼");
			request.getRequestDispatcher("/login.jsp").forward(req, resp);
			chain.doFilter(req, resp);
		}
		//System.out.println("�᲻��ִ��?");
		
		
	}

	

}
