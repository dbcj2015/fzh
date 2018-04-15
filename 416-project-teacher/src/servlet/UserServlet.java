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
 * 1、MVC分层开发
 * 	  现有：
 * 		Servlet层
 * 		Dao层
 * 		实体类层
 * 		
 * 		好处：将数据的处理和数据的操作分离，避免代码的冗余，提升编码效率。
 *   深入分层：
 *   	Servlet层: 数据的获取
 *   	service接口层：方便以后开发大量需求变更的修改。
 *   	service层: 数据的处理
 *   	Dao层接口层:方便以后数据的操作部分代码的整体升级。
 * 		Dao层:	      数据的操作
 * 		实体类层:    数据的存储
 * 	servlect层--->service层-->dao层-->数据库
 * 	servlcet层-->service接口层-->service层--->Dao接口层--->dao层-->数据库
 * */
public class UserServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 设置请求编码格式
		req.setCharacterEncoding("utf-8");
		// 设置响应编码格式
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		//获取操作符
		String oper=req.getParameter("oper");
		//判断请求类型执行对应的业务逻辑
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
			System.out.println("UserServlet.service(没有找到对应的操作符:)"+oper);
		}	
	}
	//获取用户角色和上级姓名
	private void getInfo(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//获取请求信息
			String rid=req.getParameter("rid");
			String pnumber=req.getParameter("pnumber");
		//处理请求信息
			//调用service层将签退信息更新到数据库中
			UserService us=new UserServiceImp();
			//获取rid信息
			String rname=us.getRnameInfoService(rid);
			System.out.println("用户的角色名为:"+rname);
			//获取pnumber信息
			String pname=us.getUnameInfoService(pnumber);
			System.out.println("用户的上级姓名为："+pname);
		//响应处理结果	
			//拼接json数据
			String str="{rname:'"+rname+"',pname:'"+pname+"'}";
			resp.getWriter().write(str);
	}
	//用户更新密码
	private void userUpdateNewPwd(HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
		//获取请求信息
			String newPwd=req.getParameter("newPwd");
			int unumber=((User)req.getSession().getAttribute("u")).getUnumber();
			System.out.println("用户更改密码信息为:"+newPwd+":"+unumber);
		//处理请求信息
			//调用service层将签退信息更新到数据库中
			UserService us=new UserServiceImp();
			//将密码更新到数据库中
			int i=us.updateNewPwdInfoService(newPwd,unumber);
			System.out.println("用户密码更新:"+i);
		//响应处理结果
			if(i>0){
				//重定向
				resp.sendRedirect("login.jsp");
			}
		
	}
	//校验用户原始密码
	private void userCheckOldPwd(HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
		//获取请求数据
			String oldPwd=req.getParameter("oldPwd");
		//处理请求数据
			 //获取session中的密码信息
			String pwd=((User)req.getSession().getAttribute("u")).getUpwd();
			//判断
			if(pwd.equals(oldPwd)){
				//响应处理结果
				resp.getWriter().write("true");
			}else{
				resp.getWriter().write("false");
			}
		
		
	}
	//用户签退功能
	private void userSignOut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//获取请求信息
			String unumber=req.getParameter("unumber");
			String outTime=req.getParameter("outTime");
			String outdate=req.getParameter("outdate");
			String outStatus=req.getParameter("outStatus");
			System.out.println("用户签退信息为："+unumber+":"+outTime+":"+outdate+":"+outStatus);
		//处理请求信息
			//调用service层将签退信息更新到数据库中
			UserService us=new UserServiceImp();
			//查询是否已经签到（如果没有签到则先签到才能签退）
			boolean flag=us.checkSignInInfoService(unumber,outdate);
			if(flag){
				//将签退数据更新
					int i=us.updateSignOutInfoService(unumber,outTime,outdate,outStatus);
					System.out.println("签退结果为:"+i);
				//响应处理结果
					if(i>0){
						resp.getWriter().write(outStatus);
					}else{
						resp.getWriter().write("false");
					}
			}else{
				resp.getWriter().write("a");
			}
	}
	//用户签到功能
	private void userSignIn(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//获取请求信息
			String unumber=req.getParameter("unumber");
			String inTime=req.getParameter("inTime");
			String indate=req.getParameter("indate");
			String inStatus=req.getParameter("inStatus");
			System.out.println("用户签到数据为："+unumber+":"+inTime+":"+indate+":"+inStatus);
		//处理请求信息
			//调用service层将签到信息插入到数据库中
			UserService us=new UserServiceImp();
			//查询用户是否已经签到
				boolean flag=us.checkSignInInfoService(unumber,indate);
			//开始签到
				if(!flag){
					int i=us.insertSignInInfoService(unumber,inTime,indate,inStatus);
					System.out.println(i);
					//响应处理结果
					if(i>0){	
						resp.getWriter().write(inStatus);
					}else{
						resp.getWriter().write("false");
					}
				}else{
					resp.getWriter().write("a");
				}		
	}
	//创建方法进行用户退出校验。
	private void userOut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//获取session对象
		HttpSession hs=req.getSession();
		//销毁session
		hs.invalidate();
		System.out.println("session成功销毁");
		//请求重定向
		resp.sendRedirect("login.jsp");
		return;
		
	}

	// 创建方法进行登录校验
	private void userLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获取请求信息
		String unumber = req.getParameter("unumber");
		String pwd = req.getParameter("pwd");
		System.out.println("UserServlet.service(" + unumber + ":" + pwd + ")");
		// 处理请求信息
		// 创建业务逻辑对象
		UserService us = new UserServiceImp();
		// 进行登录校验
		User u = us.checkLoginInfoService(unumber, pwd);
		System.out.println("用户登录查询结果为:" + u);
		// 响应处理结果
		if (u != null) {
			//查询该用户的角色权限对应的菜单信息。
			ArrayList<Menu> list=us.getMenuInfoService(u.getRid());
			System.out.println("用户菜单信息为:"+list);
			// 创建session并将用户信息存储到session中
			HttpSession hs = req.getSession();
			hs.setAttribute("u", u);
			//将用户菜单信息存储到session中
			hs.setAttribute("menu", list);
			// 请求转发
			req.getRequestDispatcher("main/main.jsp").forward(req, resp);
			return;
		} else {
			// 将校验结果存储到request作用域中
			req.setAttribute("str", "用户名或者密码错误");
			// 请求转发
			req.getRequestDispatcher("login.jsp").forward(req, resp);
			return;
		}

	}

}
