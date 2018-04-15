package com.bjsxt.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.bjsxt.dao.ChannelDAO;
import com.bjsxt.dao.NewsDAO;
import com.bjsxt.util.MybatisUtils;
import com.google.gson.Gson;

public class IndexServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		SqlSessionFactory sessionFactory = MybatisUtils.getSessionFactory();
		SqlSession openSession = sessionFactory.openSession();
		ChannelDAO dao = openSession.getMapper(ChannelDAO.class);
		NewsDAO daoBanner = openSession.getMapper(NewsDAO.class);
		List<Map> channels = dao.findAllChannel();
		List<Map> banners = daoBanner.isShowBanner();
		List<Map> lastedNews = daoBanner.obtainLatestNews();
		req.setAttribute("banners", banners);
		req.setAttribute("channels", channels);
		req.setAttribute("lastedNews", lastedNews);
		req.getRequestDispatcher("first.jsp").forward(req, resp);
	}
}
