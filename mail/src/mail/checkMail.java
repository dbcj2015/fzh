package mail;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class checkMail extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		String username=req.getParameter("userName");
		Map map=new HashMap<>();
		map.put("msg", "ע��ɹ�");
		String msg="��ע��ɹ�";
		System.out.println(username);
//		resp.getWriter().write("<b>����������ʺ�ѧϰ</b>");
		resp.getWriter().write(new Gson().toJson(map));
	}
}
