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

public class CheckLoginPage extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//������������ʽ
			req.setCharacterEncoding("utf-8");
		//������Ӧ�����ʽ
			resp.setCharacterEncoding("utf-8");
			resp.setContentType("text/html;charset=utf-8");
		//��ȡ��Ӧ����
			String name=req.getParameter("uname");
			System.out.println("name="+name);
			String pwd=req.getParameter("pwd");
		//������Ӧ����
			//У���¼��Ϣ
				User user=null;
				try {
					user=new loginDao().getUserInfo(name);
					System.out.println(user.getName());
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				if(user!=null){
					//����cookie��Ϣ
						Cookie cookie=new Cookie("uid",user.getId()+"");
						cookie.setMaxAge(3600*24);
						resp.addCookie(cookie);
					//����session����
						HttpSession hs=req.getSession();
						hs.setAttribute("user", user);
					//����ת��
						req.setAttribute("uname", user.getName());
						req.getRequestDispatcher("mainPage.jsp").forward(req, resp);
				}else{
					String str="�û��������������";
					req.setAttribute("str", str);
					req.getRequestDispatcher("LoginPage.jsp").forward(req, resp);
				}
	}	
}
