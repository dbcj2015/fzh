import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 登录页面:成功登陆后查看个人信息
 */
public class showServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		User user=null;
		String name=req.getParameter("uname");
		try {
			user=new loginDao().getUser(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(user!=null){
			req.setAttribute("user", user);
			req.getRequestDispatcher("user").forward(req, resp);
		}
	}
}
