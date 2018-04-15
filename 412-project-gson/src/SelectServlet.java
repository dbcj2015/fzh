import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;


public class SelectServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//设置请求编码格式
			req.setCharacterEncoding("utf-8");
		//设置响应编码格式
			resp.setCharacterEncoding("utf-8");
			resp.setContentType("text/html;charset=utf-8");
			ArrayList list=null;
		try {
			list=new ClazzDao().getClazzInfo();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//list里面存储的是clazz对象，每个clazz对象是每个班级信息
		//将list中的数据转换给字符串数据响应给客户端
		String str=new Gson().toJson(list);
		System.out.println(str);
		resp.getWriter().write(str);
	}
}
