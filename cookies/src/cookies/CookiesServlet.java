package cookies;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookiesServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		System.out.println(req.getParameter("pwd"));
		System.out.println(req.getParameter("uname"));
		
		Cookie[] c2=req.getCookies();
		if(c2!=null){
			for(Cookie cookie:c2){
				System.out.println(cookie.getName());
				System.out.println(cookie.getValue());
			}
		}
		
		resp.setContentType("text/html;charset=utf-8");
		Cookie c=new Cookie("uname", "zhangsan");
		Cookie c1=new Cookie("pwd", "123");
		c.setMaxAge(24*60*60);
		c1.setPath("/cookies/acs/");
		resp.addCookie(c1);
		resp.addCookie(c);
		resp.getWriter().write("登录成功");
	}
}
