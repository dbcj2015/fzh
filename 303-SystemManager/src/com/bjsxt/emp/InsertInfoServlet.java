package com.bjsxt.emp;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class InsertInfoServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String oper=req.getParameter("oper");
		System.out.println("oper="+oper);
		if("create".equals(oper)){
			this.insert(req,resp);
		}else if("update".equals(oper)){
			this.update(req,resp);
		}else if("delete".equals(oper)){
			this.delete(req,resp);
		}
		
	}

	private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		String[] empIds=req.getParameterValues("emp_id");
		System.out.println(empIds);
		StringBuffer sb=new StringBuffer();
		for(String id:empIds){
			sb.append(id+",");
		}
		String sql="delete from t_employee where emp_id in("+sb.substring(0,sb.length()-1)+")";
		Map result=new LinkedHashMap();
		try {
			DBUtils.exacuteUpdate(sql);
			result.put("result",true);
			result.put("message", "已经成功删除"+empIds.length+"条数据");
		} catch (NumberFormatException e) {
			e.printStackTrace();
			result.put("result", false);
			result.put("message", "用户数据删除失败");
		}catch (Exception e) {
			e.printStackTrace();
			result.put("result", false);
			result.put("message", "用户数据删除失败");
		}
		resp.setContentType("text/json;charset=utf-8");
		resp.getWriter().print(new Gson().toJson(result));
		
	}

	private void update(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String empId=req.getParameter("emp_id");
		System.out.println(empId);
		String name = req.getParameter("name");
		System.out.println(name);
		String deptId = req.getParameter("dept_id");
		String mobile = req.getParameter("mobile");
		String job = req.getParameter("job");
		String email = req.getParameter("email");
		String sql = "UPDATE t_employee SET name =? , dept_id = ? , mobile = ? , job = ? , email = ? WHERE emp_id = ?";
		Map result=new LinkedHashMap();
		try {
			DBUtils.exacuteUpdate(sql, new Object[]{name , new Integer(deptId) , mobile , new Integer(job) , email , new Integer(empId)});
			result.put("result", true);
			result.put("message","员工"+name+"信息资料修改成功");
		} catch (NumberFormatException e) {
			e.printStackTrace();
			result.put("result", false);
			result.put("message", e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setContentType("text/json;charset=utf-8");
		//将响应数据转化为gson格式是为了获取数据方便
		resp.getWriter().print(new Gson().toJson(result));
		
	
		
	}

	private void insert(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String name = req.getParameter("name");
		String deptId = req.getParameter("dept_id");
		String mobile = req.getParameter("mobile");
		String job = req.getParameter("job");
		String email = req.getParameter("email");
		String sql="insert into t_employee(dept_id,name,mobile,job,email) values(?,?,?,?,?)";
		Map result=new LinkedHashMap();
		try {
			DBUtils.exacuteUpdate(sql, new Object[]{new Integer(deptId),name,mobile,new Integer(job),email});
			result.put("result", true);
			result.put("message","员工"+name+"信息资料添加成功");
		} catch (NumberFormatException e) {
			e.printStackTrace();
			result.put("result", false);
			result.put("message", e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setContentType("text/json;charset=utf-8");
		//将响应数据转化为gson格式是为了获取数据方便
		resp.getWriter().print(new Gson().toJson(result));
		
	}
}
