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
import com.bjsxt.serviceImp.UserServiceImp;

/*
 * 1��MVC�ֲ㿪��
 * 	  ���У�
 * 		Servlet��
 * 		Dao��
 * 		ʵ�����
 * 		
 * 		�ô��������ݵĴ�������ݵĲ������룬�����������࣬��������Ч�ʡ�
 *   ����ֲ㣺
 *   	Servlet��: ���ݵĻ�ȡ
 *   	service�ӿڲ㣺�����Ժ󿪷��������������޸ġ�
 *   	service��: ���ݵĴ���
 *   	Dao��ӿڲ�:�����Ժ����ݵĲ������ִ��������������
 * 		Dao��:	      ���ݵĲ���
 * 		ʵ�����:    ���ݵĴ洢
 * 	servlect��--->service��-->dao��-->���ݿ�
 * 	servlcet��-->service�ӿڲ�-->service��--->Dao�ӿڲ�--->dao��-->���ݿ�
 * */
public class UserServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// ������������ʽ
		req.setCharacterEncoding("utf-8");
		// ������Ӧ�����ʽ
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		//��ȡ������
		String oper=req.getParameter("oper");
		//�ж���������ִ�ж�Ӧ��ҵ���߼�
		if("login".equals(oper)){
			userLogin(req, resp);
		}else if("out".equals(oper)){
			userOut(req,resp);
		}else if("in".equals(oper)){
			userSignIn(req,resp);
		}else if("sout".equals(oper)){
			userSignOut(req,resp);
		}else if("pwd".equals(oper)){
			userCheckOldPwd(req,resp);
		}else if("newPwd".equals(oper)){
			userUpdateNewPwd(req,resp);
		}else if("info".equals(oper)){
			getInfo(req,resp);
		}else{
			System.out.println("UserServlet.service(û���ҵ���Ӧ�Ĳ�����:)"+oper);
		}	
	}
	//��ȡ�û���ɫ���ϼ�����
	private void getInfo(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//��ȡ������Ϣ
			String rid=req.getParameter("rid");
			String pnumber=req.getParameter("pnumber");
		//����������Ϣ
			//����service�㽫ǩ����Ϣ���µ����ݿ���
			UserService us=new UserServiceImp();
			//��ȡrid��Ϣ
			String rname=us.getRnameInfoService(rid);
			System.out.println("�û��Ľ�ɫ��Ϊ:"+rname);
			//��ȡpnumber��Ϣ
			String pname=us.getUnameInfoService(pnumber);
			System.out.println("�û����ϼ�����Ϊ��"+pname);
		//��Ӧ������	
			//ƴ��json����
			String str="{rname:'"+rname+"',pname:'"+pname+"'}";
			resp.getWriter().write(str);
	}
	//�û���������
	private void userUpdateNewPwd(HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
		//��ȡ������Ϣ
			String newPwd=req.getParameter("newPwd");
			int unumber=((User)req.getSession().getAttribute("u")).getUnumber();
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
	//У���û�ԭʼ����
	private void userCheckOldPwd(HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
		//��ȡ��������
			String oldPwd=req.getParameter("oldPwd");
		//������������
			 //��ȡsession�е�������Ϣ
			String pwd=((User)req.getSession().getAttribute("u")).getUpwd();
			//�ж�
			if(pwd.equals(oldPwd)){
				//��Ӧ������
				resp.getWriter().write("true");
			}else{
				resp.getWriter().write("false");
			}
		
		
	}
	//�û�ǩ�˹���
	private void userSignOut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//��ȡ������Ϣ
			String unumber=req.getParameter("unumber");
			String outTime=req.getParameter("outTime");
			String outdate=req.getParameter("outdate");
			String outStatus=req.getParameter("outStatus");
			System.out.println("�û�ǩ����ϢΪ��"+unumber+":"+outTime+":"+outdate+":"+outStatus);
		//����������Ϣ
			//����service�㽫ǩ����Ϣ���µ����ݿ���
			UserService us=new UserServiceImp();
			//��ѯ�Ƿ��Ѿ�ǩ�������û��ǩ������ǩ������ǩ�ˣ�
			boolean flag=us.checkSignInInfoService(unumber,outdate);
			if(flag){
				//��ǩ�����ݸ���
					int i=us.updateSignOutInfoService(unumber,outTime,outdate,outStatus);
					System.out.println("ǩ�˽��Ϊ:"+i);
				//��Ӧ������
					if(i>0){
						resp.getWriter().write(outStatus);
					}else{
						resp.getWriter().write("false");
					}
			}else{
				resp.getWriter().write("a");
			}
	}
	//�û�ǩ������
	private void userSignIn(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//��ȡ������Ϣ
			String unumber=req.getParameter("unumber");
			String inTime=req.getParameter("inTime");
			String indate=req.getParameter("indate");
			String inStatus=req.getParameter("inStatus");
			System.out.println("�û�ǩ������Ϊ��"+unumber+":"+inTime+":"+indate+":"+inStatus);
		//����������Ϣ
			//����service�㽫ǩ����Ϣ���뵽���ݿ���
			UserService us=new UserServiceImp();
			//��ѯ�û��Ƿ��Ѿ�ǩ��
				boolean flag=us.checkSignInInfoService(unumber,indate);
			//��ʼǩ��
				if(!flag){
					int i=us.insertSignInInfoService(unumber,inTime,indate,inStatus);
					System.out.println(i);
					//��Ӧ������
					if(i>0){	
						resp.getWriter().write(inStatus);
					}else{
						resp.getWriter().write("false");
					}
				}else{
					resp.getWriter().write("a");
				}		
	}
	//�������������û��˳�У�顣
	private void userOut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//��ȡsession����
		HttpSession hs=req.getSession();
		//����session
		hs.invalidate();
		System.out.println("session�ɹ�����");
		//�����ض���
		resp.sendRedirect("login.jsp");
		return;
		
	}

	// �����������е�¼У��
	private void userLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ��ȡ������Ϣ
		String unumber = req.getParameter("unumber");
		String pwd = req.getParameter("pwd");
		System.out.println("UserServlet.service(" + unumber + ":" + pwd + ")");
		// ����������Ϣ
		// ����ҵ���߼�����
		UserService us = new UserServiceImp();
		// ���е�¼У��
		User u = us.checkLoginInfoService(unumber, pwd);
		System.out.println("�û���¼��ѯ���Ϊ:" + u);
		// ��Ӧ������
		if (u != null) {
			//��ѯ���û��Ľ�ɫȨ�޶�Ӧ�Ĳ˵���Ϣ��
			ArrayList<Menu> list=us.getMenuInfoService(u.getRid());
			System.out.println("�û��˵���ϢΪ:"+list);
			// ����session�����û���Ϣ�洢��session��
			HttpSession hs = req.getSession();
			hs.setAttribute("u", u);
			//���û��˵���Ϣ�洢��session��
			hs.setAttribute("menu", list);
			// ����ת��
			req.getRequestDispatcher("main/main.jsp").forward(req, resp);
			return;
		} else {
			// ��У�����洢��request��������
			req.setAttribute("str", "�û��������������");
			// ����ת��
			req.getRequestDispatcher("login.jsp").forward(req, resp);
			return;
		}

	}

}
