package com.bjsxt.loginDao02;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//从该servlet处登录
public class checkCookies extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		Cookie[] cs = req.getCookies();//存储的cookie对象，cookie对象是键对值
		
		//请求转发
		if(cs!=null){
			String uid=null;
			for (int i = 0; i < cs.length; i++) {
				//cookie中可能有多个共享信息
				if("id".equals(cs[i].getName())){
					uid=cs[i].getValue();//得到cookie的键值
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
