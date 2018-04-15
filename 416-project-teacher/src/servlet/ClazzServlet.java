package com.bjsxt.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.entry.User;
import com.bjsxt.service.ClazzService;
import com.bjsxt.serviceImp.ClazzServiceImp;

public class ClazzServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//������������ʽ
			req.setCharacterEncoding("utf-8");
		//������Ӧ�����ʽ
			resp.setCharacterEncoding("utf-8");
			resp.setContentType("text/html;charset=utf-8");
		//��ȡ������
			String oper=req.getParameter("oper");
		//�ж�
			if("clazzInfo".equals(oper)){
				getClazzInfo(req,resp);

			}
	}
	//��ȡ���е�ѧ����Ϣ
	private void getClazzInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//��ȡ��ɫid
			String rid=req.getParameter("rid");
		//����service���ȡ���е�ѧ����Ϣ
			ClazzService cs=new ClazzServiceImp();
			ArrayList<User> list=cs.getClazzInfoService(rid);
			System.out.println("���е�ѧ����ϢΪ:"+list);
		//��Ӧ������
			if(list!=null){
				//��ѧ����Ϣ�洢��request��������
				req.setAttribute("list",list);
				//����ת��
				req.getRequestDispatcher("clazz/clazzList.jsp").forward(req, resp);
			}
			
		
	}
}
