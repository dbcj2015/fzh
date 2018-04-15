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
		//设置请求编码格式
			req.setCharacterEncoding("utf-8");
		//设置响应编码格式
			resp.setCharacterEncoding("utf-8");
			resp.setContentType("text/html;charset=utf-8");
		//获取操作符
			String oper=req.getParameter("oper");
		//判断
			if("groupInfo".equals(oper)){
				getGroupInfo(req,resp);
			}else if("showSign".equals(oper)){
				showSignInfo(req,resp);	
			}
	}
	//查询小组指定组员的签到签退信息
	private void showSignInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取请求数据
			String unumber =req.getParameter("unumber");
			String uname=req.getParameter("uname");
			//获取请求页码数
			String page=req.getParameter("page");
			System.out.println(unumber+":"+uname+":"+page);
		//处理请求数据
			//调用service获取所有的小组成员信息
			GroupService gs=new GroupServiceImp();	
			ArrayList<Sign> list=gs.getSignInfoService(unumber,page);
			System.out.println(list);
			//查询小组成员的签到签退信息记录条数
			int count=gs.getCountInfoService(unumber);
			System.out.println("用户签到总条数为:"+count);
			//创建分页数
			int pageCount=(int)Math.ceil(count*1.0/5);
		//响应处理结果
			if(list!=null){
				//将当前页码存储到作用域中
				req.setAttribute("page",page);
				//将数据数和页码数存储到作用域中
				req.setAttribute("count",count);
				req.setAttribute("pageCount",pageCount);
				//将数据存储到作用域中
				req.setAttribute("list",list);
				//将要查询的用户名存到作用域中
				req.setAttribute("uname",uname);
				//请求转发
				req.getRequestDispatcher("group/showSign.jsp").forward(req, resp);
			}
		
	}
	//获取小组信息
	private void getGroupInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取session中的unumber
		int unumber=((User)req.getSession().getAttribute("u")).getUnumber();
		//处理请求
			//调用service获取所有的小组成员信息
			GroupService gs=new GroupServiceImp();
			ArrayList<User> list=gs.getGroupInfoService(unumber);
			System.out.println(list);
		//响应处理结果
			if(list!=null){
				//将小组信息存储到request作用域中
				req.setAttribute("list",list);
				//请求转发给GroupList.jsp
				req.getRequestDispatcher("group/groupList.jsp").forward(req, resp);
				
			}
		
	}
}
