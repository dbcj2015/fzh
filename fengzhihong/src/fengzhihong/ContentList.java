package fengzhihong;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.entity.Reply;
import com.bjsxt.service.ContentService;
import com.bjsxt.serviceImp.ContentServiceImp;
import com.google.gson.Gson;

public class ContentList extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String name=req.getParameter("uname");
		String area=req.getParameter("textArea");
		System.out.println(area);
		Reply r=new Reply();
		ContentService cs=new ContentServiceImp();
		r.setTopicId(1);
		r.setAuthor(name);
		r.setContnt(area);
		r.setCreateDate(new Date());
		cs.Insert(r);
		Reply re=new Reply();
		re=cs.selectReply(name);
		req.setAttribute("reply",re);
		System.out.println(new Gson().toJson(re));
		resp.getWriter().write(new Gson().toJson(re));
	}
}

