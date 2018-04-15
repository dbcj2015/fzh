package controller;
import java.util.Date;
import java.util.List;

import com.bjsxt.model.Department;
import com.bjsxt.model.Employee;
import com.jfinal.core.Controller;
public class RegisterController extends Controller{
	//Controller中所有的方法都是public void xxx(){}
		public void reg(){
			//自动类型转换
			String name =this.getPara("uname");//request.getParameter
			Integer age = this.getParaToInt("age");
			Float salary = new Float(this.getPara("salary"));
			//Date date = this.getParaToDate("birthday");
			//response.getWriter.println();
			//输出HTML文本
			//this.renderHtml("<b>" + name + "," + age + "," + salary + "," + date +"</b>");
			//this.renderHtml("<b>" + name + "," + age + "," + salary +"</b>");
			//页面重定向
			//this.redirect("/register.jsp");
			//请求转发
			this.renderJson("/register.jsp");
			
			System.out.println("**************数据库操作*************************");
			//数据库连接
			Department d = new Department();
			d.set("dname", "研发3部");
			d.createDept(d);
			
			
			Employee e = new Employee();
			e.set("dept_id", 1).set("name", "冯志红").set("mobile", "13933102641").set("job", 2).set("email", "qiyisoft@163.com");
			e.save();
			
			//直接修改数据库中的数据
			Employee e48 = e.findById(48);//找到对应的id进行修改
			e48.set("name", "小红").set("mobile", "ADDDASDAS");
			e48.update();
			//e48.delete();
			
			
			Employee dao = new Employee();
			List<Employee> list = dao.find("select * from t_employee where name=?" , new Object[]{"齐毅"});
			System.out.println(list);
			
			
		}
}
