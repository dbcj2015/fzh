package com.bjsxt.base;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SecurityFilter implements Filter{
	
	private String[] exlist = null;
	//在初始化web.xml时执行
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		//这种方式在启动服务器的时候就会执行
		//配置文件的初始化在启动服务器的时候执行
		System.out.println("我是初始化方法");
		String exs = filterConfig.getInitParameter("exclude");//获取配置在web.xml中的exclude参数
		System.out.println(exs+"*****************");
		exlist = exs.split(",");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)resp;
		String uri = request.getRequestURI();
		//System.out.println(uri);
		//将静态资源与login登录相关的地址排除在外
		if(uri.indexOf("/resources/")!=-1){
			//System.out.println("我是静态资源");
			chain.doFilter(req, resp);//直接响应给浏览器,浏览器会将该静态资源保存在缓冲中,再次访问该登录页面就不会发送请求
			return;
		}
		
		//将exclue排除列表中的uri不做登录校验
				for(String ex : exlist){
					if(uri.endsWith(ex) == true){
						chain.doFilter(req, resp);
						return;
					}
				}
		//当点击登录后,静态资源不会重新发送，与登录功能是相互独立的
		//session对象是浏览器每次启动的时候自动产生,后台中将用户信息存储在浏览器中对应的session对象中
		HttpSession session=request.getSession();
		Object userInfo = session.getAttribute("username");
		if(userInfo!=null){
			//System.out.println("登录成功");
			chain.doFilter(req, resp);
		}else{
			//System.out.println("请重新登录");
			request.setAttribute("message", "重新登录");
			request.getRequestDispatcher("/login.jsp").forward(req, resp);
			chain.doFilter(req, resp);
		}
		//System.out.println("会不会执行?");
		
		
	}

	

}
