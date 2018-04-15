import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.loginDao.LoginDao;
import com.bjsxt.loginDao.User;


public class CheckPageServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		//��ȡ�������е��û���Ϣ
		String uname = req.getParameter("uname");
		String pwd=req.getParameter("pwd");
		if(uname.equals("����")&& pwd.equals("123")){
			req.getRequestDispatcher("main.jsp").forward(req, resp);
		}else{
			req.setAttribute("str", "�û��������������");
			req.getRequestDispatcher("loginPage.jsp").forward(req, resp);
		}
		
	}
}
