package com.bjsxt.smp.servlet;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.smp.utils.DBUtils;
import com.google.gson.Gson;

public class EmpServlet extends HttpServlet {

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
		request.setCharacterEncoding("UTF-8");
		String method = request.getParameter("method");
		if(method.equals("create")){
			this.create(request, response);
		}else if(method.equals("update")){
			this.update(request, response);
		}else if(method.equals("delete")){
			this.delete(request, response);
		}
	}
	
	public void create(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String deptId = request.getParameter("dept_id");
		String mobile = request.getParameter("mobile");
		String job = request.getParameter("job");
		String email = request.getParameter("email");
		String sql = "INSERT INTO t_employee(name , dept_id , mobile , job ,email) values(?,?,?,?,?)";
		Map result = new LinkedHashMap();
		try {
			DBUtils.executeUpdate(sql, new Object[]{name , new Integer(deptId) , mobile , new Integer(job) , email});
			result.put("result", true);
			result.put("message", name + "的员工资料已保存成功");
		} catch (Exception e){
			e.printStackTrace();
			result.put("result", false);
			result.put("message", e.getMessage());
		}
		response.setContentType("text/json;charset=utf-8");
		response.getWriter().println(new Gson().toJson(result));
	}
	
	public void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String empId = request.getParameter("emp_id");
		String name = request.getParameter("name");
		String deptId = request.getParameter("dept_id");
		String mobile = request.getParameter("mobile");
		String job = request.getParameter("job");
		String email = request.getParameter("email");
		String sql = "UPDATE t_employee SET name =? , dept_id = ? , mobile = ? , job = ? , email = ? WHERE emp_id = ?";
		Map result = new LinkedHashMap();
		try {
			DBUtils.executeUpdate(sql, new Object[]{name , new Integer(deptId) , mobile , new Integer(job) , email , new Integer(empId)});
			result.put("result", true);
			result.put("message", name + "的员工资料已修改成功");
		} catch (Exception e){
			e.printStackTrace();
			result.put("result", false);
			result.put("message", e.getMessage());
		}
		response.setContentType("text/json;charset=utf-8");
		response.getWriter().println(new Gson().toJson(result));
	}
	
	public void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] empIds = request.getParameterValues("emp_id");
		StringBuffer ids = new StringBuffer();
		for(String id : empIds){
			ids.append(id + ",");
		}
		;
		String sql = "DELETE FROM t_employee where emp_id in (" + ids.substring(0,ids.length() - 1) + ")";
		Map result = new LinkedHashMap();
		try {
			DBUtils.executeUpdate(sql);
			result.put("result", true);
			result.put("message" ,"员工资料已删除成功");
		} catch (Exception e){
			e.printStackTrace();
			result.put("result", false);
			result.put("message", e.getMessage());
		}
		response.setContentType("text/json;charset=utf-8");
		response.getWriter().println(new Gson().toJson(result));
	}
}
