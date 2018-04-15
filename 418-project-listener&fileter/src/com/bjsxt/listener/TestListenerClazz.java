package com.bjsxt.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/*1 ʲô��web��������
*		web��������һ��Servlet�е�������࣬�����ܰ��������߼���web�е��ض��¼���
*		����ServletContext,HttpSession,ServletRequest�Ĵ��������٣������Ĵ��������ٺ��޸ĵȡ�
*		������ĳЩ����ǰ�����Ӵ���ʵ�ּ�ء�
*����2 ���������õ���;
*����ͨ��ʹ��Web�����������µ����ݣ�
*����ͳ����������������HttpSessionLisener
*�������س�ʼ����Ϣ������ServletContextListener
*����ͳ����վ������
*����ʵ�ַ��ʼ��
 * */

public class TestListenerClazz implements ServletContextListener,ServletContextAttributeListener,HttpSessionListener,HttpSessionAttributeListener,ServletRequestListener,ServletRequestAttributeListener{
	//ʵ�����������ļ���
	private int userNumber=0;
	@Override
	public void attributeAdded(ServletRequestAttributeEvent srae) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attributeRemoved(ServletRequestAttributeEvent srae) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attributeReplaced(ServletRequestAttributeEvent srae) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attributeAdded(HttpSessionBindingEvent se) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent se) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		userNumber++;
		arg0.getSession().setAttribute("userNumber", userNumber);
		
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		 userNumber--;
	     arg0.getSession().setAttribute("userNumber", userNumber);
		
	}

	@Override
	public void attributeAdded(ServletContextAttributeEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
