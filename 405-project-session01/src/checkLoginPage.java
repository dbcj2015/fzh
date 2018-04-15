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
		//��ȡ�û���Ϣ
			String uname = req.getParameter("uname");
			String pwd = req.getParameter("pwd");
		//��ѯ���ݿ�
			int id=0;
			try {
				id = new loginDao().checkUserInfo(uname);
				System.out.println(id+"******");
			} catch (Exception e) {
				e.printStackTrace();
			}
		//�ж��û���Ϣ�Ƿ���ڣ�����cookie��Ϣ
			if(id!=0){
				//���ڲ�ͬ���û�cookie��ֵ������ͬ�ģ�����cookie��Ϣ�Ǵ��ڸ��ǵģ������ֻ�ᱣ��һ��cookie��Ϣ
				Cookie c=new Cookie("uid",id+"");
				c.setMaxAge(3600*23*4);
				resp.addCookie(c);
				req.setAttribute("uname", uname);
				req.getRequestDispatcher("main").forward(req, resp);
			}else{
				req.setAttribute("str", "�û������ߴ���");
				req.getRequestDispatcher("page").forward(req, resp);
			}
			
			
	}
}

