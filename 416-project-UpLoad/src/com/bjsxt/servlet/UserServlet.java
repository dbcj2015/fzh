package com.bjsxt.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.entry.User;
import com.bjsxt.uploadService.UserService;
import com.bjsxt.uploadserviceimp.UserServiceImp;

public class UserServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//���ñ����ʽ
			req.setCharacterEncoding("utf-8");
		//������Ӧ�����ʽ
			resp.setCharacterEncoding("utf-8");
			resp.setContentType("text/html;charset=utf-8");
		//��ȡ�û���Ϣ
			UserService us=new UserServiceImp();
			ArrayList<User> list=us.selectUserInfoService();
			System.out.println(list);
			if(list!=null){
				//���û���Ϣ�洢����������
				req.setAttribute("list", list);
				//����ת��
					req.getRequestDispatcher("showInfo.jsp").forward(req, resp);
			}
	}
}
