package com.bjsxt.loginDao02;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//�Ӹ�servlet����¼
public class checkCookies extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		Cookie[] cs = req.getCookies();//�洢��cookie����cookie�����Ǽ���ֵ
		
		//����ת��
		if(cs!=null){
			String uid=null;
			for (int i = 0; i < cs.length; i++) {
				//cookie�п����ж��������Ϣ
				if("id".equals(cs[i].getName())){
					uid=cs[i].getValue();//�õ�cookie�ļ�ֵ
				}
				String uname=null;
				try {
					uname = new loginDao().checkUserName(uid);
				} catch (Exception e) {
					e.printStackTrace();
				}
				if(uname!=null){
					req.setAttribute("uname", uname);
					req.getRequestDispatcher("main").forward(req, resp);
				}else{
					req.getRequestDispatcher("lp").forward(req, resp);
				}
			}
			
		}else{
			req.getRequestDispatcher("lp").forward(req, resp);
		}
	}
}
