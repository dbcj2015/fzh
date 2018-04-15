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

public class ContentServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String newsId=req.getParameter("newsId");
		System.out.println(newsId);
		SqlSession openSession = MybatisUtils.getSessionFactory().openSession();
		NewsDAO dao = openSession.getMapper(NewsDAO.class);
		Map map = dao.obtainNewsId(new Integer(newsId));
		System.out.println(map);
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		req.setAttribute("map", map);
		req.getRequestDispatcher("content.jsp").forward(req, resp);
	}
}

