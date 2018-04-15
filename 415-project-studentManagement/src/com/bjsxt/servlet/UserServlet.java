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
		//设置请求编码格式
		req.setCharacterEncoding("utf-8");
		//设置响应编码格式
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
			//获取请求信息
				String newPwd=req.getParameter("newPwd");
				int unumber=((User)req.getSession().getAttribute("user")).getUnumber();
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
	//验证用户密码信息
	private void checkUserOldPwd(HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
		//获取请求信息
			String oldPwd=req.getParameter("oldPwd");
			System.out.println("旧密码为:"+oldPwd);
		//获取session对象
			String pwd=((User)req.getSession().getAttribute("user")).getUpwd();
			System.out.println("数据库中的密码为:"+pwd);
			//当原始密码为空或者写错密码都会报错
			if(pwd.equals(oldPwd)){
				resp.getWriter().write("true");
			}else{
				resp.getWriter().write("false");
			}
	}
	//获取用户上级姓名以及角色信息
	private void getUserInfo(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		String rid=req.getParameter("rid");
		System.out.println(rid);
		String pnumber=req.getParameter("pnumber");
		UserService us=new UserServiceImp();
		String rname=us.getRnameInfoService(rid);
		System.out.println("角色姓名为:"+rname);
		String uname=us.getUnameInfoService(pnumber);
		System.out.println("上级姓名:"+uname);
		String str="{rname:'"+rname+"',pname:'"+uname+"'}";
		resp.getWriter().write(str);
	}

	//将签退信息插入到数据库中
	private void insertOutInfo(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String unumber=req.getParameter("unumber");
		String inTime=req.getParameter("inTime");
		String inDate=req.getParameter("inDate");
		String outStatus=req.getParameter("outStatus");
		System.out.println("签退信息为:"+unumber+":"+inTime+":"+inDate+":"+outStatus);
		UserService us=new UserServiceImp();
		int i=us.insertOutInfoService(unumber,inTime,inDate,outStatus);
		if(i>0){
			resp.getWriter().write(outStatus);
		}else{
			resp.getWriter().write("false");
		}
	}

	private void insertInInfo(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//获取签到信息
		String unumber=req.getParameter("unumber");
		String inTime=req.getParameter("inTime");
		String inDate=req.getParameter("inDate");
		String inStatus=req.getParameter("inStatus");
		System.out.println("签到信息为:"+unumber+":"+inTime+":"+inDate+":"+inStatus);
		//处理请求信息
		UserService hs=new UserServiceImp();
		//判断用户是否已经签到
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
		//销毁session对象
		HttpSession hs=req.getSession();
		hs.invalidate();
		//重定向
		try {
			resp.sendRedirect("login.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//登录信息
	private void userLogin(HttpServletRequest req, HttpServletResponse resp) {
		//获取请求数据
		String unumber=req.getParameter("unumber");
		String upwd=req.getParameter("pwd");
		//处理请求数据--将登录数据与数据库对比得到用户信息
		UserService us=new UserServiceImp();
		User user=us.checkUserInfo(unumber,upwd);
		System.out.println("UserServlet.service("+user+")");

		if(user!=null){
			//获取用户角色权限对应的菜单信息
			ArrayList<Menu> list=us.getUserMenuInfo(user.getRid());
			System.out.println("用户角色权限信息为:"+list);
			//获取session对象，将用户信息存储到session对象中
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
			String str="用户名或者密码错误";
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
