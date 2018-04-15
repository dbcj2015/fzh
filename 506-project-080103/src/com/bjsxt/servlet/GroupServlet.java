package com.bjsxt.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.entry.Sign;
import com.bjsxt.entry.User;
import com.bjsxt.service.GroupService;
import com.bjsxt.serviceImp.GroupServiceImp;

public class GroupServlet extends HttpServlet {
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
			if("groupInfo".equals(oper)){
				getGroupInfo(req,resp);
			}else if("showSign".equals(oper)){
				showSignInfo(req,resp);	
			}
	}
	//��ѯС��ָ����Ա��ǩ��ǩ����Ϣ
	private void showSignInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//��ȡ��������
			String unumber =req.getParameter("unumber");
			String uname=req.getParameter("uname");
			//��ȡ����ҳ����
			String page=req.getParameter("page");
			System.out.println(unumber+":"+uname+":"+page);
		//������������
			//����service��ȡ���е�С���Ա��Ϣ
			GroupService gs=new GroupServiceImp();	
			ArrayList<Sign> list=gs.getSignInfoService(unumber,page);
			System.out.println(list);
			//��ѯС���Ա��ǩ��ǩ����Ϣ��¼����
			int count=gs.getCountInfoService(unumber);
			System.out.println("�û�ǩ��������Ϊ:"+count);
			//������ҳ��
			int pageCount=(int)Math.ceil(count*1.0/5);
		//��Ӧ������
			if(list!=null){
				//����ǰҳ��洢����������
				req.setAttribute("page",page);
				//����������ҳ�����洢����������
				req.setAttribute("count",count);
				req.setAttribute("pageCount",pageCount);
				//�����ݴ洢����������
				req.setAttribute("list",list);
				//��Ҫ��ѯ���û����浽��������
				req.setAttribute("uname",uname);
				//����ת��
				req.getRequestDispatcher("group/showSign.jsp").forward(req, resp);
			}
		
	}
	//��ȡС����Ϣ
	private void getGroupInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//��ȡsession�е�unumber
		int unumber=((User)req.getSession().getAttribute("u")).getUnumber();
		//��������
			//����service��ȡ���е�С���Ա��Ϣ
			GroupService gs=new GroupServiceImp();
			ArrayList<User> list=gs.getGroupInfoService(unumber);
			System.out.println(list);
		//��Ӧ������
			if(list!=null){
				//��С����Ϣ�洢��request��������
				req.setAttribute("list",list);
				//����ת����GroupList.jsp
				req.getRequestDispatcher("group/groupList.jsp").forward(req, resp);
				
			}
		
	}
}
