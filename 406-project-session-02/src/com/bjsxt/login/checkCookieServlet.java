package com.bjsxt.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bjsxt.dao.loginDao;
import com.bjsxt.vo.User;

public class checkCookieServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//������������ʽ
			req.setCharacterEncoding("utf-8");
		//������������ʽ
			resp.setCharacterEncoding("utf-8");
			resp.setContentType("text/html;charset=utf-8");
			
		//��ȡ������Ϣ
			//��ȡcookie��Ϣ
				Cookie[] c = req.getCookies();
				if(c!=null){
					for (int i = 0; i < c.length; i++) {
						if("uid".equals(c[i].getName())){
							String id=c[i].getValue();
							System.out.println(id);
							User user=null;
							try {
								user=new loginDao().checkUserInfo(id);
							} catch (Exception e) {
								e.printStackTrace();
							}
							
							if(user.getName()!=null){
								//����ת��
									req.setAttribute("uname", user.getName());
									//����session����
										HttpSession hs=req.getSession();
										hs.setAttribute("user", user);
										req.getRequestDispatcher("mainPage.jsp").forward(req, resp);	
							}else{
								
							}
						}
					}
				}else{
					req.getRequestDispatcher("LoginPage.jsp").forward(req, resp);
				}
				
	}
}
