import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UserServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		User user=(User) req.getAttribute("user");
		
		resp.getWriter().write("<html>");
		resp.getWriter().write("<table border=1>");
		resp.getWriter().write("<tr>");
		resp.getWriter().write("<th>"+"id"+"</th>");
		resp.getWriter().write("<th>"+"–’√˚"+"</th>");
		resp.getWriter().write("<th>"+"∞Æ∫√"+"</th>");
		resp.getWriter().write("<th>"+"µÿ÷∑"+"</th>");
		resp.getWriter().write("</tr>");
		resp.getWriter().write("<tr>");
		resp.getWriter().write("<td>"+user.getId()+"</td>");
		resp.getWriter().write("<th>"+user.getName()+"</th>");
		resp.getWriter().write("<th>"+user.getFav()+"</th>");
		resp.getWriter().write("<th>"+user.getAddr()+"</th>");
		resp.getWriter().write("</tr>");
		resp.getWriter().write("</table>");
		resp.getWriter().write("</html>");
	}
}
