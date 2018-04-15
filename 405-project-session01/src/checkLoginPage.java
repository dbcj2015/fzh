import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class checkLoginPage extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		//获取用户信息
			String uname = req.getParameter("uname");
			String pwd = req.getParameter("pwd");
		//查询数据库
			int id=0;
			try {
				id = new loginDao().checkUserInfo(uname);
				System.out.println(id+"******");
			} catch (Exception e) {
				e.printStackTrace();
			}
		//判断用户信息是否存在，创建cookie信息
			if(id!=0){
				//对于不同的用户cookie键值名是相同的，所以cookie信息是存在覆盖的，浏览器只会保存一个cookie信息
				Cookie c=new Cookie("uid",id+"");
				c.setMaxAge(3600*23*4);
				resp.addCookie(c);
				req.setAttribute("uname", uname);
				req.getRequestDispatcher("main").forward(req, resp);
			}else{
				req.setAttribute("str", "用户名或者错误");
				req.getRequestDispatcher("page").forward(req, resp);
			}
			
			
	}
}

