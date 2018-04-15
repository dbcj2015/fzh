package com.bjsxt.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.dao.SelDao;

public class TestSeclectServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//设置响应编码格式
		resp.setContentType("text/html;charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		//请求数据库获取下拉框数据
		ArrayList<String> list=new SelDao().getCityName();
		System.out.println(list);
		
		//响应地址下拉框数据
		resp.getWriter().write("<html>");
		resp.getWriter().write("<head>");
		resp.getWriter().write("</head>");
		resp.getWriter().write("<body>");
		resp.getWriter().write("<select>");
		resp.getWriter().write("<option value='0'>--请选择--</option>");
		for(int i=0;i<list.size();i++){
			resp.getWriter().write("<option>"+list.get(i)+"</option>");
		}
		resp.getWriter().write("</select>");
		resp.getWriter().write("</body>");
		resp.getWriter().write("</html>");	
		
	}
	

}
