package com.bjsxt.nw185.base;

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
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		String exs = filterConfig.getInitParameter("exclude");//获取配置在web.xml中的exclude参数
		exlist = exs.split(",");
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse) res;
		//System.out.println(request.getRequestURI()); //统一资源接口,是指在同一个域名下访问的不同地址   /user/login
		//request.getRequestURL(); //统一资源定位符 ,俗称网址 http://www.baidu.com/user/login 
		//排除静态资源
		String uri = request.getRequestURI();
		//将静态资源与login登录相关的地址排除在外
		if(uri.indexOf("/resources/") != -1){
			chain.doFilter(req, res);
			return;
		}
		//将exclue排除列表中的uri不做登录校验
		for(String ex : exlist){
			if(uri.endsWith(ex) == true){
				chain.doFilter(req, res);
				return;
			}
		}
		
		
		HttpSession session = request.getSession();
		Object loginuser = session.getAttribute("loginuser");
		if(loginuser != null){//已经登陆过啦
			chain.doFilter(req, res);//该干啥干啥去
		}else{ // 说明没有登录
			request.setAttribute("error_message", "请您重新登录!!!");
			request.getRequestDispatcher("/login.jsp").forward(req, res);
		}
	}
}
