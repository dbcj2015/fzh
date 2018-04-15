package com.bjsxt.control;


import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bjsxt.entity.PUser;

@Controller
@RequestMapping("/t")
public class TestController {
	//SPring MVC�� ��׼�Ĵ�������ķ�ʽΪ : public String xxx(���ָ����Ĳ���)
	//ֻҪ�����������еĲ�������ƥ��,���Զ���ֵ,�����Զ��������ת��
	@RequestMapping("/test")
	//@DateTimeFormat(pattern="yyyy-MM-dd")������ڸ�ʽ�����Ը���pattern��ʽ�������ݸ�ʽ
	public String test(String userName,String password,Float salary,String sex,@DateTimeFormat(pattern="yyyy-MM-dd") Date birthday){
		System.out.println(userName+"|"+password+"|"+salary+"|"+sex+"|"+birthday);
		return "/login.jsp";//���������ɷ���ת��ָ����URL    
	}
	
	@RequestMapping("/login")
	public String index(){
		//��Ϊ�����ɷ����ڷ������ڲ���һ����������ɵ�,������Controller�������������WEB-INF�������Դ
		//�����½��,���������ҳ��
		//���û�е�¼,���ߵ���½ҳȥ
		return "/login";
	}
	
	@RequestMapping("/json")
	//ResponseBody���ע��˵��,�����ķ���ֵ������Ҫ��תҳ��,������Ϊ���ֱ�ӷ��ؿͻ���
	//response.getWriter.println("{name:qiyi}")
	@ResponseBody 
	//ResponseBody���ע��˵��,�����ķ���ֵ������Ҫ��תҳ��,������Ϊ���ֱ�ӷ��ؿͻ���
		//response.getWriter.println("{name:qiyi}")
	public String json(){
		return "{name:����}";
	}
	
	@RequestMapping("/user")
	@ResponseBody
	public String create(PUser p){
		//��������Ǹ�ʵ����,���Զ��Ὣ�����еĲ�����ֵ��ʵ�����ͬ������
		System.out.println(p);
		//String name = request.getParameter()
		//Emp emp = new EMp()
		//emp.setName(name)
		return "����,���������:"+p.getUsername();
	}
}
