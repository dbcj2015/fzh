package com.bjsxt.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.bjsxt.model.Employee;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Page;

public class EmployeeController extends Controller{
	public void create(){
		Integer page = this.getParaToInt("page");
		Integer row = this.getParaToInt("rows");
		Employee emp=new Employee();
		//select e.* , d.dname from t_employee e, t_department d where e.dept_id = d.dept_id order by e.emp_id asc
		//分页方法会自动帮我们select count（*） 获取所有的数据总数
		Page<Employee> p = emp.paginate(page, row, "select e.* , d.dname ", "from t_employee e, t_department d where e.dept_id = d.dept_id order by e.emp_id asc");
		System.out.println("row="+row);
		Map list=new LinkedHashMap();
		Map result = new LinkedHashMap();
		result.put("total", p.getTotalRow());//未分页的时候的记录总数
		result.put("rows", p.getList());//获取当前页的数据，getList方法返回LIst集合
		this.renderJson(result); // new Gson().toJSON()
	}
	
	public void add(){

		String name = this.getPara("name");
		Integer deptId = this.getParaToInt("dept_id");
		String mobile = this.getPara("mobile");
		Integer job = this.getParaToInt("job");
		String email = this.getPara("email");
		Employee emp=new Employee();
		emp.set("name", name).set("dept_id", deptId)
		.set("job", job).set("email", email);
		
		Map result=new LinkedHashMap();
		try{
			emp.save();//增加数据需要save
			result.put("result", true);
			result.put("message", emp.get("name") + "的员工资料已保存成功");
		}catch(Exception ex){
			ex.printStackTrace();
			result.put("result", false);
			result.put("message", ex.getMessage());
		}
		this.renderJson(result);
	}
	
	public void update(){
		Integer empId=this.getParaToInt("emp_id");
		
		String name = this.getPara("name");
		Integer deptId=this.getParaToInt("dept_id");
		String mobile = this.getPara("mobile");
		Integer job=this.getParaToInt("job");
		String email = this.getPara("email");
		Employee dao=new Employee();
		Employee e = dao.findById(empId);
		e.set("emp_id", empId).set("name", name)
		.set("dept_id", deptId)
		.set("mobile", mobile)
		.set("job", job)
		.set("email", email);
		Map result=new LinkedHashMap();
		try {
			e.update();
			result.put("result", true);
			result.put("message","员工"+name+"信息资料修改成功");
		} catch (NumberFormatException e1) {
			e1.printStackTrace();
			result.put("result", false);
			result.put("message", e1.getMessage());
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		this.renderJson(result);
	}
	
	public void delete(){
		System.out.println("JFINAL");
		Integer[] empIds=this.getParaValuesToInt("emp_id");
		System.out.println(empIds);
		Employee emp=new Employee();
		for(Integer id:empIds){
			emp.findById(id).delete();
		}
		Map result=new LinkedHashMap();
		try {
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
		this.renderJson(result);
	}
}
