<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%--include指令学习:
	静态:
	动态:
 --%>
<%-- 
<html>
  <head>
  </head>
  <body>
   	<h3>欢迎登陆本网站</h3>
   	<%@include file="common.jsp" %>
  </body>
</html>
--%>

<html>
  <head>
  </head>
  <body>
   	<h3>欢迎登陆本网站</h3>
   	<jsp:include page="common.jsp"></jsp:include>
  </body>
</html>
















