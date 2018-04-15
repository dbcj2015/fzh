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
		//��ҳ�������Զ�������select count��*�� ��ȡ���е���������
		Page<Employee> p = emp.paginate(page, row, "select e.* , d.dname ", "from t_employee e, t_department d where e.dept_id = d.dept_id order by e.emp_id asc");
		System.out.println("row="+row);
		Map list=new LinkedHashMap();
		Map result = new LinkedHashMap();
		result.put("total", p.getTotalRow());//δ��ҳ��ʱ��ļ�¼����
		result.put("rows", p.getList());//��ȡ��ǰҳ�����ݣ�getList��������LIst����
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
			emp.save();//����������Ҫsave
			result.put("result", true);
			result.put("message", emp.get("name") + "��Ա�������ѱ���ɹ�");
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
			result.put("message","Ա��"+name+"��Ϣ�����޸ĳɹ�");
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
			result.put("message", "�Ѿ��ɹ�ɾ��"+empIds.length+"������");
		} catch (NumberFormatException e) {
			e.printStackTrace();
			result.put("result", false);
			result.put("message", "�û�����ɾ��ʧ��");
		}catch (Exception e) {
			e.printStackTrace();
			result.put("result", false);
			result.put("message", "�û�����ɾ��ʧ��");
		}
		this.renderJson(result);
	}
}
