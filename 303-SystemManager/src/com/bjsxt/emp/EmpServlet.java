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
/*
 * datagrid 的json数据有严格的格式，必须有total 和rows 例如:
 * { "total":条数, 
 * "rows":[ {"id01":"282.32","id02":"122221","id03":"0329281","id04":"29292918"},
 * {"id01":"282.32","id02":"122221","id03":"0329281","id04":"29292918"},
 * {"id01":"282.32","id02":"122221","id03":"0329281","id04":"29292918"}
 * ]
 * }
 * */
public class EmpServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		Integer page = new Integer(req.getParameter("page"));
		System.out.println("page="+page);
		Integer row = new Integer(req.getParameter("rows"));
		System.out.println("row="+row);
		Integer pageStart=(page-1)*row;
		String sql="select e.*,d.dname from t_employee e,t_department d where e.dept_id=d.dept_id limit ?,?";
		List<Map> list=null;
		try {
			list = DBUtils.list(sql,new Object[]{pageStart,row});
			//查询总记录数
			long cnt = (long)DBUtils.list("select count(*) c from t_employee").get(0).get("c");
			Map result=new LinkedHashMap<>();
			result.put("total",cnt);
			result.put("rows", list);
			
			String string = new Gson().toJson(result);
			resp.setContentType("text/json;charset=utf-8");
			resp.getWriter().print(string);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
