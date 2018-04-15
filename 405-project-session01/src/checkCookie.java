import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class checkCookie extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");

		Cookie[] cs = req.getCookies();
		if(cs!=null){
			for (int i = 0; i < cs.length; i++) {
				if("uid".equals(cs[i].getName())){
					String uid=cs[i].getValue();
					System.out.println(uid);
					//通过uid校获取用户信息
					String uname=null;
					try {
						uname=new loginDao().getUserInfo(uid);
						System.out.println(uname);
					} catch (Exception e) {
						e.printStackTrace();
					}
					if(uname!=null){
						req.setAttribute("uname", uname);
						req.getRequestDispatcher("main").forward(req, resp);
					}else{
						req.getRequestDispatcher("page").forward(req, resp);
					}
				}
			}
		}else{
			req.getRequestDispatcher("page").forward(req, resp);
		}
	}
}
