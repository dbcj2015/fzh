package com.bjsxt.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bjsxt.entry.User;
import com.bjsxt.service.ClazzService;
import com.bjsxt.serviceimp.ClazzServiceImp;

public class clazzServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//������������ʽ
			req.setCharacterEncoding("utf-8");
		//������Ӧ�����ʽ
			resp.setCharacterEncoding("utf-8");
			resp.setContentType("text/html;charset=utf-8");
		String oper=req.getParameter("oper");
		if("clazzInfo".equals(oper)){
			getClazz(req,resp);
		}
	}
	//��ȡ�༶���е���Ϣ
	private void getClazz(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//��������User�����л�ȡrid
		String rid=req.getParameter("rid");
		System.out.println("��ǰ��ɫ��rid="+rid);
		ClazzService cs=new ClazzServiceImp();
		ArrayList<User> list=cs.getClazzInfoService(rid);
		System.out.println("ȫ����ϢΪ:"+list);
		
		if(list!=null){
			//���༶��Ϣ�洢����������
				req.setAttribute("list", list);
				req.setAttribute("rid", rid);
			//����ת��
			req.getRequestDispatcher("clazz/clazzInfo.jsp").forward(req, resp);
		}
	}
}
