package com.bjsxt.controll;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
@Controller
@RequestMapping("/t")
@SessionAttributes({"list"})
public class ListController {
	ArrayList<Map> list=new ArrayList<>();
	public ListController(){
		for (int i = 0; i < 100; i++) {
			Map map=new HashMap<>();
			map.put("name", "name"+i);
			map.put("index", i+1);
			map.put("date", new Date());
			list.add(map);
		}
	}
	
	//(1) 利用原生对象,设置request\session属性 推荐指数 ※(不推荐)
	//优点:使用简单,会Servlet就会这种方式
	//缺点:与容器耦合,不启动Web容器(Tomcat)没法测试执行
	@RequestMapping("/request")
	public String list(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		request.setAttribute("list", list);
		return "/list";
	}
	
	@RequestMapping("/mavlist")
	public ModelAndView list(){
		ModelAndView mav=new ModelAndView("/list");
		mav.addObject("list", list);
		return mav;
	}
	
	//2. 利用ModelAndView(模型与值) 对象来设置 推荐指数:不考虑用Session的情况下※※※※※ ,使用Session的时候※
	//PS . Session能不用就不用,因为它有分布式的状态问题
	// 优点: 使用简单粗暴,与容器解耦,不依赖Tomcat就能单独访问
	// 缺点: 设置Session的时候不够友好 , @SessionAttributes({"list"})
	@RequestMapping("/mavSession")
	public ModelAndView listSession(){
		ModelAndView mav=new ModelAndView("/list");//对原生对象进行封装
		mav.addObject("list", list);
		return mav;
	}
	
	
	//3. 利用WebRequest对象传值 推荐指数:※※※※※
	//缺点: WebRequest对象并不提供单元测试的支持,虽然容器解耦,但是仍然不便于调试
	//PS. WebRequest对象是Spring MVC 对request\Session包装后的对象,可以直接用于setAttribute
	@RequestMapping("/web")
	public String list(WebRequest webRequest){
		webRequest.setAttribute("list", list, WebRequest.SCOPE_SESSION);
		//webRequest.setAttribute("list", list, WebRequest.SCOPE_SESSION); //向session存放
		//webRequest.setAttribute("list", list, WebRequest.SCOPE_GLOBAL_SESSION); //向application/ServletContext存放
		return "/list";
	}
}
