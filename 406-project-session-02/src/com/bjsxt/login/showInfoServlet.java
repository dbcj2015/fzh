package com.bjsxt.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bjsxt.vo.User;

public class showInfoServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//������������ʽ
			req.setCharacterEncoding("utf-8");
		//������Ӧ�����ʽ
			resp.setCharacterEncoding("utf-8");
			resp.setContentType("utf-9");
		//��ȡ������Ϣ
			HttpSession hs=req.getSession();
			User user=(User)hs.getAttribute("user");
			System.out.println(user+"*********");
			//����ת��
				if(user!=null){
					req.setAttribute("user", user);
					req.getRequestDispatcher("showInfo.jsp").forward(req, resp);
				}
		
	}
}
