import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class TestJQueryAjaxServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//设置请求编码格式
			req.setCharacterEncoding("utf-8");
		//设置响应编码格式
			resp.setCharacterEncoding("utf-8");
			resp.setContentType("text/html;charset=utf-8");
		//获取请求数据
			String name=req.getParameter("name");
		//处理请求数据
			System.out.println(name);
		//处理响应数据
//			resp.getWriter().write("我是JQueryAjax--post方法");
			resp.getWriter().write("我是JQueryAjax--option方法");
	}
}
