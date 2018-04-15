package com.bjsxt.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import com.bjsxt.util.HttpUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class NetDiskServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public NetDiskServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		//String keyword = new String(request.getParameter("q").getBytes("ISO-8859-1") , "UTF-8");
		String page = request.getParameter("p");
	 	String host = "http://netdisk.market.alicloudapi.com";
	    String path = "/search";
	    String method = "GET";
	    String appcode = "fb47d6abf17e419c81df02759a0d2ce8";
	    Map<String, String> headers = new HashMap<String, String>();
	    //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
	    headers.put("Authorization", "APPCODE " + appcode);
	    Map<String, String> querys = new HashMap<String, String>();
	    querys.put("q", request.getParameter("q"));	    querys.put("page", page);
	    try {
	    	HttpResponse r = HttpUtils.doGet(host, path, method, headers, querys);
	    	//获取response的body
	    	String text = EntityUtils.toString(r.getEntity());
	    	text=text.replaceAll("&amp;", "ASD1111");
			response.setContentType("text/html;charset=utf-8");
			System.out.println(text);
			response.getWriter().println(text);
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
