import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class TestJQueryAjaxServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//������������ʽ
			req.setCharacterEncoding("utf-8");
		//������Ӧ�����ʽ
			resp.setCharacterEncoding("utf-8");
			resp.setContentType("text/html;charset=utf-8");
		//��ȡ��������
			String name=req.getParameter("name");
		//������������
			System.out.println(name);
		//������Ӧ����
//			resp.getWriter().write("����JQueryAjax--post����");
			resp.getWriter().write("����JQueryAjax--option����");
	}
}
