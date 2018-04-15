package fengzhihong;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.entity.Reply;
import com.bjsxt.entity.Topic;
import com.bjsxt.service.ContentService;
import com.bjsxt.serviceImp.ContentServiceImp;

public class ReplyServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Integer topicId=Integer.parseInt(req.getParameter("topicId"));
		ContentService cs=new ContentServiceImp();
		cs.updateClick(topicId);
		List<Map> list= cs.selectReply(topicId);
		Topic t=new Topic();
		for(Map map:list){
			t.setTopicId((Integer)map.get("topic_id"));
			t.setAuthor((String)map.get("author"));
			t.setContent((String)map.get("content"));
			t.setTitle((String)map.get("title"));
			t.setCreateDate((String)map.get("create_date"));
			t.setClickAmount((Integer)map.get("click_amount"));
		}
		req.setAttribute("topic", t);
		req.getRequestDispatcher("contentList.jsp").forward(req, resp);
	}
}
