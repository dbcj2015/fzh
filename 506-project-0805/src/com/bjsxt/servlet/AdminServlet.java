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
		//设置请求编码格式
		req.setCharacterEncoding("utf-8");
		//设置响应编码格式
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		//获取操作符
		String oper=req.getParameter("oper");
		//判断
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
	//插入用户信息
	private void insertUserInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取请求信息
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
		//处理请求信息
			//将用户数据插入到数据库中
			AdminService as=new AdminServiceImp();
			int i=as.insertUserInfoService(udata);
		//响应处理结果
			if(i>0){
				//添加成功标记到request作用域中
				req.setAttribute("flag","true");
				req.getRequestDispatcher("admin/addUser.jsp").forward(req, resp);
			}
		
	}
	//删除用户信息
	private void deleteUserInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取请求信息
			String unumber=req.getParameter("unumber");
		//处理请求信息
			AdminService as=new AdminServiceImp();
			int i=as.deleteUserInfoService(unumber);
		//响应处理结果
			if(i>0){
				getAllUserInfo(req, resp);
			}
		
	}
	//更新用户信息
	private void updateUserInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取请求数据
		String unumber=req.getParameter("unumber");
		String rid=req.getParameter("rid");
		String pnumber=req.getParameter("pnumber");
		//调用service更新用户信息
		AdminService as=new AdminServiceImp();
		int i=as.updateUserInfoService(unumber,rid,pnumber);
		System.out.println("数据更新结果为:"+i);
		if(i>0){
			//使用作用域添加修改成功标记
			req.setAttribute("flag","true");
			getAllUserInfo(req, resp);
		}
		
	}
	//获取上级信息
	private void getleaderInfo(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//获取角色id
		String rid=req.getParameter("pid");
		System.out.println("上级id为:"+rid);
		//调用班长service层的获取角色信息方法
		ClazzService cs=new ClazzServiceImp();
		ArrayList<User> list=cs.getClazzInfoService(rid);
		//将list转换为json
		String data=new Gson().toJson(list);
		resp.getWriter().write(data);
	}
	//获取所有的角色信息
	private void getRoleInfo(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//创建service层获取所有的角色信息
		AdminService as=new AdminServiceImp();
		ArrayList<Role> list=as.getRoleInfoService();
		System.out.println("所有的角色信息为："+list);
		//响应处理结果
			//将list转换为json
			String data=new Gson().toJson(list);
			resp.getWriter().write(data);
	}
	//获取所有的学生信息
	private void getAllUserInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//调用班长service层
		ClazzService cs=new ClazzServiceImp();
		ArrayList<User> list=cs.getClazzInfoService(null);
		//判断
		if(list!=null){
			//将数据存储到req作用域中
			req.setAttribute("list",list);
			//请求转发
			req.getRequestDispatcher("admin/adminList.jsp").forward(req, resp);
		}
		
	}
}
