package fengzhihong;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.service.ContentService;
import com.bjsxt.serviceImp.ContentServiceImp;

public class ContentServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String parameter = req.getParameter("oper");
		
		ContentService content=new ContentServiceImp();
		List<Map> contentList = content.selectContent();
		
		req.setAttribute("contentList", contentList);
		req.getRequestDispatcher("content.jsp").forward(req, resp);
		
	}
}
