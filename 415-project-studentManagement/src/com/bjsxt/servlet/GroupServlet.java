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
		//设置请求编码格式
			req.setCharacterEncoding("utf-8");
		//设置响应编码格式
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
	//获取某个成员的签到签退信息
	private void getUserSignInfo(HttpServletRequest req,
			HttpServletResponse resp) {
		//获取签到信息
			String unumber=req.getParameter("unumber");
			String uname=req.getParameter("uname");
			//页数
			String page=req.getParameter("page");
			System.out.println(unumber+":"+uname+"的"+"签退页数为:"+page);
			GroupService gs=new GroupServiceImp();
		//统计所有某个成员所有签退签到信息总数
			int pageAllCount=gs.getSignCountService(unumber);
			System.out.println(uname+"签到签退总数为:"+pageAllCount);
		//计算每次需要获取的签到签退页数--规定每页是5条信息
			//整数之间相除结果理应为4.6，最终的结果是4，通过将除数变为double类型得到的结果为4.6,通过ceil函数得到结果为5
				int pageCount=(int)Math.ceil((pageAllCount*1.0/5));
		//得到当前角色对应某个成员的签到签退所有的信息
			ArrayList<Sign> newList=gs.getUserSignInfoService(unumber,page);
			System.out.println("组员签到签退信息为:"+newList);
			if(newList!=null){
				//将信息存储到作用域中
					req.setAttribute("newList", newList);
					req.setAttribute("uname", uname);
					req.setAttribute("pageCount", pageCount);
					req.setAttribute("pageAllCount", pageAllCount);
					req.setAttribute("page", page);
				//请求转发
				try {
					req.getRequestDispatcher("group/showSign.jsp").forward(req, resp);
				} catch (ServletException | IOException e) {
					e.printStackTrace();
				}
			}
		
	}
	//获取组员信息
	private void getGruopInfo(HttpServletRequest req, HttpServletResponse resp){
		//通过session获取--必须首先导入User包
		int unumber=((User)req.getSession().getAttribute("user")).getUnumber();
		System.out.println(unumber);
		//处理请求
			//调用service获取所有的小组成员信息
				GroupService gs=new GroupServiceImp();
				ArrayList<User> list=gs.getGroupInfoService(unumber);
				System.out.println("组员所有信息为:"+list);
			if(list!=null){
				//将list存储到作用域中
					HttpSession hs=req.getSession();
					hs.setAttribute("list", list);
				//重定向
				try {
					req.getRequestDispatcher("group/groupInfo.jsp").forward(req, resp);
				} catch (ServletException | IOException e) {
					e.printStackTrace();
				}
			}
	}
}
