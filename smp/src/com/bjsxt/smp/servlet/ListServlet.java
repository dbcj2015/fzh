package com.bjsxt.smp.servlet;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.smp.utils.DBUtils;
import com.google.gson.Gson;

public class ListServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Integer page = new Integer(request.getParameter("page"));
		Integer rows = new Integer(request.getParameter("rows"));
		
		Integer startIndex = (page-1) * rows;
		try{
			//分页查询
			String sql = "select e.* , d.dname from t_employee e, t_department d where e.dept_id = d.dept_id order by e.emp_id asc limit ? , ?";
			List<Map> list = DBUtils.list(sql , new Object[]{startIndex , rows});
			
			//获取记录总数
			Long cnt = (Long)DBUtils.list("select count(*) cnt from t_employee").get(0).get("cnt");
			Map result = new LinkedHashMap();
			result.put("total", cnt);
			result.put("rows", list);
			String json = new Gson().toJson(result);
			response.setContentType("text/json;charset=utf-8");
			response.getWriter().println(json);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
