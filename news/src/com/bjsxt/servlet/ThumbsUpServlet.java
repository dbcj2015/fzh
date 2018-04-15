package com.bjsxt.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.tools.ant.property.GetProperty;

import com.bjsxt.dao.NewsDAO;
import com.bjsxt.util.MybatisUtils;
import com.google.gson.Gson;

public class ThumbsUpServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String newsId=req.getParameter("newsId");
		SqlSession openSession = MybatisUtils.getSessionFactory().openSession();
		NewsDAO dao = openSession.getMapper(NewsDAO.class);
		Map thumbsMap = dao.findThumbsNum(new Integer(newsId));
		dao.updateThumbsUp(new Integer(newsId));
		openSession.commit();
		resp.getWriter().write(new Gson().toJson(thumbsMap));
		
	}
}
