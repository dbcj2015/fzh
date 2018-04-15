package com.bjsxt.log4j;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.bjsxt.entry.User;
import com.bjsxt.fz.DBUtil;
import com.bjsxt.service.UserService;
import com.bjsxt.serviceimp.UserServiceImp;

public class LoginServlet extends HttpServlet {
	private static Logger logger = Logger.getLogger(DBUtil.class);
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String uname=req.getParameter("uname");
		String unumber=req.getParameter("unumber");
		UserService us=new UserServiceImp();
		User user=us.insertUserInfoService(uname,unumber);
		System.out.println("这是info日志级别:"+user);
		logger.info("这是info日志级别:"+user);
	}
}
