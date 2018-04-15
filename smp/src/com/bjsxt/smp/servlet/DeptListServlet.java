package com.bjsxt.smp.servlet;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.smp.utils.DBException;
import com.bjsxt.smp.utils.DBUtils;
import com.google.gson.Gson;

public class DeptListServlet extends HttpServlet {

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
		
		List<Map> list = null;
		try {
			list = DBUtils.list("select * from t_department");
			Map defaultOption = new LinkedHashMap();
			defaultOption.put("dept_id", "-1");
			defaultOption.put("dname", "请选择");
			list.add(0,defaultOption);
			response.setContentType("text/json;charset=utf-8");
			response.getWriter().println(new Gson().toJson(list));
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
