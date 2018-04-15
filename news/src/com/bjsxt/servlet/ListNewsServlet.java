package com.bjsxt.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.bjsxt.dao.NewsDAO;
import com.bjsxt.util.MybatisUtils;
import com.google.gson.Gson;

public class ListNewsServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String channelId=req.getParameter("channelId");
		Integer page=Integer.parseInt(req.getParameter("page"));
		int rows=Integer.parseInt(req.getParameter("rows"));
		page=(page-1)*rows;
		System.out.println("page="+page);
		SqlSession openSession = MybatisUtils.getSessionFactory().openSession();
		NewsDAO dao = openSession.getMapper(NewsDAO.class);
		List<Map> channelNews = dao.obtainNewsListByChannel(page,rows,new Integer(channelId));
		
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String json = new Gson().toJson(channelNews);
		resp.getWriter().write(json);
	}
}
