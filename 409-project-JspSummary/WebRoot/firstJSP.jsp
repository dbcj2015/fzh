<%-- <%@page import="java.util.*,javax.servlet.http.HttpServlet" %> --%>
<%--<%@page extends="HttpServlet"%> --%> <!-- HttpServlet中service()方法没有调用_jspService()方法 -->
<%@page import="java.util.*" %>
<%@page pageEncoding="utf-8"%>
<%@page errorPage="error.jsp" %> ><!--设置jsp页面在运行过程中出现问题(运行时异常)，默认跳转的页面  -->
<%
	/**
		重写error.jsp页面
	*/
	int a=3;
	int b=0;
	int c=a/b;
%>