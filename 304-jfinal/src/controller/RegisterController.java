package controller;
import java.util.Date;
import java.util.List;

import com.bjsxt.model.Department;
import com.bjsxt.model.Employee;
import com.jfinal.core.Controller;
public class RegisterController extends Controller{
	//Controller�����еķ�������public void xxx(){}
		public void reg(){
			//�Զ�����ת��
			String name =this.getPara("uname");//request.getParameter
			Integer age = this.getParaToInt("age");
			Float salary = new Float(this.getPara("salary"));
			//Date date = this.getParaToDate("birthday");
			//response.getWriter.println();
			//���HTML�ı�
			//this.renderHtml("<b>" + name + "," + age + "," + salary + "," + date +"</b>");
			//this.renderHtml("<b>" + name + "," + age + "," + salary +"</b>");
			//ҳ���ض���
			//this.redirect("/register.jsp");
			//����ת��
			this.renderJson("/register.jsp");
			
			System.out.println("**************���ݿ����*************************");
			//���ݿ�����
			Department d = new Department();
			d.set("dname", "�з�3��");
			d.createDept(d);
			
			
			Employee e = new Employee();
			e.set("dept_id", 1).set("name", "��־��").set("mobile", "13933102641").set("job", 2).set("email", "qiyisoft@163.com");
			e.save();
			
			//ֱ���޸����ݿ��е�����
			Employee e48 = e.findById(48);//�ҵ���Ӧ��id�����޸�
			e48.set("name", "С��").set("mobile", "ADDDASDAS");
			e48.update();
			//e48.delete();
			
			
			Employee dao = new Employee();
			List<Employee> list = dao.find("select * from t_employee where name=?" , new Object[]{"����"});
			System.out.println(list);
			
			
		}
}
