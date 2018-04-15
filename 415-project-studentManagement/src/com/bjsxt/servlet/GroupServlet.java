package com.bjsxt.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bjsxt.entry.Sign;
import com.bjsxt.entry.User;
import com.bjsxt.service.GroupService;
import com.bjsxt.serviceimp.GroupServiceImp;

public class GroupServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//������������ʽ
			req.setCharacterEncoding("utf-8");
		//������Ӧ�����ʽ
			resp.setCharacterEncoding("utf-8");
			resp.setContentType("text/html;charset=utf-8");
		String oper=req.getParameter("oper");
		System.out.println("oper="+oper);
		if("groupInfo".equals(oper)){
			getGruopInfo(req,resp);
		}else if("showSign".equals(oper)){
			getUserSignInfo(req,resp);
		}
	}
	//��ȡĳ����Ա��ǩ��ǩ����Ϣ
	private void getUserSignInfo(HttpServletRequest req,
			HttpServletResponse resp) {
		//��ȡǩ����Ϣ
			String unumber=req.getParameter("unumber");
			String uname=req.getParameter("uname");
			//ҳ��
			String page=req.getParameter("page");
			System.out.println(unumber+":"+uname+"��"+"ǩ��ҳ��Ϊ:"+page);
			GroupService gs=new GroupServiceImp();
		//ͳ������ĳ����Ա����ǩ��ǩ����Ϣ����
			int pageAllCount=gs.getSignCountService(unumber);
			System.out.println(uname+"ǩ��ǩ������Ϊ:"+pageAllCount);
		//����ÿ����Ҫ��ȡ��ǩ��ǩ��ҳ��--�涨ÿҳ��5����Ϣ
			//����֮����������ӦΪ4.6�����յĽ����4��ͨ����������Ϊdouble���͵õ��Ľ��Ϊ4.6,ͨ��ceil�����õ����Ϊ5
				int pageCount=(int)Math.ceil((pageAllCount*1.0/5));
		//�õ���ǰ��ɫ��Ӧĳ����Ա��ǩ��ǩ�����е���Ϣ
			ArrayList<Sign> newList=gs.getUserSignInfoService(unumber,page);
			System.out.println("��Աǩ��ǩ����ϢΪ:"+newList);
			if(newList!=null){
				//����Ϣ�洢����������
					req.setAttribute("newList", newList);
					req.setAttribute("uname", uname);
					req.setAttribute("pageCount", pageCount);
					req.setAttribute("pageAllCount", pageAllCount);
					req.setAttribute("page", page);
				//����ת��
				try {
					req.getRequestDispatcher("group/showSign.jsp").forward(req, resp);
				} catch (ServletException | IOException e) {
					e.printStackTrace();
				}
			}
		
	}
	//��ȡ��Ա��Ϣ
	private void getGruopInfo(HttpServletRequest req, HttpServletResponse resp){
		//ͨ��session��ȡ--�������ȵ���User��
		int unumber=((User)req.getSession().getAttribute("user")).getUnumber();
		System.out.println(unumber);
		//��������
			//����service��ȡ���е�С���Ա��Ϣ
				GroupService gs=new GroupServiceImp();
				ArrayList<User> list=gs.getGroupInfoService(unumber);
				System.out.println("��Ա������ϢΪ:"+list);
			if(list!=null){
				//��list�洢����������
					HttpSession hs=req.getSession();
					hs.setAttribute("list", list);
				//�ض���
				try {
					req.getRequestDispatcher("group/groupInfo.jsp").forward(req, resp);
				} catch (ServletException | IOException e) {
					e.printStackTrace();
				}
			}
	}
}
