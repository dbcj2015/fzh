package com.bjsxt.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bjsxt.entry.Role;
import com.bjsxt.entry.User;
import com.bjsxt.service.AdminService;
import com.bjsxt.service.ClazzService;
import com.bjsxt.serviceImp.AdminServiceImp;
import com.bjsxt.serviceImp.ClazzServiceImp;
import com.google.gson.Gson;

public class AdminServlet extends HttpServlet {
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
		if("adminInfo".equals(oper)){
			getAllUserInfo(req,resp);
		}else if("roleInfo".equals(oper)){
			getRoleInfo(req,resp);
			
		}else if("leaderInfo".equals(oper)){
			getleaderInfo(req,resp);
			
		}else if("updateUser".equals(oper)){
			updateUserInfo(req,resp);
			
		}else if("delete".equals(oper)){
			deleteUserInfo(req,resp);
			
		}else if("insertUser".equals(oper)){
			insertUserInfo(req,resp);	
		}
	}
	//�����û���Ϣ
	private void insertUserInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//��ȡ������Ϣ
		String unumber=req.getParameter("unumber");
		String uname=req.getParameter("uname");
		String upwd=req.getParameter("upwd");
		String usex=req.getParameter("usex");
		String uage=req.getParameter("uage");
		String uaddress=req.getParameter("uaddress");
		String rid=req.getParameter("rid");
		String pnumber=req.getParameter("pnumber");
		String[] udata={unumber,uname,upwd,usex,uage,uaddress,rid,pnumber};
		System.out.println(udata);
		//����������Ϣ
			//���û����ݲ��뵽���ݿ���
			AdminService as=new AdminServiceImp();
			int i=as.insertUserInfoService(udata);
		//��Ӧ������
			if(i>0){
				//��ӳɹ���ǵ�request��������
				req.setAttribute("flag","true");
				req.getRequestDispatcher("admin/addUser.jsp").forward(req, resp);
			}
		
	}
	//ɾ���û���Ϣ
	private void deleteUserInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//��ȡ������Ϣ
			String unumber=req.getParameter("unumber");
		//����������Ϣ
			AdminService as=new AdminServiceImp();
			int i=as.deleteUserInfoService(unumber);
		//��Ӧ������
			if(i>0){
				getAllUserInfo(req, resp);
			}
		
	}
	//�����û���Ϣ
	private void updateUserInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//��ȡ��������
		String unumber=req.getParameter("unumber");
		String rid=req.getParameter("rid");
		String pnumber=req.getParameter("pnumber");
		//����service�����û���Ϣ
		AdminService as=new AdminServiceImp();
		int i=as.updateUserInfoService(unumber,rid,pnumber);
		System.out.println("���ݸ��½��Ϊ:"+i);
		if(i>0){
			//ʹ������������޸ĳɹ����
			req.setAttribute("flag","true");
			getAllUserInfo(req, resp);
		}
		
	}
	//��ȡ�ϼ���Ϣ
	private void getleaderInfo(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//��ȡ��ɫid
		String rid=req.getParameter("pid");
		System.out.println("�ϼ�idΪ:"+rid);
		//���ð೤service��Ļ�ȡ��ɫ��Ϣ����
		ClazzService cs=new ClazzServiceImp();
		ArrayList<User> list=cs.getClazzInfoService(rid);
		//��listת��Ϊjson
		String data=new Gson().toJson(list);
		resp.getWriter().write(data);
	}
	//��ȡ���еĽ�ɫ��Ϣ
	private void getRoleInfo(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//����service���ȡ���еĽ�ɫ��Ϣ
		AdminService as=new AdminServiceImp();
		ArrayList<Role> list=as.getRoleInfoService();
		System.out.println("���еĽ�ɫ��ϢΪ��"+list);
		//��Ӧ������
			//��listת��Ϊjson
			String data=new Gson().toJson(list);
			resp.getWriter().write(data);
	}
	//��ȡ���е�ѧ����Ϣ
	private void getAllUserInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//���ð೤service��
		ClazzService cs=new ClazzServiceImp();
		ArrayList<User> list=cs.getClazzInfoService(null);
		//�ж�
		if(list!=null){
			//�����ݴ洢��req��������
			req.setAttribute("list",list);
			//����ת��
			req.getRequestDispatcher("admin/adminList.jsp").forward(req, resp);
		}
		
	}
}
