package com.bjsxt.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bjsxt.entry.Menu;
import com.bjsxt.entry.User;
import com.bjsxt.service.UserService;
import com.bjsxt.serviceimp.UserServiceImp;

public class UserServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//������������ʽ
		req.setCharacterEncoding("utf-8");
		//������Ӧ�����ʽ
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String oper=req.getParameter("oper");
		if("login".equals(oper)){
			userLogin(req,resp);
		}else if("out".equals(oper)){
			userOut(req,resp);
		}else if("in".equals(oper)){
			insertInInfo(req,resp);
		}else if("sout".equals(oper)){
			insertOutInfo(req,resp);
		}else if("info".equals(oper)){
			getUserInfo(req,resp);
		}else if("newPwd".equals(oper)){
			userUpdateNewPwd(req,resp);
		}else if("pwd".equals(oper)){
			checkUserOldPwd(req,resp);
		}
	}
	
	private void userUpdateNewPwd(HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
			//��ȡ������Ϣ
				String newPwd=req.getParameter("newPwd");
				int unumber=((User)req.getSession().getAttribute("user")).getUnumber();
				System.out.println("�û�����������ϢΪ:"+newPwd+":"+unumber);
			//����������Ϣ
				//����service�㽫ǩ����Ϣ���µ����ݿ���
				UserService us=new UserServiceImp();
				//��������µ����ݿ���
				int i=us.updateNewPwdInfoService(newPwd,unumber);
				System.out.println("�û��������:"+i);
			//��Ӧ������
				if(i>0){
					//�ض���
					resp.sendRedirect("login.jsp");
				}
		
	}
	//��֤�û�������Ϣ
	private void checkUserOldPwd(HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
		//��ȡ������Ϣ
			String oldPwd=req.getParameter("oldPwd");
			System.out.println("������Ϊ:"+oldPwd);
		//��ȡsession����
			String pwd=((User)req.getSession().getAttribute("user")).getUpwd();
			System.out.println("���ݿ��е�����Ϊ:"+pwd);
			//��ԭʼ����Ϊ�ջ���д�����붼�ᱨ��
			if(pwd.equals(oldPwd)){
				resp.getWriter().write("true");
			}else{
				resp.getWriter().write("false");
			}
	}
	//��ȡ�û��ϼ������Լ���ɫ��Ϣ
	private void getUserInfo(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		String rid=req.getParameter("rid");
		System.out.println(rid);
		String pnumber=req.getParameter("pnumber");
		UserService us=new UserServiceImp();
		String rname=us.getRnameInfoService(rid);
		System.out.println("��ɫ����Ϊ:"+rname);
		String uname=us.getUnameInfoService(pnumber);
		System.out.println("�ϼ�����:"+uname);
		String str="{rname:'"+rname+"',pname:'"+uname+"'}";
		resp.getWriter().write(str);
	}

	//��ǩ����Ϣ���뵽���ݿ���
	private void insertOutInfo(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String unumber=req.getParameter("unumber");
		String inTime=req.getParameter("inTime");
		String inDate=req.getParameter("inDate");
		String outStatus=req.getParameter("outStatus");
		System.out.println("ǩ����ϢΪ:"+unumber+":"+inTime+":"+inDate+":"+outStatus);
		UserService us=new UserServiceImp();
		int i=us.insertOutInfoService(unumber,inTime,inDate,outStatus);
		if(i>0){
			resp.getWriter().write(outStatus);
		}else{
			resp.getWriter().write("false");
		}
	}

	private void insertInInfo(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//��ȡǩ����Ϣ
		String unumber=req.getParameter("unumber");
		String inTime=req.getParameter("inTime");
		String inDate=req.getParameter("inDate");
		String inStatus=req.getParameter("inStatus");
		System.out.println("ǩ����ϢΪ:"+unumber+":"+inTime+":"+inDate+":"+inStatus);
		//����������Ϣ
		UserService hs=new UserServiceImp();
		//�ж��û��Ƿ��Ѿ�ǩ��
		boolean flag=hs.checkSignInfoService(unumber,inDate);
		if(!flag){
			int i=hs.insertInInfoService(unumber,inTime,inDate,inStatus);
			if(i>0){
				resp.getWriter().write(inStatus);
			}else{
				resp.getWriter().write("false");
			}


		}else{
			resp.getWriter().write("a");
		}

	}

	private void userOut(HttpServletRequest req, HttpServletResponse resp) {
		//����session����
		HttpSession hs=req.getSession();
		hs.invalidate();
		//�ض���
		try {
			resp.sendRedirect("login.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//��¼��Ϣ
	private void userLogin(HttpServletRequest req, HttpServletResponse resp) {
		//��ȡ��������
		String unumber=req.getParameter("unumber");
		String upwd=req.getParameter("pwd");
		//������������--����¼���������ݿ�Աȵõ��û���Ϣ
		UserService us=new UserServiceImp();
		User user=us.checkUserInfo(unumber,upwd);
		System.out.println("UserServlet.service("+user+")");

		if(user!=null){
			//��ȡ�û���ɫȨ�޶�Ӧ�Ĳ˵���Ϣ
			ArrayList<Menu> list=us.getUserMenuInfo(user.getRid());
			System.out.println("�û���ɫȨ����ϢΪ:"+list);
			//��ȡsession���󣬽��û���Ϣ�洢��session������
			HttpSession hs=req.getSession();
			hs.setAttribute("user", user);
			hs.setAttribute("menu", list);
			try {
				req.getRequestDispatcher("main/main.jsp").forward(req, resp);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("UserServlet.service()"+user.getUname());
		}else{
			String str="�û��������������";
			req.setAttribute("str", str);
			try {
				req.getRequestDispatcher("login.jsp").forward(req, resp);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
