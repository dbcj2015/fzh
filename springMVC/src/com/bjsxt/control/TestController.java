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
	//SPring MVC中 标准的处理请求的方式为 : public String xxx(各种各样的参数)
	//只要参数和请求中的参数名称匹配,则自动赋值,并且自动完成类型转换
	@RequestMapping("/test")
	//@DateTimeFormat(pattern="yyyy-MM-dd")解决日期格式，可以根据pattern格式输入数据格式
	public String test(String userName,String password,Float salary,String sex,@DateTimeFormat(pattern="yyyy-MM-dd") Date birthday){
		System.out.println(userName+"|"+password+"|"+salary+"|"+sex+"|"+birthday);
		return "/login.jsp";//利用请求派发跳转到指定的URL    
	}
	
	@RequestMapping("/login")
	public String index(){
		//因为请求派发是在服务器内部在一个请求中完成的,所以在Controller里面是允许访问WEB-INF下面的资源
		//如果登陆了,就跳到这个页面
		//如果没有登录,则踢到登陆页去
		return "/login";
	}
	
	@RequestMapping("/json")
	//ResponseBody这个注解说明,方法的返回值不再需要跳转页面,而是作为输出直接返回客户端
	//response.getWriter.println("{name:qiyi}")
	@ResponseBody 
	//ResponseBody这个注解说明,方法的返回值不再需要跳转页面,而是作为输出直接返回客户端
		//response.getWriter.println("{name:qiyi}")
	public String json(){
		return "{name:齐毅}";
	}
	
	@RequestMapping("/user")
	@ResponseBody
	public String create(PUser p){
		//如果参数是个实体类,则自动会将请求中的参数赋值给实体类的同名属性
		System.out.println(p);
		//String name = request.getParameter()
		//Emp emp = new EMp()
		//emp.setName(name)
		return "哈哈,处理完成啦:"+p.getUsername();
	}
}
