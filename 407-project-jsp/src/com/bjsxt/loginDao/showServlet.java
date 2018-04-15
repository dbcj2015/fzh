package com.bjsxt.loginDao;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class showServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		ArrayList<User> list=null;
		try {
			list=new LoginDao().checkUserInfo();
			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(list!=null){
			req.setAttribute("list", list);
			req.getRequestDispatcher("showPage.jsp").forward(req, resp);
		}
	}
}
