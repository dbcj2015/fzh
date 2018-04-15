package com.bjsxt.emp;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class DeptServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String sql="select * from t_department";
		List<Map> list=null;
		try {
			list = DBUtils.list(sql);
			Map defaultOption = new LinkedHashMap();
			defaultOption.put("dept_id", "-1");
			defaultOption.put("dname", "«Î—°‘Ò");
			list.add(0,defaultOption);
			resp.setContentType("text/gson;charset=utf-8");
			resp.getWriter().write(new Gson().toJson(list));
			System.out.println(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
